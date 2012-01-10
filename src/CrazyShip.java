import java.io.RandomAccessFile;
import java.util.Random;


public class CrazyShip extends HumanShip {
	private static final double TELEPORT_RANDOM = 0.02;

	@Override
	public void doSpecificAction(SpaceWars game) {
		// TODO Random teleport
		Random rand = new Random(); 
		if (rand.nextDouble() <= TELEPORT_RANDOM){
			Teleport();
		}
		// TODO Auto-generated method stub
		super.doSpecificAction(game);
	}
}
