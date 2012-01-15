/** 
 * FILE : AggressiveShip.java
 * WRITER : Idan Brodet + idanbr2 + 300685278
 * WRITER : Yonatan Oren
 * EXERCISE : intro2cs ex9 2011-2012  
 * DESCRIPTION:
 * AggressiveShip, pursue enemy and attempt to shoot him.
 */
public class AggressiveShip extends ComputerShip {

	/* 
	 * (non-Javadoc)
	 * @see SpaceShip#doSpecificAction(SpaceWars)
	 */
	@Override
	public void doSpecificAction(SpaceWars game) {
		SpaceShip otherShip = game.getClosestShipTo(this);
		// Pursue
		moveInteract(otherShip, Interaction.pursue);
		// Get angle and shoot if good
		if (pos.angleTo(otherShip.getPhysics()) <= Math.abs(SMALL_ANGLE)) {
			fire(game);
		}
	}
}
