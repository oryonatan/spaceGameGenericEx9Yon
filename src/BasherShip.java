/** 
 * FILE : BasherShip.java
 * WRITER : Idan Brodet + idanbr2 + 300685278
 * WRITER : Yonatan Oren
 * EXERCISE : intro2cs ex9 2011-2012  
 * DESCRIPTION:
 * Basher ship, pursue enemy and attempts to ram him.
 */
public class BasherShip extends ComputerShip {

	/* 
	 * (non-Javadoc)
	 * @see SpaceShip#doSpecificAction(SpaceWars)
	 */
	public void doSpecificAction(SpaceWars game) {
		SpaceShip otherShip = game.getClosestShipTo(this);
		moveInteract(otherShip, Interaction.pursue);
		//Ram with shields up
		if (otherShip.getPhysics().distanceFrom(pos) <= SMALL_DISTANCE) {
			activateShield();
		}
	}
}
