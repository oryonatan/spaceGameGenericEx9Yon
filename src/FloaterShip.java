/** 
 * FILE : FloaterShip.java
 * WRITER : Idan Brodet + idanbr2 + 300685278
 * WRITER : Yonatan Oren
 * EXERCISE : intro2cs ex9 2011-2012  
 * DESCRIPTION:
 * Floater ship, floats in a constant speed and does nothing.
 */
public class FloaterShip extends ComputerShip {

	/*
	 * (non-Javadoc)
	 * @see SpaceShip#doSpecificAction(SpaceWars)
	 */
	@Override
	public void doSpecificAction(SpaceWars game) {
		pos.move(false, FORWARD);
	}

}
