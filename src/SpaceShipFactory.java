import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class SpaceShipFactory {

	public static SpaceShip[] createSpaceShips(String[] args) {
		Map<String, Class<? extends SpaceShip>> shipTypes = new HashMap<String,Class<? extends SpaceShip>>();
		shipTypes.put("h",HumanShip.class);
		shipTypes.put("c",CrazyShip.class);
		shipTypes.put("f", FloaterShip.class);
		shipTypes.put("r", RunnerShip.class);
		shipTypes.put("b", BasherShip.class);
		shipTypes.put("a", AggressiveShip.class);
		shipTypes.put("s", SpecialShip.class);
		
		ArrayList<SpaceShip> ships = new ArrayList<SpaceShip>();
		for (String spaceShip : args) {
			try {
				ships.add(shipTypes.get(spaceShip).newInstance());
			} catch (Exception e) {
				System.out.println("Illegal ship types");
			}
		}
		return (ships.toArray(new SpaceShip[args.length]));
	}

}
