package controller.commands;

import java.util.HashMap;

import commons.Direction2D;
import model.Model;

public class MoveInLevelCommand extends Command {
	Model model;
	
	HashMap<String,Direction2D> directionList; //The HashMap link each string of direction to the specific Direction
		public MoveInLevelCommand(Model model) {
			this.model=model;
			//Initializing the HashMap.
			directionList = new HashMap<String,Direction2D>();
			
			directionList.put("Up", Direction2D.UP);
			directionList.put("Right", Direction2D.RIGHT);
			directionList.put("Down", Direction2D.DOWN);
			directionList.put("Left", Direction2D.LEFT);

			
		}
		@Override
		//The method moves the first figure to the direction he get from the user. 
		public void execute() {
			Direction2D dir = directionList.get(params.get(0));
			//if(dir==null){throw new InvalidDirectionException(direction);} //If the direction the method get by input is invalid it throws InvalidFileTypeException.
			model.move(dir); //Create new LevelManager who control the Level and moves the first figure.
		}
}
