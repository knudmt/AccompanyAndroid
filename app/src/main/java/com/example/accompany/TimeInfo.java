package com.example.accompany;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TimeInfo
{
    @SerializedName("sat")
    @Expose
    private List<Day> sat = null;

    @SerializedName("sun")
    @Expose
    private List<Day> sun = null;

    @SerializedName("mon")
    @Expose
    private List<Day> mon;

    @SerializedName("tue")
    @Expose
    private List<Day> tue;

    @SerializedName("wed")
    @Expose
    private List<Day> wed;

    @SerializedName("thu")
    @Expose
    private List<Day> thu;

    @SerializedName("fri")
    @Expose
    private List<Day> fri;

    public List<Day> getSat(){
        return this.sat;
    }

    public void setSat(List<Day> sat){
        this.sat = sat;
    }

    public List<Day> getSun(){
        return this.sun;
    }

    public void setSun(List<Day> sun){
        this.sun = sun;
    }

    public List<Day> getMon(){
        return this.mon;
    }

    public void setMon(List<Day> mon){
        this.mon = mon;
    }

    public List<Day> getTue(){
        return this.tue;
    }

    public void setTue(List<Day> tue){
        this.tue = tue;
    }

    public List<Day> getWed(){
        return this.wed;
    }

    public void setWed(List<Day> wed){
        this.wed = wed;
    }

    public List<Day> getThu(){
        return this.thu;
    }

    public void setThu(List<Day> thu){
        this.thu = thu;
    }

    public List<Day> getFri(){
        return this.fri;
    }

    public void setFri(List<Day> fri){
        this.fri = fri;
    }
}
