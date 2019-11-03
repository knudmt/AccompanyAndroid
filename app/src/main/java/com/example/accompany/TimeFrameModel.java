package com.example.accompany;

import java.util.Date;

public class TimeFrameModel
{
    private Date EarliestTime;
    private Date LatestTime;

    public Date getEarliestTime(){
        return this.EarliestTime;
    }

    public void setEarliestTime(Date earliestTime){
        this.EarliestTime = earliestTime;
    }

    public Date setLatestTime(){
        return this.LatestTime;
    }

    public void getLatestTime(Date latestTime){
        this.LatestTime = latestTime;
    }
}
