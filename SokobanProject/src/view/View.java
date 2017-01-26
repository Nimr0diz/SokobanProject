package view;

import commons.CommonLevel;

public interface View {

	void showSaveCompletedMessage(String filepath);
	void showSaveFailedMessage(String message);
	void showLoadCompletedMessge(String filepath);
	void showLoadFailedMessage(String message);
	void positionHasChanged(boolean isMoved);
	void displayLevel(CommonLevel level);
	void start();
	void stop();

}
