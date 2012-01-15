import intro.ex9.GameGUI;
import intro.ex9.SpaceShipPhysics;

public class GameTester {
	private static final int STACK_CALLING_FUNCTION_LOCATION = 2;
	private static final int TELEPORT_ENERGY = 150;
	private static final int MAX_HEALTH = 10;
	private static final int STARTING_ENERGY = 200;
	private static final int STARTING_HEALTH = 10;
	private static final String SPECIAL_SHIP = "SpecialShip";
	private static final String RUNNER_SHIP = "RunnerShip";
	private static final String FLOATER_SHIP = "FloaterShip";
	private static final String BASHER_SHIP = "BasherShip";
	private static final String AGGRESSIVE_SHIP = "AggressiveShip";
	private static final String CRAZY_SHIP = "CrazyShip";
	private static final String HUMAN_SHIP = "HumanShip";
	private static final String NORMAL_REPORT = "Error in :%s\n%s";
	private static final String WRONG_SHIP_COUNT = "Create only %d ships instead of %d ships";
	private static final String TELEPORT_ENERGY_ERROR = "Teleport did not take the required ammount of energy";
	private static final String TELEPORT_PHYS = "Teleport did not reset location";
	private static final String PHYSICS_OBJECT = "Physics object not instantiated";
	private static final String SHIP_DOA = "Ship dead in creation";
	private static final String HEALTH_INITIALIZE_ERR = "Ship initialized with wrong health level";
	private static final String ENERGY_INITIALIZE_ERR = "Ship initialized with wrong energy level";
	private static final String EXPHY_ANGLE_WRONG = "Extended physics Angle is wrong";
	private static final String EXPHY_Y_WRONG = "Extended physics y is wrong";
	private static final String EXPHY_X_WRONG = "Extended physics x is wrong";
	private static final String SHIP_NOT_DEAD_COLLISIONS = "Ship did not die after 10 collisions";;
	private static final String SHIP_NOT_DEAD_SHOTS = "Ship did not die after 10 shots";
	private static final String SHIP_SHIELD_DOWN = "Ship shield is down when shold be up";
	private static final String COMP_IMAGE_NORMAL = "Computer ship has wrong normal image";
	private static final String COMP_IMAGE_SHIELDED = "Computer ship has wrong shielded image";
	private static final String HUMAN_IMAGE_NORMAL = "Human ship has wrong normal image";
	private static final String HUMAN_IMAGE_SHIELDED = "Human ship has wrong shielded image";
	private static final String SHIP_DEAD_SHOTS_SHIELDUP = "Ship died after shot with shield";
	private static final String SHIP_DEAD_COLL_SHIELDUP = "Ship died after coliding with shield";
	private static final String WRONG_SPACESHIP = "Create other spaceShip instead of ";

	/**
	 * Runs the tester
	 * 
	 * @param args user args
	 */
	public static void main(String[] args) {
		testSpaceShip();
		testExPhysics();
		testFactory();
	}

	/**
	 * Tests the spaceship behavior Tests ctors Tests Shields Tests physics
	 * Tests teleport Tests hits The computer ship is different only in the
	 * images , in other methods there is no difference between user and
	 * computer.
	 */
	private static void testSpaceShip() {
		HumanShip serenity = new HumanShip();
		AggressiveShip deathStar = new AggressiveShip();
		testCtors(serenity);
		testImages(serenity, deathStar);
		testShieldUp(serenity);
		testPhysics(serenity);
		testTeleport(serenity);
		testHits(serenity);
	}

	/**
	 * Tests the physics object
	 * 
	 * @param ship
	 *            the ship to test on
	 */
	private static void testPhysics(SpaceShip ship) {
		if (!(ship.getPhysics() instanceof SpaceShipPhysics)) {
			reportError(PHYSICS_OBJECT);
		}
	}

	/**
	 * Tests the shield activation method
	 * 
	 * @param ship
	 *            the ship to test on
	 */
	private static void testShieldUp(SpaceShip ship) {
		ship.activateShield();
		if (ship.shieldsUp != true) {
			reportError(SHIP_SHIELD_DOWN);
		}
	}

	/**
	 * Tests the ctors of the spaceship
	 * 
	 * @param ship
	 *            the ship to test on
	 */
	private static void testCtors(SpaceShip ship) {
		if (ship.energy != STARTING_ENERGY) {
			reportError(ENERGY_INITIALIZE_ERR);
		}
		if (ship.health != STARTING_HEALTH) {
			reportError(HEALTH_INITIALIZE_ERR);
		}
		if (ship.isDead()) {
			reportError(SHIP_DOA);
		}
	}

	/**
	 * Tests the images , when shielded/unshielded
	 * 
	 * @param human
	 *            a human ship
	 * @param computer
	 *            a computer ship
	 */
	private static void testImages(HumanShip human, ComputerShip computer) {
		human.shieldsUp = false;
		if (!human.getImage().equals(GameGUI.SPACESHIP_IMAGE)) {
			reportError(HUMAN_IMAGE_NORMAL);
		}
		human.shieldsUp = true;
		if (!human.getImage().equals(GameGUI.SPACESHIP_IMAGE_SHIELD)) {
			reportError(HUMAN_IMAGE_SHIELDED);
		}
		computer.shieldsUp = false;
		if (!computer.getImage().equals(GameGUI.ENEMY_SPACESHIP_IMAGE)) {
			reportError(COMP_IMAGE_NORMAL);
		}
		computer.shieldsUp = true;
		if (!computer.getImage().equals(GameGUI.ENEMY_SPACESHIP_IMAGE_SHIELD)) {
			reportError(COMP_IMAGE_SHIELDED);
		}

	}

	/**
	 * Tests the teleport behavior.
	 * 
	 * @param ship
	 *            the ship to test on
	 */
	private static void testTeleport(SpaceShip ship) {
		ship.energy = STARTING_ENERGY;
		SpaceShipPhysics location = ship.getPhysics();
		ship.Teleport();
		if (location.equals(ship.getPhysics())) {
			reportError(TELEPORT_PHYS);
		}
		if (ship.energy != (STARTING_ENERGY - TELEPORT_ENERGY)) {
			reportError(TELEPORT_ENERGY_ERROR);
		}
	}

	/**
	 * Report error to stdout , report calling function name and error
	 * 
	 * @param error
	 *            the error string
	 * @param type
	 *            type of error message to show
	 */
	private static void reportError(String error) {
		// Get calling function name
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		String callingFunction = stackTrace[STACK_CALLING_FUNCTION_LOCATION]
				.toString();
		System.out.printf(NORMAL_REPORT, callingFunction, error);

	}

	/**
	 * Tests what happens when the ship is hit shoots 10 missiles to the ship ,
	 * and collides its 10 times , both shielded and unshielded
	 * 
	 * @param ship
	 *            the ship to test on
	 */
	private static void testHits(SpaceShip ship) {
		// Tests without shield
		ship.reset();
		if (!diedAfterTenHits(ship)) {
			reportError(SHIP_NOT_DEAD_SHOTS);
		}
		ship.reset();
		if (!diedAfterTenCollisions(ship)) {
			reportError(SHIP_NOT_DEAD_COLLISIONS);
		}
		ship.reset();
		// Tests with shield
		ship.activateShield();
		if (diedAfterTenHits(ship)) {
			reportError(SHIP_DEAD_SHOTS_SHIELDUP);
		}
		;
		ship.reset();
		ship.activateShield();
		if (diedAfterTenCollisions(ship)) {
			reportError(SHIP_DEAD_COLL_SHIELDUP);
		}
	}

	/**
	 * Tests if the ship dies after getting shot ten times
	 * 
	 * @param ship
	 *            the ship to test on
	 * @return true if dead , false otherwise
	 */
	private static boolean diedAfterTenHits(SpaceShip ship) {
		for (int health = 0; health < MAX_HEALTH; health++) {
			ship.gotHit();
		}
		if (ship.isDead()) {
			return true;
		}
		return false;
	}

	/**
	 * Tests if the ship dies after getting colliding
	 * 
	 * @param ship
	 *            the ship to test on
	 * @return true if dead , false otherwise
	 */
	private static boolean diedAfterTenCollisions(SpaceShip ship) {
		for (int health = 0; health < MAX_HEALTH; health++) {
			ship.collidedWithAnotherShip();
		}
		if (ship.isDead()) {
			return true;
		}
		return false;
	}

	/**
	 * Test the behavior of the extended physics object
	 * 
	 */
	private static void testExPhysics() {
		ExtendablePhysics exPhy = new ExtendablePhysics();
		exPhy.setLocation(0, 0);
		if (exPhy.getX() != 0) {
			reportError(EXPHY_X_WRONG);
		}
		if (exPhy.getY() != 0) {
			reportError(EXPHY_Y_WRONG);
		}
		exPhy.setAngle(0);
		if (exPhy.getAngle() != 0) {
			reportError(EXPHY_ANGLE_WRONG);
		}

	}

	/**
	 * Tests the factory that creates the ships tests the number of ships
	 * created tests if each ship is of the accurate type
	 */
	private static void testFactory() {
		String[] shipsArray = { "h", "c", "a", "b", "f", "r", "s" };
		SpaceShip[] ships = SpaceShipFactory.createSpaceShips(shipsArray);
		if (shipsArray.length != ships.length) {
			String error = String.format(WRONG_SHIP_COUNT, ships.length,
					shipsArray.length);
			reportError(error);
			return;
		}
		if (!(ships[0] instanceof HumanShip)) {
			reportError(WRONG_SPACESHIP + HUMAN_SHIP);
		}
		if (!(ships[1] instanceof CrazyShip)) {
			reportError(WRONG_SPACESHIP + CRAZY_SHIP);
		}
		if (!(ships[2] instanceof AggressiveShip)) {
			reportError(WRONG_SPACESHIP + AGGRESSIVE_SHIP);
		}
		if (!(ships[3] instanceof BasherShip)) {
			reportError(WRONG_SPACESHIP + BASHER_SHIP);
		}
		if (!(ships[4] instanceof FloaterShip)) {
			reportError(WRONG_SPACESHIP + FLOATER_SHIP);
		}
		if (!(ships[5] instanceof RunnerShip)) {
			reportError(WRONG_SPACESHIP + RUNNER_SHIP);
		}
		if (!(ships[6] instanceof SpecialShip)) {
			reportError(WRONG_SPACESHIP + SPECIAL_SHIP);
		}
	}
}
