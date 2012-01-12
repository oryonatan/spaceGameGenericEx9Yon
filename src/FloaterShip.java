/**
 * FloaterShip floats in a constant speed and does nothing
 * 
 * @author yonatan,idanb
 * 
 */
public class FloaterShip extends ComputerShip {

	/*
	 * (non-Javadoc)
	 * 
	 * @see SpaceShip#doSpecificAction(SpaceWars)
	 */
	@Override
	public void doSpecificAction(SpaceWars game) {
		pos.move(false, FORWARD);
	}

}
