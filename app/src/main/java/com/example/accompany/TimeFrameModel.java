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

    public Date getLatestTime(){
        return this.LatestTime;
    }

    public void setLatestTime(Date latestTime){
        this.LatestTime = latestTime;
    }
}
