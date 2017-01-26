package controller.commands;

import view.View;

public class LoadCompletedCommand extends Command {
	View view;
	
	public LoadCompletedCommand(View view) {
		this.view = view;
	}
	
	@Override
	public void execute() {
		view.showLoadCompletedMessge(params.get(0));
	}

}
