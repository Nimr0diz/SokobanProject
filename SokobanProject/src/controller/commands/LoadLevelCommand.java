package controller.commands;

import model.Model;

public class LoadLevelCommand extends Command {
	Model model;
	//The HashMap link each text file extension to the specific LevelLoader
//	HashMap<String,LevelLoader> levelLoaderList;
	
	public LoadLevelCommand(Model model) {
		this.model = model;
		
		//Initializing the HashMap.
	//	levelLoaderList = new HashMap<String,LevelLoader>();
		
//		levelLoaderList.put("txt", new MyTextLevelLoader());
//		levelLoaderList.put("obj", new MyObjectLevelLoader());
//		levelLoaderList.put("xml", new MyXMLLevelLoader());
		
	}
	@Override
	//The Method Load Level from any type of file and return it.
	//The level parameter is irrelevant.
	//If the file isn't exist the method throw FileNotFoundException.
	public void execute() {
		String filetype = params.get(0).substring(params.get(0).lastIndexOf(".")+1);//Get the letters after the '.' to get the file type
	
		//LevelLoader ll= levelLoaderList.get(filetype);
	//	if(ll==null){throw new InvalidFileTypeException(filetype);}//If the file type doesn't have the concurrent LevelLoader it throws InvalidFileTypeException
	//	level = ll.loadLevel(new FileInputStream(filename));

	}

}
