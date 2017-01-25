package controller.commands;
import model.Model;
import view.View;

public class DisplayLevelCommand extends Command{

	Model model;
	View view;
	public DisplayLevelCommand(Model model,View view) {
		this.model=model;
		this.view= view;
	}
	
	@Override
	//This method get level and display it through the System.out
	//The str parameter is irrelevant.
	//The Command use the text levelSaver to "save" the level to the screen (System.out). 
	public void execute() {
		//new MyTextLevelSaver().saveLevel(level, System.out);
	}


}
