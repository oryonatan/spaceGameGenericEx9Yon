import java.util.Random;


public class CrazyShip extends HumanShip {
	private static final double TELEPORT_RANDOM = 0.02;

	@Override
	public void doSpecificAction(SpaceWars game) {
		Random rand = new Random(); 
		System.out.println(rand.nextDouble());
		if (rand.nextDouble() <= TELEPORT_RANDOM){
			Teleport();
		}
		super.doSpecificAction(game);
	}
}
