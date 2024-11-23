package day6.problem0;

public class Department {
	private String departmentName;
	private Country departmentCountry;

	public Country getDepartmentCountry() {
		return departmentCountry;
	}

	public void setDepartmentCountry(Country countryObject) {
		this.departmentCountry = countryObject;
	}

	public Department(String departmentName, Country departmentCountry) {
		super();
		this.departmentName = departmentName;
		this.departmentCountry = departmentCountry;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Department(String departmentName) {
		super();
		this.departmentName = departmentName;
	}

	public Department() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Department [departmentName=" + departmentName + ", departmentCountry=" + departmentCountry + "]";
	}


}
