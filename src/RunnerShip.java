/** 
 * FILE : RunnerShip.java
 * WRITER : Idan Brodet + idanbr2 + 300685278
 * WRITER : Yonatan Oren
 * EXERCISE : intro2cs ex9 2011-2012  
 * DESCRIPTION:
 * Runner, ship tries to run away from combat and teleport if being aimed at.
 */
import intro.ex9.SpaceShipPhysics;

public class RunnerShip extends ComputerShip {

	/* 
	 * (non-Javadoc)
	 * @see SpaceShip#doSpecificAction(SpaceWars)
	 */
	@Override
	public void doSpecificAction(SpaceWars game) {
		SpaceShip otherShip = game.getClosestShipTo(this);
		moveInteract(otherShip, Interaction.escape);		
		spy(otherShip);	
	}

	/**
	 * Spies on another ship , tryes to teleport if the ship is close and aiming the cannon
	 * on the runner.
	 * @param otherShip
	 */
	private void spy(SpaceShip otherShip) {
		SpaceShipPhysics otherPhysics = otherShip.getPhysics();
		if (pos.distanceFrom(otherPhysics) <= SMALL_DISTANCE) {
			if (Math.abs(otherPhysics.angleTo(pos)) < SMALL_ANGLE ) {
				Teleport();
			}
		}
	}

}
