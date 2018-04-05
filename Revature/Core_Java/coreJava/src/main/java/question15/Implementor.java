package question15;

/**
 * @author Brandon Semba
 * 
 * Demonstrates the implementation of an interface
 *
 */
public class Implementor implements InterfaceDemo {

	public int addition(int operand1, int operand2) {
		return operand1 + operand2;
	}

	public int subtraction(int operand1, int operand2) {
		return operand1 - operand2;
	}

	public int multiplication(int operand1, int operand2) {
		return operand1 * operand2;
	}

	public int division(int operand1, int operand2) {
		if(operand2 == 0) {
			throw new ArithmeticException();
		}else {
			return operand1 / operand2;
		}
	}

}
