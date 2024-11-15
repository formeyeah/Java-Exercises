package day3.problem1;

public class MainforFileUtils {
	
	public void main(String [] args) {
		try {
			String file1=FileUtils.readfile("example.txt");
			System.out.println(file1);
			FileUtils.writefile("salam khobi", "salam.txt");
			System.out.println("wrote file");
		} catch (FileUtilsException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		
		
	}

}
