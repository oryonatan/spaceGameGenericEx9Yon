import intro.ex9.SpaceShipPhysics;

public class RunnerShip extends ComputerShip {

	@Override
	public void doSpecificAction(SpaceWars game) {
		SpaceShip otherShip = game.getClosestShipTo(this);
		moveInteract(otherShip, Interaction.escape);		
		spy(otherShip);	
	}

	private void spy(SpaceShip otherShip) {
		SpaceShipPhysics otherPhysics = otherShip.getPhysics();
		if (pos.distanceFrom(otherPhysics) <= SMALL_DISTANCE) {
			if (Math.abs(otherPhysics.angleTo(pos)) < SMALL_ANGLE ) {
				Teleport();
			}
		}
	}

}
