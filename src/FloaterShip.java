/** 
 * FILE : FloaterShip.java
 * WRITER : Idan Brodet + idanbr2 + 300685278
 * WRITER : Yonatan Oren + oryonatan + 300704327
 * EXERCISE : intro2cs ex9 2011-2012  
 * DESCRIPTION:
 * Floater ship, floats in a constant speed and does nothing.
 */
public class FloaterShip extends ComputerShip {

	/*
	 * Flies directly without ever changing 
	 * @see SpaceShip#doSpecificAction(SpaceWars)
	 */
	@Override
	public void doSpecificAction(SpaceWars game) {
		pos.move(false, FORWARD);
	}

}
