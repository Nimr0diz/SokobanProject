package controller.commands;

import java.util.HashMap;

import commons.Direction2D;
import model.Model;
import view.View;

public class MoveInLevelCommand extends Command {
	Model model;
	View view;
	View client;
	
	HashMap<String,Direction2D> directionList; //The HashMap link each string of direction to the specific Direction
		public MoveInLevelCommand(Model model,View view,View client) {
			this.model=model;
			this.view=view;
			this.client=client;
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
			boolean isMoved = model.move(dir); //Create new LevelManager who control the Level and moves the first figure.
			view.positionHasChanged(isMoved);
			if(client!=null)
				client.positionHasChanged(isMoved);
		}
}
