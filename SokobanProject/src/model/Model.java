package model;

import java.io.FileNotFoundException;
import java.io.IOException;

import commons.CommonEntity;
import commons.CommonLevel;
import commons.Direction2D;

public interface Model {
	public boolean move(Direction2D dir);
	public void load(String filepath,String filetype);
	public void save(String filepath,String filetype);
	public CommonLevel getLevel();
}
