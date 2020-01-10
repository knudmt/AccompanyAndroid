package com.example.accompany;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MenuItem
{
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("images")
    @Expose
    private List<Object> images;

    @SerializedName("subItems")
    @Expose
    private List<SubItem> subItems;
}
