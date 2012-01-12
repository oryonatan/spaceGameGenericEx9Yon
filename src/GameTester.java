

import intro.ex9.SpaceShipPhysics;


public class GameTester {
private static final int STACK_CALLING_FUNCTION_LOCATION = 2;
private static final String NORMAL_REPORT =  "Error in :%s\n%s"; 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GameTester tester = new GameTester();
		tester.testFactory();
		tester.testPhysics();
		tester.testHits();
	}
	
	/**Lists of error types
	 *
	 */
	private enum ErrorTypes{
		normalError,
	}

	/**
	 * Report error to stdout , report calling function name and error
	 * 
	 * @param error
	 *            the error string
	 * @param type
	 *            type of error message to show
	 */
	private void reportError(String error, ErrorTypes type) {
		// Get calling function name
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		String callingFunction = stackTrace[STACK_CALLING_FUNCTION_LOCATION]
				.toString();

		switch (type) {
		case normalError:
			System.out.printf(NORMAL_REPORT, callingFunction, error);
			break;
		}
	}

	private void testHits() {
		
	}

	private void testPhysics() {
		// TODO Auto-generated method stub
		
	}

	private void testFactory() {
		// TODO Auto-generated method stub
		
	}

}
