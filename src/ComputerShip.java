import intro.ex9.GameGUI;
import intro.ex9.SpaceShipPhysics;

import java.awt.Image;


public abstract class ComputerShip extends SpaceShip {
	protected enum Interaction {
		escape,
		pursue
	};
	
	protected final double SMALL_ANGLE = 0.2;
	protected final double SMALL_DISTANCE = 0.2;
	
	public Image getImage(){
		if (shieldsUp){
			return GameGUI.ENEMY_SPACESHIP_IMAGE_SHIELD;
		}
		return GameGUI.ENEMY_SPACESHIP_IMAGE;
	}
	
	protected void moveInteract(SpaceShip otherShip , Interaction action) {
		SpaceShipPhysics otherPhysics =  otherShip.getPhysics();
		int direction = FORWARD;
		if (pos.angleTo(otherPhysics) < 0) {
			if (action == Interaction.pursue) {
				direction = RIGHT;
			}
			else {
				direction = LEFT;
			}
		}
		else if (pos.angleTo(otherPhysics) > 0) {
			if (action == Interaction.pursue) {
				direction = LEFT;
			}
			else {
				direction = RIGHT;
			}
		}
		pos.move(true, direction);
	}
}
