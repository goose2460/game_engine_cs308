package authoring.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import engine.conditions.Condition;
import engine.level.*;
import engine.gameObject.GameObject;

/**
 * Passive data object that holds onto all of the
 * data that represents an authored game.
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Arjun Jain
 * @author Kevin Li
 *
 */
public class GameData implements Serializable{

	/**
	 * Maybe put in properties file?
	 */
	private static final long serialVersionUID = 6633782568176674709L;
	
	private LevelsCollection myLevels;
	private ConditionsCollection myConditions;
	private GameObjectsCollection myGameObjects;
	private GraphicsCollection myImages;
	
	public GameData(){
		myLevels = new LevelsCollection();
		myGameObjects = new GameObjectsCollection();
		myConditions = new ConditionsCollection();
		myImages = new GraphicsCollection();
	
	}
	
	/**
	 * Level Methods
	 */
	
	public LevelsCollection getLevels(){
		return myLevels;
	}
	
	public void addLevel(Level l){
		myLevels.add(l);
	}
	
	public void removeLevel(Level l){
		myLevels.remove(l);
	}
	
	/**
	 * GameObject Methods
	 */
	
	public GameObjectsCollection getGameObjects(){
		return myGameObjects;
	}
	
	public void addGameObject(GameObject s){
		myGameObjects.add(s);
	}
	
	public void removeGameObject(GameObject s){
		myGameObjects.remove(s);
	}
	
	/**
	 * Condition Methods
	 */
	
	public ConditionsCollection getConditions(){
		return myConditions;
	}
	
	public void addCondition(Condition c){
		myConditions.add(c);
	}
	
	public void removeCondition(Condition c){
		myConditions.remove(c);
	}
	
	/**
	 * Graphics Methods
	 */
	
	public GraphicsCollection getImages(){
		return myImages;
	}
	
	
}
