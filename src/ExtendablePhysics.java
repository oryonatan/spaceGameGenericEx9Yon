import intro.ex9.SpaceShipPhysics;


public class ExtendablePhysics extends SpaceShipPhysics {
	protected void setAngle(double angle) {
		_angle = angle;
	}
	
	protected void setLocation(double x,double y){
		_x = x;
		_y = y;
	}
}
