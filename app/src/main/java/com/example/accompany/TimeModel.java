package com.example.accompany;

import java.util.Date;

public class TimeModel
{
    private Date Average;
    private Date Earliest;
    private Date Latest;

    public Date getAverage(){
        return this.Average;
    }

    public void setAverage(Date average){
        this.Average = average;
    }

    public Date getEarliest(){
        return this.Earliest;
    }

    public void setEarliest(Date earliest){
        this.Earliest = earliest;
    }

    public Date getLatest(){
        return this.Latest;
    }

    public void setLatest(Date latest){
        this.Latest = latest;
    }
}
