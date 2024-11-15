package day1.quize;

public class quize {

	public static void main(String[] args) {
		//duta list tarif konid ke to har kdom chandta esm bashe 
		//barnameyi benevisid ke esm haye tekrari to har list ro peyda kone
		String[] list1= {"rojina", "ramina", "ali", "reza", "shamim"};
		String[] list2= {"rojina", "mohamad", "sara","shamim"};
		for (String string : list1) {
			for (String string2 : list2) {
				if (string==string2) {
					String tekrari=string;
					System.out.println(tekrari +" esm tekrari");
					
				}
				
			}
		
		}
			
		}
}
