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
	public SaveLevelCommand(Model model) {
		this.model=model;
	}
	@Override
	//The Method Save Level to any type of file and return it.
	//If the file isn't exist the method create new one.
	public void execute() {
		String filetype = params.get(0).substring(params.get(0).lastIndexOf(".")+1);//Get the letters after the '.' to get the file type
		model.save(params.get(0), filetype);
	}
	

}
