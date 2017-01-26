package controller.commands;

import view.View;

public class SaveCompletedCommand extends Command {
	View view;
	
	public SaveCompletedCommand(View view) {
		this.view = view;
	}
	@Override
	public void execute() {
		view.showSaveCompletedMessage(params.get(0));
	}

}
