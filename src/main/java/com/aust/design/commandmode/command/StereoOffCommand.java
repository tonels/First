package com.aust.design.commandmode.command;

import com.aust.design.commandmode.device.Stereo;

public class StereoOffCommand implements Command {
	private Stereo setreo;
	public StereoOffCommand(Stereo setreo)
	{
		this.setreo=setreo;
	}
	
	@Override
	public void execute() {
		setreo.Off();
	}

	@Override
	public void undo() {
		setreo.On();
		setreo.SetCd();
	}

}

