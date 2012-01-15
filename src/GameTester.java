import java.awt.Image;

public class GameTester {
private static final String EXPHY_ANGLE_WRONG = "Extended physics Angle is wrong";
private static final String EXPHY_Y_WRONG = "Extended physics x is wrong";
private static final String EXPHY_X_WRONG = "Extended physics x is wrong";
private static final String SHIP_NOT_DEAD_COLLISIONS = "Ship did not die after 10 collisions";;
private static final String SHIP_NOT_DEAD_SHOTS = "Ship did not die after 10 shots";
private static final int STACK_CALLING_FUNCTION_LOCATION = 2;
private static final String NORMAL_REPORT =  "Error in :%s\n%s";
private static final int MAX_HEALTH = 10;
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GameTester tester = new GameTester();
		tester.testFactory();
		tester.testExPhysics();
		tester.testHits();
		tester.testInterShipaction();
	}
	
	private void testInterShipaction() {
		SpaceShip enterprise = new SpaceShip() {
			
			@Override
			public Image getImage() {
				return null;
			}
			
			@Override
			public void doSpecificAction(SpaceWars game) {
			}
		};
		SpaceShip serenity = new RunnerShip();		
		double angle = serenity.getPhysics().angleTo(enterprise.getPhysics()); 
		
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

	/**
	 * Tests what happens when the ship is hit shoots 10 missiles to the ship ,
	 * and collides its 10 times
	 */
	private void testHits() {
		SpaceShip enterprise = new HumanShip();
		for (int health = 0; health < MAX_HEALTH; health++) {
			enterprise.gotHit();
		}
		if (!enterprise.isDead()) {
			reportError(SHIP_NOT_DEAD_SHOTS, ErrorTypes.normalError);
		}
		enterprise.reset();
		for (int health = 0; health < MAX_HEALTH; health++) {
			enterprise.collidedWithAnotherShip();
		}
		if (!enterprise.isDead()) {
			reportError(SHIP_NOT_DEAD_COLLISIONS, ErrorTypes.normalError);
		}
	}

	private void testExPhysics() {
		ExtendablePhysics exPhy =  new ExtendablePhysics();
		exPhy.setLocation(0, 0);
		if(exPhy.getX()!= 0){
			reportError(EXPHY_X_WRONG, ErrorTypes.normalError);
		}
		if(exPhy.getY()!= 0){
			reportError(EXPHY_Y_WRONG, ErrorTypes.normalError);
		}		
		exPhy.setAngle(0);
		if(exPhy.getAngle()!= 0){
			reportError(EXPHY_ANGLE_WRONG, ErrorTypes.normalError);
		}		
		
	}

	private void testFactory() {
		String[] shipsArray = {"h", "c", "a", "b", "f", "r", "s"};
		SpaceShip[] ships =  SpaceShipFactory.createSpaceShips(shipsArray);
		if (shipsArray.length != ships.length) {
			reportError("Create only " + ships.length + "ships instead of " + shipsArray.length + " ships",
					ErrorTypes.normalError);
			return;
		}
		if (!(ships[0] instanceof HumanShip)) {
			reportError("Create other spaceShip instead of HumanShip",
					ErrorTypes.normalError);
		}
		if (!(ships[1] instanceof CrazyShip)) {
			reportError("Create other spaceShip instead of CrazyShip",
					ErrorTypes.normalError);
		}
		if (!(ships[2] instanceof AggressiveShip)) {
			reportError("Create other spaceShip instead of AggressiveShip",
					ErrorTypes.normalError);
		}
		if (!(ships[3] instanceof BasherShip)) {
			reportError("Create other spaceShip instead of BasherShip",
					ErrorTypes.normalError);
		}
		if (!(ships[4] instanceof FloaterShip)) {
			reportError("Create other spaceShip instead of FloaterShip",
					ErrorTypes.normalError);
		}
		if (!(ships[5] instanceof RunnerShip)) {
			reportError("Create other spaceShip instead of RunnerShip",
					ErrorTypes.normalError);
		}
		if (!(ships[6] instanceof SpecialShip)) {
			reportError("Create other spaceShip instead of SpecialShip",
					ErrorTypes.normalError);
		}
	}

}
