package controller;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

import controller.commands.Command;
import controller.commands.ExitCommand;

public class Controller {
	protected BlockingQueue<Command> queue;
	protected boolean stop;
	
	public Controller() {
		queue = new ArrayBlockingQueue<Command>(10);
		stop = true;
	}
	
	public void insertCommand(Command command)
	{
		try {
			queue.put(command);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void start()
	{
		Thread thread = new Thread(new Runnable() 
		{
			@Override
			public void run()
			{
				stop = false;
				while(!stop)
				{
					try {
						Command command = queue.poll(500, TimeUnit.MILLISECONDS);
						if(command!=null)
							command.execute();
						if(command instanceof ExitCommand)
							stop();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();
	}
	
	public void stop()
	{
		stop=true;
	}
}
