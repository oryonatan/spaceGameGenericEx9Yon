import intro.ex9.GameGUI;

import java.awt.Image;


public abstract class ComputerShip extends SpaceShip {
	public Image getImage(){
		if (shieldsUp){
			return GameGUI.ENEMY_SPACESHIP_IMAGE_SHIELD;
		}
		return GameGUI.ENEMY_SPACESHIP_IMAGE;
	}
}
