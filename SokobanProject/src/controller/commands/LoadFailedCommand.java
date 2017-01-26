package controller.commands;

import view.View;

public class LoadFailedCommand extends Command {
	//final static String COMMAND_NAME= "LoadFailed";
	View view;
	
	public LoadFailedCommand(View view) {
		this.view = view;
	}
	
	@Override
	public void execute() {
		view.showLoadFailedMessage(params.get(0));

	}

}
