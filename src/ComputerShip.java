import intro.ex9.GameGUI;
import intro.ex9.SpaceShipPhysics;
import java.awt.Image;

/**
 * Abstract class for all the computer ships
 * 
 * @author yonatan,idanb
 * 
 */
public abstract class ComputerShip extends SpaceShip {
	/**
	 * Types of movement interactions can be escape, or pursue
	 */
	protected enum Interaction {
		escape, pursue
	};

	protected final double SMALL_ANGLE = 0.2;
	protected final double SMALL_DISTANCE = 0.2;

	/*
	 * (non-Javadoc)
	 * 
	 * @see SpaceShip#getImage()
	 */
	public Image getImage() {
		if (shieldsUp) {
			return GameGUI.ENEMY_SPACESHIP_IMAGE_SHIELD;
		}
		return GameGUI.ENEMY_SPACESHIP_IMAGE;
	}

	/**
	 * Moves the ship with an interaction relative to another ship
	 * 
	 * @param otherShip
	 *            the ship to interact with
	 * @param action
	 *            the type of interaction : pursue or escape.
	 */
	protected void moveInteract(SpaceShip otherShip, Interaction action) {
		SpaceShipPhysics otherPhysics = otherShip.getPhysics();
		int direction = FORWARD;
		// Ship to the right
		if (pos.angleTo(otherPhysics) < 0) {
			if (action == Interaction.pursue) {
				direction = RIGHT;
			} else {
				direction = LEFT;
			}
		}
		// Ship to the left
		else if (pos.angleTo(otherPhysics) > 0) {
			if (action == Interaction.pursue) {
				direction = LEFT;
			} else {
				direction = RIGHT;
			}
		}
		// If the ship is directly in front of us - keep forward
		pos.move(true, direction);
	}
}
