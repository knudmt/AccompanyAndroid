package com.example.accompany;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Day
{
    @SerializedName("open")
    @Expose
    private String open;

    @SerializedName("close")
    @Expose
    private String close;

    public String getOpen(){
        return this.open;
    }

    public void setOpen(String open){
        this.open = open;
    }

    public String getClose(){
        return this.close;
    }

    public void setClose(){
        this.close = close;
    }
}
