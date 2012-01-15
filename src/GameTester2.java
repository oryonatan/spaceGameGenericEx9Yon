public class GameTester2 {

	private static final int STACK_CALLING_FUNCTION_LOCATION = 2;
	private static final String NORMAL_REPORT =  "Error in :%s\n%s";
	private static final String WRONG_SPACESHIP =  "Create other spaceShip instead of ";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GameTester tester = new GameTester();
		testFactory();
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
	private static void reportError(String error, ErrorTypes type) {
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
	
	private static void testFactory() {
		String[] shipsArray = {"h", "c", "a", "b", "f", "r", "s"};
		SpaceShip[] ships =  SpaceShipFactory.createSpaceShips(shipsArray);
		if (shipsArray.length != ships.length) {
			String error =String.format("Create only %d ships instead of %d ships", ships.length, shipsArray.length);
			reportError(error, ErrorTypes.normalError);
			return;
		}
		if (!(ships[0] instanceof HumanShip)) {
			reportError(WRONG_SPACESHIP + "HumanShip",
					ErrorTypes.normalError);
		}
		if (!(ships[1] instanceof CrazyShip)) {
			reportError(WRONG_SPACESHIP + "CrazyShip",
					ErrorTypes.normalError);
		}
		if (!(ships[2] instanceof AggressiveShip)) {
			reportError(WRONG_SPACESHIP + "AggressiveShip",
					ErrorTypes.normalError);
		}
		if (!(ships[3] instanceof BasherShip)) {
			reportError(WRONG_SPACESHIP + "BasherShip",
					ErrorTypes.normalError);
		}
		if (!(ships[4] instanceof FloaterShip)) {
			reportError(WRONG_SPACESHIP + "FloaterShip",
					ErrorTypes.normalError);
		}
		if (!(ships[5] instanceof RunnerShip)) {
			reportError(WRONG_SPACESHIP + "RunnerShip",
					ErrorTypes.normalError);
		}
		if (!(ships[6] instanceof SpecialShip)) {
			reportError(WRONG_SPACESHIP + "SpecialShip",
					ErrorTypes.normalError);
		}
	}
}
