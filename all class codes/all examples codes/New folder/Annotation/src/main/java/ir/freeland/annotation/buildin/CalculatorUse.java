package ir.freeland.annotation.buildin;


class CalculatorUse  {

	public CalculatorUse(String message) {
		CalculatorDeprecated calculator =  new CalculatorDeprecated();
		calculator.multi(12, 15);
	}
}