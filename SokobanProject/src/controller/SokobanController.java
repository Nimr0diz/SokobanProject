package controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import controller.commands.Command;
import controller.commands.DisplayLevelCommand;
import controller.commands.ExitCommand;
import controller.commands.LoadLevelCommand;
import controller.commands.MoveInLevelCommand;
import controller.commands.SaveLevelCommand;
import model.Model;
import view.SokobanServer;
import view.View;

public class SokobanController implements Observer{

	private Model model;
	private View view;
	private SokobanServer server;
	private View client;
	private Controller controller;
	
	
	private HashMap<String,Command> commands;
	
	public SokobanController(Model model,View view) {
		this.view = view;
		this.model = model;
		this.client = null;
		this.controller = new Controller();
		controller.start();
		
		initCommands();
	}
	
	public SokobanController(Model model,View view,View client) {
		this.view = view;
		this.model = model;
		this.client = client;
		this.controller = new Controller();
		controller.start();
		
		initCommands();
	}
	
	public SokobanController(Model model,View view,SokobanServer server)
	{
		this.view = view;
		this.model = model;
		this.server = server;
		this.controller = new Controller();
		controller.start();
		
		initCommands();
	}
	
	private void initCommands(){
		commands = new HashMap<String, Command>();
		
		commands.put("Display", new DisplayLevelCommand(model,view,client));
		commands.put("Exit", new ExitCommand(view));
		commands.put("Load", new LoadLevelCommand(model, view, client));
		commands.put("Move", new MoveInLevelCommand(model, view,client));
		commands.put("Save", new SaveLevelCommand(model,view,client));
		
//		commands.put("LoadCompleted", new LoadCompletedCommand(view));
//		commands.put("LoadFailed", new LoadFailedCommand(view));
//		commands.put("SaveCompleted", new SaveCompletedCommand(view));
//		commands.put("SaveFailed", new SaveFailedCommand(view));
	}
	
	@Override
	public void update(Observable o, Object args) {
		String[] lineArr = ((String)args).split(" ");
		LinkedList<String> params = new LinkedList<String>();
		for(String param : lineArr)
			params.add(param);
		String commandName= params.removeFirst();
		Command c=commands.get(commandName);
		if(c==null)
		{
			return;
		}
		c.setParams(params);
		controller.insertCommand(c);
		
	}

	public void start() {
		controller.start();
		view.start();
	}
	
	public void thereIsClient()
	{
		this.client = server.getClient();
	}
}
