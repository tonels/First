package com.aust.design.observer.internetweather.observer;

//观察者对象
public interface Observer {
    //公告板
    void update(float mTemperatrue, float mPressure, float mHumidity);
}
 