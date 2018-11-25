package com.aust.design.commandmode.command;

//所有命令的接口，用抽象类也可实现类似的功能
public interface Command {
	public void execute();
	public void undo();
}
