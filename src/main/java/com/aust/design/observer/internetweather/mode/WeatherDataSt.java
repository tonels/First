package com.aust.design.observer.internetweather.mode;


import java.util.ArrayList;

import com.aust.design.observer.internetweather.observer.Observer;
import com.aust.design.observer.internetweather.observer.Subject;

//实现注册，移除
public class WeatherDataSt implements Subject{
	
	private float mTemperatrue;
	private float mPressure;
	private float mHumidity;
	private ArrayList<Observer> mObservers;//不知道观察者有多少，由Arraylist管理，目前2个
	
	//在构造函数中，初始化
	public WeatherDataSt(){
		mObservers=new ArrayList<Observer>();
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
	
	public void dataChange(){
		notifyObservers();
	}

	//便于测试
	public void setData(float mTemperatrue,float mPressure,float mHumidity)
	{
		this.mTemperatrue=mTemperatrue;
		this.mPressure=mPressure;
		this.mHumidity=mHumidity;
		dataChange();
	}
	//注册，用观察者
	@Override
	public void registerObserver(Observer o) {
		mObservers.add(o);
	}
	//移除，是否包含
	@Override
	public void removeObserver(Observer o) {
		if(mObservers.contains(o))
		{mObservers.remove(o);}
	}
	//通知
	@Override
	public void notifyObservers() {
		//取出列表中所有观察者对象，通知
		for(int i=0,len=mObservers.size();i<len;i++)
		{
			//获取本地变量，直接取，测试用，实际时pull更好
			mObservers.get(i).update(getTemperature(), getPressure(), getHumidity());
		}
	}

}
