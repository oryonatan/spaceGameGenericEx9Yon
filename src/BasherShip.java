public class BasherShip extends ComputerShip {

	@Override
	public void doSpecificAction(SpaceWars game) {
		SpaceShip otherShip = game.getClosestShipTo(this);
		moveInteract(otherShip, Interaction.pursue);
		if (otherShip.getPhysics().distanceFrom(pos) <= SMALL_DISTANCE) {
			activateShield();
		}
	}
}
