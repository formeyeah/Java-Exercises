package day6.problem0;

public class Country {
	private String countryName;

	@Override
	public String toString() {
		return "Country [countryName=" + countryName + "]";
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Country(String countryName) {
		super();
		this.countryName = countryName;
	}

	public Country() {
		// TODO Auto-generated constructor stub
	}

}
