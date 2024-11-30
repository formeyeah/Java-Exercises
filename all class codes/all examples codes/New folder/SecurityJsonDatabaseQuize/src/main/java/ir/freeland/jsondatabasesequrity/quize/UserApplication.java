package ir.freeland.jsondatabasesequrity.quize;

import java.io.FileInputStream;
import java.util.List;
import java.util.logging.LogManager;
import ir.freeland.jsondatabasesequrity.quize.model.User;
import ir.freeland.jsondatabasesequrity.quize.service.UserService;

public class UserApplication {
	

	public static void main(String[] args) throws Exception {		
		LogManager.getLogManager().readConfiguration(new FileInputStream("logging.properties") );
		
		List<User> users = UserService.readAUsers("data-users.json"); //json example
		UserService.printActiveUsers(users); //collections example
		
		UserService.printAdminUsersSortByEmail(users);//collections example
		
		UserService.createNewListBaseOnDateOfBirth(users);//collections example
		
		UserService.encryptUserPasswords(users); //security example
		UserService.saveUsersAndAddressToDB(users); //security example
		
		
		UserService.signAddress(); //security example	
	}
}