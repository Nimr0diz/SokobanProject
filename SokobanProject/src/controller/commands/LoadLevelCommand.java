package controller.commands;

import model.Model;
import view.View;

public class LoadLevelCommand extends Command {
	Model model;
	View view;
	View client;
	
	public LoadLevelCommand(Model model,View view,View Client) {
		this.model = model;
		
	}
	@Override
	//The Method Load Level from any type of file and return it.
	//The level parameter is irrelevant.
	//If the file isn't exist the method throw FileNotFoundException.
	public void execute() {
		String filetype = params.get(0).substring(params.get(0).lastIndexOf(".")+1);//Get the letters after the '.' to get the file type
		try {
			model.load(params.get(0), filetype);
		} catch (Exception e) {
			view.showLoadLevelMessage(false, e.getMessage());
			if(client!=null)
				client.showLoadLevelMessage(false, e.getMessage());
		}
		view.showLoadLevelMessage(true, params.get(0));
		if(client!=null)
			client.showLoadLevelMessage(true, params.get(0));

	}

}
