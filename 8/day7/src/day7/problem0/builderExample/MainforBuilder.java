package day7.problem0.builderExample;


import day7.problem0.builderExample.model.HTTPConnection;

public class MainforBuilder {

	public static void main(String[] args) {
		HTTPConnection httpconnectionValidated=new HTTPConnection.Builder()
				.port(22)
				.Url("http://www.google.com")
				.username("rojina")
				.password("123456hello")
				.timeout(false)
				.build();
	}

}
