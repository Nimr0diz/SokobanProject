package boot;

import controller.SokobanController;
import model.Model;
import model.MyModel;
import view.CLI;
import view.SokobanServer;
import view.View;

public class Run {

	public static void main(String[] args) {
		MyModel model = new MyModel();
		CLI view = new CLI(System.in,System.out);
		SokobanServer server = new SokobanServer(3333);
		CLI client = (CLI)server.getClient();
		SokobanController sokoban = new SokobanController(model, view,server);
		server.setController(sokoban);
		server.start();
		System.out.println(client);
		model.addObserver(sokoban);
		view.addObserver(sokoban);
		if(client!=null)
			client.addObserver(sokoban);
		sokoban.start();
	}

}
