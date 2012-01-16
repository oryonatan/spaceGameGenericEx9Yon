/** 
 * FILE : CrazyShip.java
 * WRITER : Idan Brodet + idanbr2 + 300685278
 * WRITER : Yonatan Oren + oryonatan + 300704327
 * EXERCISE : intro2cs ex9 2011-2012  
 * DESCRIPTION:
 * Crazy ship, the same as human controlled but in addition in each
 * turn there is a 2 percent chance that it will try to teleport.
 */
import java.util.Random;

public class CrazyShip extends HumanShip {
	
	private static final double TELEPORT_RANDOM = 0.02;

	/**
	 * Acts as human and randomly teleports in 2% chance.
	 * (non-Javadoc)
	 * @see HumanShip#doSpecificAction(SpaceWars)
	 */
	@Override
	public void doSpecificAction(SpaceWars game) {
		// 2 Precent chance random
		Random rand = new Random();
		if (rand.nextDouble() <= TELEPORT_RANDOM) {
			Teleport();
		}
		// Act as human
		super.doSpecificAction(game);
	}
}
