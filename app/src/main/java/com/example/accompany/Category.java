package com.example.accompany;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Category
{
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("menuItems")
    @Expose
    private List<MenuItem> menuItems = null;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("images")
    @Expose
    private List<Object> images;

    @SerializedName("subItems")
    @Expose
    private List<SubItem> subItems = null;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public List<MenuItem> getMenuItems(){
        return this.menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems){
        this.menuItems = menuItems;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public List<Object> getImages(){
        return images;
    }

    public void setImages(List<Object> images){
        this.images = images;
    }

    public List<SubItem> getSubItems(){
        return this.subItems;
    }

    public void setSubItems(List<SubItem> subItems){
        this.subItems = subItems;
    }
}
