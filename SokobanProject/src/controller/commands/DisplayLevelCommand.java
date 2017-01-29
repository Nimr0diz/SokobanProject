package controller.commands;
import commons.CommonLevel;
import model.Model;
import view.View;

public class DisplayLevelCommand extends Command{

	Model model;
	View view;
	View client;
	public DisplayLevelCommand(Model model,View view,View client) {
		this.model=model;
		this.view= view;
		this.client= client;
	}
	
	@Override
	//This method get level and display it through the System.out
	//The str parameter is irrelevant.
	//The Command use the text levelSaver to "save" the level to the screen (System.out). 
	public void execute() {
		CommonLevel level = model.getLevel();
		view.displayLevel(level);
		if(client!=null)
			client.displayLevel(level);
	}


}
