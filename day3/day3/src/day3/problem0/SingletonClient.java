package day3.problem0;

public class SingletonClient {
	public SingletonClient() {
		
	}

	public void connect() {
		
		SingletonConnection connect=SingletonConnection.getInstance();
		
		connect.ConnectToDB();
		
	}

}
