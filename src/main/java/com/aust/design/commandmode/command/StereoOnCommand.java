package com.aust.design.commandmode.command;

import com.aust.design.commandmode.device.Stereo;

//音响
public class StereoOnCommand implements Command {
	private Stereo setreo; //传入对象
	public StereoOnCommand(Stereo setreo)
	{
		this.setreo=setreo;
	}
	
	@Override
	public void execute() {
		setreo.On();
		setreo.SetCd();
		
	}

	@Override
	public void undo() {
		setreo.Off();
	}

}
