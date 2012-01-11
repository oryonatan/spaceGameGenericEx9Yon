import intro.ex9.SpaceShipPhysics;

public class SpecialShip extends ComputerShip {

	private static final int SHOTS_DELAY = 24;
	private ExtendablePhysics[] starShape = { new ExtendablePhysics(),
			new ExtendablePhysics(), new ExtendablePhysics(),
			new ExtendablePhysics(), new ExtendablePhysics() };

	public SpecialShip() {
		super();
	}

	@Override
	public void doSpecificAction(SpaceWars game) {
		pos.move(true, LEFT);
		double angleDif = Math.PI / 3;
		for (int i = 0; i < starShape.length; i++) {
			starShape[i].setAngle(pos.getAngle() + angleDif * (i + 1));
			starShape[i].setLocation(pos.getX(), pos.getY());
		}
		fire(game);
	}

	protected void fire(SpaceWars game) {
		if (shotsTurnCounter <= 0) {
			game.addShot(pos);
			for (SpaceShipPhysics direction : starShape) {
				game.addShot(direction);
			}
			shotsTurnCounter = SHOTS_DELAY;
		}
	}
}
