package controller.commands;

import view.View;

public class SaveFailedCommand extends Command {
	View view;
	
	public SaveFailedCommand(View view) {
		this.view = view;
	}
	
	@Override
	public void execute() {
		view.showSaveFailedMessage(params.get(0));
	}

}
