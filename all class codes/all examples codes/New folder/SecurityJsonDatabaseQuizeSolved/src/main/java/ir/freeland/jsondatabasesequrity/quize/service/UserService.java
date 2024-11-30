package ir.freeland.jsondatabasesequrity.quize.service;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import ir.freeland.jsondatabasesequrity.quize.model.User;
import ir.freeland.jsondatabasesequrity.quize.service.exception.UserServiceException;
import ir.freeland.jsondatabasesequrity.quize.utils.SecurityUtils;


public class UserService {
	private static final Logger log = Logger.getLogger(UserService.class.getName());
	

	public static List<User> readAUsers(String fileName) throws UserServiceException {
		//Open file		
		File file = new File(fileName);
		log.info("Reading file: " + fileName);
		
		ObjectMapper mapper= 
				JsonMapper.builder()
				.enable( MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS )
				.enable( MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES )				
				.build()
				.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
				.registerModule(new JavaTimeModule());
		List<User> users = new ArrayList<>();
		try {
			users = mapper.readValue(file, new TypeReference<List<User>>() {});
		} catch (DatabindException e) {
			log.severe("Can not bind check the content: " + fileName);
			throw new UserServiceException("Can not bind", e);
		} catch (IOException e) {
			log.severe("Can not read file " + fileName);
			throw new UserServiceException("Can not read ", e);
		}
		System.out.println("All users read from json. total:" + users.size());
		users.forEach( System.out::println);
		return users;
	}
	

	public static void encryptUserPasswords(List<User> users) throws UserServiceException {
		try {
			SecretKey secretKey = SecurityUtils.generateKey();
			for (User user : users) {
				String encyptedPassword = SecurityUtils.encrypt( user.getPassword(), secretKey);
				user.setPassword(encyptedPassword);
			}
			SecurityUtils.saveKeyToKeyStore(secretKey);
			
		}  catch (GeneralSecurityException  e) {
			log.severe("Can not encypt password ");
			throw new UserServiceException("Can not encypt password", e);
		} catch (IOException  e) {
			log.severe("Can not save key to key store ");
			throw new UserServiceException("Can not save key to key store ", e);
		}
		System.out.println("User passwords are encripted now:");		
		users.forEach( System.out::println);
		
	}
	

	public static int saveUsersAndAddressToDB(List<User> users) throws UserServiceException {
		String insertUser ="""
    			INSERT INTO USERS (FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, DATE_OF_BIRTH, IS_ACTIVE, PROFILE_PICTURE_URL, CREATED_AT, UPDATED_AT, ADDRESS_ID) 
    			VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
				""";
		String insertAddress="""
				INSERT INTO ADDRESS (STREET, CITY, STATE, ZIP_CODE) VALUES (?, ?, ?, ?)
				""";
		
		int rowsAffected = 0;
	 	try{
	 		PreparedStatement userInsert =  
		            ConnectionManager.getConnection().prepareStatement(insertUser);
	 		PreparedStatement addressInsert =  
		            ConnectionManager.getConnection().prepareStatement(insertAddress,PreparedStatement.RETURN_GENERATED_KEYS);
	 		log.info("Connected to the H2 database successfully!");
	 		
            for (User user : users) {
            	addressInsert.setString(1, user.getAddress().getStreet());
            	addressInsert.setString(2, user.getAddress().getCity());
            	addressInsert.setString(3, user.getAddress().getState());
            	addressInsert.setString(4, user.getAddress().getZipCode());
            	addressInsert.executeUpdate();
            	int addressId = -1;
            	ResultSet generatedKeys = addressInsert.getGeneratedKeys();
            	if (generatedKeys.next()) {
                    addressId = generatedKeys.getInt(1); // Get the generated address id
                }
            	 userInsert.setString(1, user.getFirstName());
                 userInsert.setString(2, user.getLastName());
                 userInsert.setString(3, user.getEmail());
                 userInsert.setString(4, user.getPassword());
                 userInsert.setDate(5, 	Date.valueOf(user.getDateOfBirth())); // Assuming dateOfBirth is a LocalDate
                 userInsert.setBoolean(6, user.isActive());
                 userInsert.setString(7, user.getProfilePictureUrl());
                 userInsert.setTimestamp(8, Timestamp.valueOf(user.getCreatedAt()));
                 userInsert.setTimestamp(9, Timestamp.valueOf(user.getUpdatedAt()));                 
                 userInsert.setInt(10, addressId); 
                 userInsert.executeUpdate();
                 
                 rowsAffected++;
			}  
	            
	    } catch (SQLException e) {
	    	log.severe("Database error while saveing");
			throw new UserServiceException("Database error", e);
		
	   }
	return rowsAffected;
	}


	public static int signAddress() throws UserServiceException, GeneralSecurityException {
		String selectAddress ="""
    			SELECT * FROM ADDRESS;
				""";
		String updateAddress="""
				UPDATE ADDRESS SET SIGN=? WHERE ADDRESS_ID=?
				""";
		KeyPair keyPair = SecurityUtils.generateKeypair(); 
		int rowsAffected = 0;
	 	try{
	 		ResultSet allAddress =  
		            ConnectionManager.getConnection().createStatement().executeQuery(selectAddress);
	 		
	 		log.info("Select all addresses:" + allAddress.getFetchSize());
	 		
	 		PreparedStatement addressUpdate =  
		            ConnectionManager.getConnection().prepareStatement(updateAddress);
	 		
	 		while (allAddress.next()) {
	 			StringBuilder tobesigned = new StringBuilder();
	 			tobesigned.append( allAddress.getString("STREET") )
	 					  .append("|")
	 					  .append( allAddress.getString("CITY") );
	 			
	 			String signed=SecurityUtils.sign(tobesigned.toString(), keyPair.getPrivate());
	 			
	 			addressUpdate.setString(1, signed);
	 			addressUpdate.setInt   (2, allAddress.getInt("ADDRESS_ID"));
	 			
	 			
	 			addressUpdate.executeUpdate();
	 			rowsAffected++;
			}
		            
	    } catch (SQLException e) {
	    	log.severe("Database error while signing");
			throw new UserServiceException("Database error", e);
		
	   }
	return rowsAffected;
	}
	
	public static void printActiveUsers(List<User> users) {
		Map <Boolean, List <User>> 
			partitionUsers=users
							.stream()
							.collect( Collectors.groupingBy( u -> u.isActive() ) );
		
		partitionUsers
			.get(true)
			.forEach( System.out::println);
		System.out.println("Active Users");		
		users.forEach( System.out::println);
	}
	
	public static Queue<User> createNewListBaseOnDateOfBirth(List<User> users) {
		Queue<User> queueOfUsers = new PriorityQueue<>( Comparator.comparing(User::getDateOfBirth) );
		
		users.forEach( t -> queueOfUsers.add(t) );		
		
		System.out.println("Queue of users base on the birthday");		
		//normal forEach dosn't guaranteed to run sorted
	
		return queueOfUsers;
		
	}
	public static void printAdminUsersSortByEmail(List<User> users) {
		List<User> sortAdminUsersByEmial=
			 users.stream()
			.filter(t -> t.getRoles().contains("admin"))
			.sorted((o1, o2) -> o1.getEmail().compareTo(o2.getEmail()))
			.collect(Collectors.toList());
		
		System.out.println("Admins users sorted with email");
		sortAdminUsersByEmial.forEach(System.out::println);
		
	}
		
}
