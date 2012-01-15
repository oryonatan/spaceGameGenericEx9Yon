/**
 * FILE : SpaceShip.java
 * WRITER : Idan Brodet + idanbr2 + 300685278
 * WRITER : Yonatan Oren
 * EXERCISE : intro2cs ex9 2011-2012  
 * DESCRIPTION:
 * 
 */
import intro.ex9.*;
import java.awt.Image;

public abstract class SpaceShip {
	
	private static final int SHIELD_ENERGY = 3;
	private static final int SHOT_ENERGY = 25;
	private static final int TEL_ENERGY = 150;
	protected int shotsTurnCounter = 0;
	private static final int SHOTS_DELAY = 8;
	private static final int STARTING_HEALTH = 10;
	private static final int STARTING_ENERGY = 200;
	protected static final int LEFT = 1;
	protected static final int RIGHT = -1;
	protected static final int FORWARD = 0;
	/**
	 * The position and physics of the ship.
	 */
	protected SpaceShipPhysics pos;
	protected boolean shieldsUp;
	protected int health;
	protected int energy;

	/**
	 * Ctor for the space ships , calls reset , sets random position and maximum
	 * health/energy
	 * 
	 */
	public SpaceShip() {
		reset();
	}

	/**
	 * This method is called every time a collision with this ship occurs. if
	 * shield is up , nothing will happen
	 */
	public void collidedWithAnotherShip() {
		if (!shieldsUp) {
			health--;
		}
	}
	
	/**
	 * Does the specific action of the ship (To be implemented by each
	 * spaceship) all specific behavior of the ship (such as movement , shooting etc.)
	 * should be implemented here.
	 * @param game The game controller.
	 */
	public abstract void doSpecificAction(SpaceWars game);

	/**
	 * Does the actions of this ship for this round. This is called once per
	 * round by the SpaceWars game driver. 
	 * The method by itself only lowers the shoot delay counter , turns of the shield and then 
	 * Calls the doSpecificAction(game) method of the ship which handles the special behavior 
	 * of each ship , such * as moving , shooting etc.
	 * After this is done - energy is replenished
	 * 
	 * @param game The game object to which this ship belongs.
	 */
	public void doAction(SpaceWars game) {
		shotsTurnCounter--;
		shieldsUp = false;
		doSpecificAction(game);
		energy++;
	}

	/**
	 * Gets the image of this ship. This method should return the image of the
	 * ship with or without the shield. This will be displayed on the GUI at the
	 * end of the round
	 * @return The image of the ship.
	 */
	public abstract Image getImage();

	/**
	 * Gets the physics object that controls this ship.
	 * @return The physics object that controls the ship.
	 */
	public SpaceShipPhysics getPhysics() {
		return pos;
	}

	/**
	 * This method is called by the SpaceWars game object when ever this ship
	 * gets hit by a shot.
	 */
	public void gotHit() {
		health--;
	}

	/**
	 * Checks if this ship is dead.
	 * @return true if the ship is dead. false otherwise.
	 */
	public boolean isDead() {
		if (health <= 0) {
			return true;
		}
		return false;
	}

	/**
	 * This method is called whenever a ship has died. It resets the ship's
	 * attributes, and starts it at a new random position.
	 */
	public void reset() {
		pos = new SpaceShipPhysics();
		shieldsUp = false;
		health = STARTING_HEALTH;
		energy = STARTING_ENERGY;
	}

	/**
	 * Activates the shield (if there is enough energy)
	 */
	public void activateShield() {
		if (energy >= SHIELD_ENERGY) {
			shieldsUp = true;
			energy -= SHIELD_ENERGY;
		}
	}

	/**
	 * Fires the main cannon in the direction of pos
	 */
	protected void fire(SpaceWars game) {
		if (energy >= SHOT_ENERGY && shotsTurnCounter <= 0) {
			game.addShot(pos);
			energy -= SHOT_ENERGY;
			shotsTurnCounter = SHOTS_DELAY;
		}
	}

	/**
	 * Teleports the ship
	 */
	public void Teleport() {
		if (energy >= TEL_ENERGY) {
			energy -= TEL_ENERGY;
			pos = new SpaceShipPhysics();
		}
	}
}