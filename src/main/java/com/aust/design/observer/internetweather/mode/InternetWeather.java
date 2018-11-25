package com.aust.design.observer.internetweather.mode;

public class InternetWeather {

	public static void main(String[] args) {
		
		CurrentConditions mCurrentConditions;//第一个公告板
		ForcastConditions mForcastConditions;//第二个公告板
		WeatherDataSt mWeatherDataSt;//WeatherDataSt对象
		
		mWeatherDataSt=new WeatherDataSt();//初始化
		mCurrentConditions=new CurrentConditions();
		mForcastConditions=new ForcastConditions();
		
		mWeatherDataSt.registerObserver(mCurrentConditions);//注册观察者
		mWeatherDataSt.registerObserver(mForcastConditions);//注册观察者
		
		mWeatherDataSt.setData(30, 150, 40);
		mWeatherDataSt.removeObserver(mCurrentConditions);
		mWeatherDataSt.setData(40, 250, 50);
	}

}
