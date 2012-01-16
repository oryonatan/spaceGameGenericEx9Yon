/** 
 * FILE : BasherShip.java
 * WRITER : Idan Brodet + idanbr2 + 300685278
 * WRITER : Yonatan Oren + oryonatan + 300704327
 * EXERCISE : intro2cs ex9 2011-2012  
 * DESCRIPTION:
 * Basher ship, pursue enemy and attempts to ram him.
 */
public class BasherShip extends ComputerShip {

	/* 
	 * Pursue other ships , and try to ram her with shield on
	 * @see SpaceShip#doSpecificAction(SpaceWars)
	 */
	public void doSpecificAction(SpaceWars game) {
		SpaceShip otherShip = game.getClosestShipTo(this);
		moveInteract(otherShip, Interaction.pursue);
		// Ram with shields up
		if (otherShip.getPhysics().distanceFrom(pos) <= SMALL_DISTANCE) {
			activateShield();
		}
	}
}
