package controller.commands;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

//import exceptions.InvalidFileTypeException;
//import exceptions.SokobanException;
//import levels.Level;
//import levels.LevelSaver;
//import levels.MyObjectLevelSaver;
//import levels.MyTextLevelSaver;
//import levels.MyXMLLevelSaver;
import model.Model;

public class SaveLevelCommand extends Command {
	Model model;
	//The HashMap link each text file extension to the specific LevelSaver
	//HashMap<String,LevelSaver> levelSaverList;
	public SaveLevelCommand(Model model) {
		this.model=model;
		//Initializing the HashMap.
		//levelSaverList = new HashMap<String,LevelSaver>();
		
		//levelSaverList.put("obj", new MyObjectLevelSaver());
		//levelSaverList.put("txt", new MyTextLevelSaver());
		//levelSaverList.put("xml", new MyXMLLevelSaver());

	}
	@Override
	//The Method Save Level to any type of file and return it.
	//If the file isn't exist the method create new one.
	public void execute() {
		String filetype = params.get(0).substring(params.get(0).lastIndexOf(".")+1);//Get the letters after the '.' to get the file type
		model.save(params.get(0), filetype);
	}
	

}
