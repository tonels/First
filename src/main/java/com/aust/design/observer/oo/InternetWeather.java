package com.aust.design.observer.oo;

public class InternetWeather {

	public static void main(String[] args) {
		CurrentConditions mCurrentConditions;//公告板
		WeatherData mWeatherData;//接口
		
		mCurrentConditions = new CurrentConditions();
		mWeatherData = new WeatherData(mCurrentConditions);//可以通知
		
		mWeatherData.setData(30, 150, 40);//传给weatherdata,通知update
	}

}
