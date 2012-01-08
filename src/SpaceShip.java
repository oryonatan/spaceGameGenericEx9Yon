import intro.ex9.*;

import java.awt.Image;
import java.awt.image.*;
/**
 *  The API spaceships need to implement for the SpaceWars game.
 It is your decision whether SpaceShip.java will be an interface, an abstract
 class, a base class for the other spaceships or any other option you 
 will choose.

 */

public abstract class SpaceShip{
	/**
	 * The position and physics of the ship. 
	 */
	private SpaceShipPhysics pos;
	private boolean shieldsUp;
	private int health; 
	private int energy;
	
	public SpaceShip() {
		reset();
	}

	/**
	 *  This method is called every time a collision with this ship occurs.

	 */
	public void collidedWithAnotherShip() {
		if (!shieldsUp){
			health--;
			if (health <= 0){
				
			}
		}
	}
	/**
	 *  Does the actions of this ship for this round. 
 This is called once per round by the SpaceWars game driver.

	 * @param game the game object to which this ship belongs.
	 */
	public void doAction(SpaceWars game) {
		shieldsUp = false;
	}
	/**
	 *  Gets the image of this ship. This method should return the image of the
 ship with or without the shield. This will be displayed on the GUI at
 the end of the round.

	 * @return the image of the ship.
	 */
	public Image getImage() {
		return null;
	}
	/**
	 *  Gets the physics object that controls this ship.

	 * @return the physics object that controls the ship.
	 */
	public SpaceShipPhysics getPhysics() {
		return pos;
	}
	/**
	 *  This method is called by the SpaceWars game object when ever this ship
 gets hit by a shot.

	 */
	public void gotHit() {
		health--; 
	}
	/**
	 *  Checks if this ship is dead.

	 * @return true if the ship is dead. false otherwise.
	 */
	public boolean isDead() {
		if (health <= 0){
			return true;
		}
		return false;
	}
	
	/**
	 *  This method is called whenever a ship has died. It resets the ship's 
 attributes, and starts it at a new random position.

	 */
	public void reset() {
		pos = new SpaceShipPhysics();
		shieldsUp = false;
		health =  10;
		energy = 200;
	}
}