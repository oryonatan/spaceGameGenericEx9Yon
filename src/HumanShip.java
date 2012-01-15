/** 
 * FILE : HumanShip.java
 * WRITER : Idan Brodet + idanbr2 + 300685278
 * WRITER : Yonatan Oren
 * EXERCISE : intro2cs ex9 2011-2012  
 * DESCRIPTION:
 * Human player ship extends the spaceship with support for user input.
 */
import intro.ex9.GameGUI;
import java.awt.Image;

public class HumanShip extends SpaceShip {
	
	/* (non-Javadoc)
	 * @see SpaceShip#doSpecificAction(SpaceWars)
	 */
	@Override
	public void doSpecificAction(SpaceWars game) {
		GameGUI gui = game.getGUI();
		int direction = FORWARD ;
		boolean accelerate = false;
		//Handle input from the user 
		if (gui.isTPressed()) {	Teleport(); }
		if (gui.isLeftPressed()) { direction = LEFT; }
		else if (gui.isRightPressed()) { direction = RIGHT; }
		if (gui.isUpPressed()) { accelerate =true ; }
		//Move with the given input
		pos.move(accelerate, direction);		
		if (gui.isSPressed()) { activateShield(); }
		if (gui.isDPressed()) { fire(game);	}
	}

	/* (non-Javadoc)
	 * @see SpaceShip#getImage()
	 */
	@Override
	public Image getImage() {
		if (shieldsUp) {
			return GameGUI.SPACESHIP_IMAGE_SHIELD;
		}
		return GameGUI.SPACESHIP_IMAGE;
	}

}
 