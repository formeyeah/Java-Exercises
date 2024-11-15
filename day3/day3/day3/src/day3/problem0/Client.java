package day3.problem0;

public class Client {
	private Connection con;
	
	
	
	public Client(Connection con) {
		super();
		this.con = new Connection("https://mydatabase.follow.this.link");
	}



	public void connect() {
		
		con.connectToDatabase();
	}

}
