package controller.commands;

import java.util.HashMap;

import model.Model;

public class MoveInLevelCommand extends Command {
	Model model;
	//The HashMap link each string of direction to the specific Direction
	//	HashMap<String,Direction2D> directionList;
		public MoveInLevelCommand(Model model) {
			this.model=model;
			//Initializing the HashMap.
//			directionList = new HashMap<String,Direction2D>();
//			
//			directionList.put("Up", Direction2D.UP);
//			directionList.put("Right", Direction2D.RIGHT);
//			directionList.put("Down", Direction2D.DOWN);
//			directionList.put("Left", Direction2D.LEFT);

			
		}
		@Override
		//The method moves the first figure to the direction he get from the user. 
		public void execute() {
			//Direction2D dir = directionList.get(direction);
			//if(dir==null){throw new InvalidDirectionException(direction);} //If the direction the method get by input is invalid it throws InvalidFileTypeException.
			//new LevelManager(level).move(level.getFirstFigure(), dir); //Create new LevelManager who control the Level and moves the first figure.
		}
}
