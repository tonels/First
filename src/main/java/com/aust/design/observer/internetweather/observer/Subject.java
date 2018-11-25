package com.aust.design.observer.internetweather.observer;

//供多个依赖者实现
public interface Subject {

	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}
