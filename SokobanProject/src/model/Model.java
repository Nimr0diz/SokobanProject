package model;

import commons.CommonLevelField;

public interface Model {
	//public void move(Direction2D dir);
	public void load(String filename,String filetype);
	public void save(String filename,String filetype);
	public CommonLevelField getLevel();
}
