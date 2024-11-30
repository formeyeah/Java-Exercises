package ir.freeland.annotation.buildin;

import java.util.ArrayList;
import java.util.List;

public class SampleSupress {
	
	@SuppressWarnings("unused")
	public void transfer(int account1 , int account2) {
		int newaccount;		
	}
	
	@SuppressWarnings("rawtypes")
	public void balance(int account1 , int account2) {
		 @SuppressWarnings("unused")
		List list = new ArrayList();
	}
}
