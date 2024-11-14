package day3.problem0;

public class SingletonConnection {
	private static SingletonConnection instance;
	
	private SingletonConnection() {
		
		
	}
	
	public static SingletonConnection getInstance() {
		if (instance==null) {
		 instance=new SingletonConnection();
			return instance;
			
		}
		return instance;
		
	}
	public void ConnectToDB() {
		System.out.println("connecting to db");
		
		
	}

}
