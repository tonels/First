package com.aust.design.observer.internetweather.mode;

import com.aust.design.observer.internetweather.observer.Observer;

public class ForcastConditions implements Observer {
	//定义三个保存的变量
	private float mTemperatrue;
	private float mPressure;
	private float mHumidity;
	
	//接受传递的数据
	@Override
	public void update(float mTemperatrue, float mPressure, float mHumidity) {
		this.mTemperatrue=mTemperatrue;
		this.mPressure=mPressure;
		this.mHumidity=mHumidity;
		
		display();
	}
	//显示
	public void display()
	{
		System.out.println("**明天温度:"+(mTemperatrue+Math.random())+"**");
		System.out.println("**明天气压:"+(mPressure+10*Math.random())+"**");
		System.out.println("**明天湿度:"+(mHumidity+Math.random())+"**");
	}
}