/**
 * FILE : RunnerShip.java
 * WRITER : Idan Brodet + idanbr2 + 300685278
 * WRITER : Yonatan Oren
 * EXERCISE : intro2cs ex9 2011-2012  
 * DESCRIPTION:
 * Factory for spaceships , has a single method that gets the user string and
 * creates an array of spaceships.
 */
import java.util.HashMap;
import java.util.Map;

public class SpaceShipFactory {

	/**
	 * Creates a list of spaceships 
	 * @param args From user args
	 * @return A list of spaceships
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
