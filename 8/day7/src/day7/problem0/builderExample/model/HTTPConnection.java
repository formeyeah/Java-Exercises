package day7.problem0.builderExample.model;

public class HTTPConnection {
	private int port;
	private String Url;
	private String username;
	private String passwrod;
	private boolean timeout;
	
	private HTTPConnection(Builder builder) {
		this.port=port;
		this.Url=Url;
		this.username=username;
		this.passwrod=passwrod;
		this.timeout=timeout;
		
		
	}


	public int getPort() {
		return port;
	}

	public String getUrl() {
		return Url;
	}

	public String getUsername() {
		return username;
	}

	public String getPasswrod() {
		return passwrod;
	}

	public boolean isTimeout() {
		return timeout;
	}
	
	public static class Builder {
		private int port;
		private String Url;
		private String username;
		private String passwrod;
		private boolean timeout;
		
		public Builder port(int port) {
			this.port=port;
			return this;
		}
		public Builder Url(String Url) {
			this.Url=Url;
			return this;
		}
		
		public Builder username(String username) {
			this.username=username;
			return this;
		}
		public Builder password(String password) {
			this.passwrod=password;
			return this;
		}
		
		public Builder timeout(boolean timeout) {
			this.timeout=timeout;
			return this;
		}
		public HTTPConnection build() {
			if (timeout==false && Url.toLowerCase().startsWith("http")) {
				return new HTTPConnection(this);
			}
			else {
				throw new IllegalArgumentException("you have entered sth wrong");
			}
		}
		
	}

}
