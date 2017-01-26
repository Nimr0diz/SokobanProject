package controller.commands;

import model.Model;

public class LoadLevelCommand extends Command {
	Model model;
	
	public LoadLevelCommand(Model model) {
		this.model = model;
		
	}
	@Override
	//The Method Load Level from any type of file and return it.
	//The level parameter is irrelevant.
	//If the file isn't exist the method throw FileNotFoundException.
	public void execute() {
		String filetype = params.get(0).substring(params.get(0).lastIndexOf(".")+1);//Get the letters after the '.' to get the file type
		model.load(params.get(0), filetype);

	}

}
