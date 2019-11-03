package com.example.accompany;

public class QuoteLocationDetail
{
    private TimeModel Time;
    private String Address;

    public TimeModel getTime(){
        return this.Time;
    }

    public void setTime(TimeModel time){
        this.Time = time;
    }

    public String getAddress(){
        return this.Address;
    }

    public void setAddress(String address){
        this.Address = address;
    }
}
