package com.example.accompany;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFrameModel
{
    private String EarliestTime;
    private String LatestTime;
    private String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSS'Z'";
    private SimpleDateFormat format = new SimpleDateFormat(pattern);


    public String getEarliestTime(){
        return this.EarliestTime;
    }

    public void setEarliestTime(Date earliestTime){

        this.EarliestTime = format.format(earliestTime);
    }

    public String getLatestTime(){
        return this.LatestTime;
    }

    public void setLatestTime(Date latestTime){
        this.LatestTime = format.format(latestTime);
    }
}
