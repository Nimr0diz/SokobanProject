package boot;

import controller.SokobanController;
import model.Model;
import model.MyModel;
import view.CLI;
import view.View;

public class Run {

	public static void main(String[] args) {
		MyModel model = new MyModel();
		CLI view = new CLI(System.in,System.out);
		
		SokobanController sokoban = new SokobanController(model, view);
		
		model.addObserver(sokoban);
		view.addObserver(sokoban);
		
		sokoban.start();
	}

}
