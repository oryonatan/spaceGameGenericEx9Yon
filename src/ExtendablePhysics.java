/** 
 * FILE : ExtendablePhysics.java
 * WRITER : Idan Brodet + idanbr2 + 300685278
 * WRITER : Yonatan Oren
 * EXERCISE : intro2cs ex9 2011-2012  
 * DESCRIPTION:
 * Extension to the physics , allows interaction with the location of the 
 * physics object and with the angle.
 */
import intro.ex9.SpaceShipPhysics;

public class ExtendablePhysics extends SpaceShipPhysics {
	
	/**
	 * Sets the angle to a given angle
	 * @param angle the angle to set to
	 */
	protected void setAngle(double angle) {
		_angle = angle;
	}
	
	/**
	 * Changes the location of the physics object
	 * @param x the x value to put
	 * @param y the y value to put
	 */
	protected void setLocation(double x,double y){
		_x = x;
		_y = y;
	}
}
