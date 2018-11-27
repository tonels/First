package com.aust.design.facademode;

import com.aust.design.facademode.hometheater.HomeTheaterFacade;

public class MainTest {
	public static void main(String[] args) {
		HomeTheaterFacade mHomeTheaterFacade=new HomeTheaterFacade();
		
		mHomeTheaterFacade.ready();
		mHomeTheaterFacade.play();
	}
}
