public class FloaterShip extends ComputerShip {

	@Override
	public void doSpecificAction(SpaceWars game) {
		pos.move(false, FORWARD);
	}

}
