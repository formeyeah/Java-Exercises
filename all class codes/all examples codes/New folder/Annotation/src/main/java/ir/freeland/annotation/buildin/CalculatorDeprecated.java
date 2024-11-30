package ir.freeland.annotation.buildin;

public class CalculatorDeprecated {

    public int add(int  a , int b) {
    	return a + b;
    }
    
    @Deprecated
    public int multi(int  a , int b) {
    	return a * b;
    }
}