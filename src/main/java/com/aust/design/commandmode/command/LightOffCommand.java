package com.aust.design.commandmode.command;

import com.aust.design.commandmode.device.Light;

public class LightOffCommand implements Command {
	private Light light;
	public LightOffCommand(Light light)
	{
		this.light=light;
	}
	@Override
	public void execute() {
		light.Off();
	}

	@Override
	public void undo() {
		light.On();
	}

}
