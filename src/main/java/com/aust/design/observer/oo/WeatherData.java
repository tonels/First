package com.aust.design.observer.oo;

public class WeatherData {
	
	private float mTemperatrue;
	private float mPressure;
	private float mHumidity;
	private CurrentConditions mCurrentConditions;//自己的公告板
	
	//有参构造，初始化
	public WeatherData(CurrentConditions mCurrentConditions){
		this. mCurrentConditions= mCurrentConditions;
	}
	
	public float getTemperature(){
		return mTemperatrue;
		
	}
	
	public float getPressure(){
		return mPressure;
	}
	
	public float getHumidity(){
		return mHumidity;
	}
	//有变化时，调用，设置自己的公告板
	public void dataChange(){
		mCurrentConditions.update(getTemperature(), getPressure(), getHumidity());
	}
	//模拟气象站，通知datachange
	public void setData(float mTemperature,float mPressure,float mHumidity){
		this.mTemperatrue=mTemperature;
		this.mPressure=mPressure;
		this.mHumidity=mHumidity;
		dataChange();
	}
	
}
