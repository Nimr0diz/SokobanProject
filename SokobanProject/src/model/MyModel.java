package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Observable;

import commons.CommonLevel;
import commons.Direction2D;
import model.levels.Level;
import model.levels.LevelManager;
import model.levels.loaders.LevelLoader;
import model.levels.loaders.MyObjectLevelLoader;
import model.levels.loaders.MyTextLevelLoader;
import model.levels.loaders.MyXMLLevelLoader;
import model.levels.savers.LevelSaver;
import model.levels.savers.MyObjectLevelSaver;
import model.levels.savers.MyTextLevelSaver;
import model.levels.savers.MyXMLLevelSaver;

public class MyModel extends Observable implements Model {

	Level level;
	
	HashMap<String,LevelLoader> levelLoaderList;
	HashMap<String,LevelSaver> levelSaverList;
	
	public MyModel() {
		this.level=new Level();
		initLoaders();
	}
	
	public void initLoaders()
	{
		levelLoaderList = new HashMap<String,LevelLoader>();
		
		levelLoaderList.put("txt", new MyTextLevelLoader());
		levelLoaderList.put("obj", new MyObjectLevelLoader());
		levelLoaderList.put("xml", new MyXMLLevelLoader());
	}
	
	public void initSavers()
	{
		levelSaverList = new HashMap<String,LevelSaver>();
		
		levelSaverList.put("obj", new MyObjectLevelSaver());
		levelSaverList.put("txt", new MyTextLevelSaver());
		levelSaverList.put("xml", new MyXMLLevelSaver());
	}
	
	@Override
	public boolean move(Direction2D dir) {
		LevelManager lm=new LevelManager(level);
		return lm.move(level.getFirstFigure(), dir);
	}

	@Override
	public void load(String filepath, String filetype) throws Exception {
		LevelLoader ll = levelLoaderList.get(filetype);
		level = ll.loadLevel(new FileInputStream(filepath));
	}

	@Override
	public void save(String filepath, String filetype) throws Exception {
		LevelSaver ls = levelSaverList.get(filetype);
		ls.saveLevel(level, new FileOutputStream(filepath));

	}

	@Override
	public CommonLevel getLevel() {
		return level.getCommon();
	}

}
