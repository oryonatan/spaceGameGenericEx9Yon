import java.util.HashMap;
import java.util.Map;

/**
 * Factory for spaceships , has a single method that gets the user string and
 * creates an array of spaceships.
 * 
 * @author yonatan idanb
 * 
 */
public class SpaceShipFactory {

	/**
	 * Creates a list of spaceships
	 * 
	 * @param args
	 *            - from user args
	 * @return a list of spaceships
	 */
	public static SpaceShip[] createSpaceShips(String[] args) {
		// Map ship classes to string
		Map<String, Class<? extends SpaceShip>> shipTypes = new HashMap<String, Class<? extends SpaceShip>>();
		shipTypes.put("h", HumanShip.class);
		shipTypes.put("c", CrazyShip.class);
		shipTypes.put("f", FloaterShip.class);
		shipTypes.put("r", RunnerShip.class);
		shipTypes.put("b", BasherShip.class);
		shipTypes.put("a", AggressiveShip.class);
		shipTypes.put("s", SpecialShip.class);

		SpaceShip[] ships = new SpaceShip[args.length];
		for (int i = 0; i < args.length; i++) {
			try {
				// Instantiate a ship in the array
				ships[i] = (shipTypes.get(args[i]).newInstance());
			} catch (Exception e) {
				System.out.println("Illegal ship types");
			}
		}
		return ships;
	}

}
