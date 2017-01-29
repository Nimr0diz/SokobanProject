package controller.commands;

//import exceptions.InvalidFileTypeException;
//import exceptions.SokobanException;
//import levels.Level;
//import levels.LevelSaver;
//import levels.MyObjectLevelSaver;
//import levels.MyTextLevelSaver;
//import levels.MyXMLLevelSaver;
import model.Model;
import view.View;

public class SaveLevelCommand extends Command {
	Model model;
	View view;
	View client;
	public SaveLevelCommand(Model model,View view,View client) {
		this.model=model;
		this.view = view;
		this.client=client;
	}
	@Override
	//The Method Save Level to any type of file and return it.
	//If the file isn't exist the method create new one.
	public void execute() {
		String filetype = params.get(0).substring(params.get(0).lastIndexOf(".")+1);//Get the letters after the '.' to get the file type
		try {
			model.save(params.get(0), filetype);
		} catch (Exception e) {
			view.showSaveLevelMessage(false, e.getMessage());
			if(client!=null)
				client.showSaveLevelMessage(false, e.getMessage());
		}
		view.showSaveLevelMessage(true, params.get(0));
		if(client!=null)
			client.showSaveLevelMessage(true, params.get(0));

	}
	

}
