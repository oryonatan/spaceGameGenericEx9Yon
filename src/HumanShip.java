import intro.ex9.GameGUI;

import java.awt.Image;

public class HumanShip extends SpaceShip {
	
	@Override
	public void doSpecificAction(SpaceWars game) {
		GameGUI gui = game.getGUI();
		int direction = FORWARD ;
		boolean accelerate = false;
		if (gui.isTPressed()) {
			Teleport();
		}
		if (gui.isLeftPressed()) {
			direction = LEFT;
		}
		else if (gui.isRightPressed()) {
			direction = RIGHT;
		}
		if (gui.isUpPressed()) {
			accelerate =true ;
		}
		pos.move(accelerate, direction);
		if (gui.isSPressed()) {
			activateShield();
		}
		if (gui.isDPressed()) {
			fire(game);
		}
	}

	@Override
	public Image getImage() {
		if (shieldsUp) {
			return GameGUI.SPACESHIP_IMAGE_SHIELD;
		}
		return GameGUI.SPACESHIP_IMAGE;
	}

}
 