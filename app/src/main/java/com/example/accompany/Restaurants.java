package com.example.accompany;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class Restaurants
{
    @SerializedName("concessions")
    @Expose
    private ArrayList<String> concessions = null;

    public ArrayList<String> getConcessions(){
        return concessions;
    }

    public void setConcessions(ArrayList<String> concessions){
        this.concessions = concessions;
    }
}
