/**
 * AggressiveShip , pursue enemy and attemp to shoot him
 * 
 * @author yonatan idanb
 */
public class AggressiveShip extends ComputerShip {

	/* (non-Javadoc)
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
