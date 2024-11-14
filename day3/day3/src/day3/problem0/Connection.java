package day3.problem0;

public class Connection {


	public Connection(String url) {
		super();
		this.url = url;
	}

	private String url;
	
	public Connection connectToDatabase() {
		
		System.out.println("connecting to database: "+ url);
		return new Connection(url);		
		
		
		
		
	}
	

}
