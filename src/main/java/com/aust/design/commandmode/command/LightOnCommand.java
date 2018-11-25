package com.aust.design.commandmode.command;

import com.aust.design.commandmode.device.Light;

public class LightOnCommand implements Command {
	private Light light;
	
	public LightOnCommand(Light light)
	{
		this.light=light;
		
	}
	@Override
	public void execute() {
		light.On();
	}

	@Override
	public void undo() {
		light.Off();
	}

}
