package com.aust.design.observer.internetweather.observer;

//供多个依赖者实现
public interface Subject {

    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}
