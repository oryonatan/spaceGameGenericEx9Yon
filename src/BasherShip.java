/** AggressiveShip , pursue enemy and attempts to ram him
 * @author yonatan , idanb
 *
 */
public class BasherShip extends ComputerShip {

	/* (non-Javadoc)
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
