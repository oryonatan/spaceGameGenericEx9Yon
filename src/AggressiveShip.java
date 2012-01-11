public class AggressiveShip extends ComputerShip {

	@Override
	public void doSpecificAction(SpaceWars game) {
		SpaceShip otherShip = game.getClosestShipTo(this);
		moveInteract(otherShip, Interaction.pursue);
		if (pos.angleTo(otherShip.getPhysics()) <= Math.abs(SMALL_ANGLE)){
			fire(game);
		}		
	}
}
