package com.aust.design.observer.internetweather.mode;

import com.aust.design.observer.internetweather.observer.Observer;

	//观察者对象
public class CurrentConditions implements Observer{
	//三个临时变量
	private float mTemperatrue;
	private float mPressure;
	private float mHumidity;
	
	//保存到本地
	@Override
	public void update(float mTemperatrue, float mPressure, float mHumidity) {
		this.mTemperatrue=mTemperatrue;
		this.mPressure=mPressure;
		this.mHumidity=mHumidity;
		display();
	}
	
	public void display(){
		System.out.println("**明天温度:"+(mTemperatrue+Math.random())+"**");
		System.out.println("**明天气压:"+(mPressure+10*Math.random())+"**");
		System.out.println("**明天湿度:"+(mHumidity+Math.random())+"**");
	}

}
