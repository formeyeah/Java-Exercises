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

		return null;
	}
	

	public static void encryptUserPasswords(List<User> users) throws UserServiceException {
		
		
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
            	//@TODO add inserts statements
            	int addressId = -1;
            	ResultSet generatedKeys = addressInsert.getGeneratedKeys();
            	if (generatedKeys.next()) {
                    addressId = generatedKeys.getInt(1); // Get the generated address id
                }
            	//@TODO add inserts statements
            	
                 
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
    			
				""";
		String updateAddress="""
				
				""";
		//@TODO Generate keypair
		KeyPair keyPair = null;
		int rowsAffected = 0;
	 	try{
	 		//@TODO get all address
	 		ResultSet allAddress = null;
	 		log.info("Select all addresses:" + allAddress.getFetchSize());
	 		
	 		PreparedStatement addressUpdate =  
		            ConnectionManager.getConnection().prepareStatement(updateAddress);
	 		
	 		while (allAddress.next()) {
	 			//@TODO Generateto be signed string
	 			StringBuilder tobesigned = new StringBuilder();
	 			
	 			//@TODO Sign it!
	 			String signed=null;
	 			
	 			//@TODO set statement values

	 			rowsAffected++;
			}
		            
	    } catch (SQLException e) {
	    	log.severe("Database error while signing");
			throw new UserServiceException("Database error", e);
		
	   }
	return rowsAffected;
	}
	
	public static void printActiveUsers(List<User> users) {
		//@TODO fix it

		System.out.println("Active Users");		
		users.forEach( System.out::println);
	}
	
	public static Queue<User> createNewListBaseOnDateOfBirth(List<User> users) {
		//@TODO fix it
		Queue<User> queueOfUsers = null;
	
		return queueOfUsers;
		
	}
	public static void printAdminUsersSortByEmail(List<User> users) {
		//@TODO fix it
		List<User> sortAdminUsersByEmial=null;
		
		System.out.println("Admins users sorted with email");
		sortAdminUsersByEmial.forEach(System.out::println);
		
	}
		
}
