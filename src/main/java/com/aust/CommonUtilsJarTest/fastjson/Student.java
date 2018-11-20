package com.aust.CommonUtilsJarTest.fastjson;  
  
import java.io.Serializable;  
  
/** 
 *@Author:liangjl 
 *@Date:2014-12-19 
 *@Version:1.0 
 *@Description: 
 */  
public class Student implements Serializable{  
    /**
	 * 
	 */
	private static final long serialVersionUID = -3594781741319026945L;
	private Integer age;  
    private String sex;  
    private String userName;  
    private String birthday;  
    private String address;  
    private String email;  
      
    public Integer getAge() {  
        return age;  
    }  
    public void setAge(Integer age) {  
        this.age = age;  
    }  
    public String getSex() {  
        return sex;  
    }  
    public void setSex(String sex) {  
        this.sex = sex;  
    }  
    public String getUserName() {  
        return userName;  
    }  
    public void setUserName(String userName) {  
        this.userName = userName;  
    }  
    public String getBirthday() {  
        return birthday;  
    }  
    public void setBirthday(String birthday) {  
        this.birthday = birthday;  
    }  
    public String getAddress() {  
        return address;  
    }  
    public void setAddress(String address) {  
        this.address = address;  
    }  
    public String getEmail() {  
        return email;  
    }  
    public void setEmail(String email) {  
        this.email = email;  
    }  
}