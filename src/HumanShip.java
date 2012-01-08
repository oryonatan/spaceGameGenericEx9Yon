import intro.ex9.GameGUI;

import java.awt.Image;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

public class HumanShip extends SpaceShip {


	@Override
	public void doSpecificAction(SpaceWars game) {
		GameGUI gui = game.getGUI();
		int direction = 0 ;
		boolean accelerate = false;
		if (gui.isTPressed()) Teleport();
		if (gui.isLeftPressed()) direction = LEFT;
		else if (gui.isRightPressed()) direction = RIGHT;
		if (gui.isSPressed()) activateShield();
		if (gui.isUpPressed()) accelerate =true ;
		pos.move(accelerate, direction);
		if (gui.isDPressed()) fire(game);
	}

	@Override
	public Image getImage() {
		if (shieldsUp) {
			return GameGUI.SPACESHIP_IMAGE_SHIELD;
		}
		return GameGUI.SPACESHIP_IMAGE;
	}

}
