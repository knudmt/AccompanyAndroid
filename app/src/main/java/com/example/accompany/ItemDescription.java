package com.example.accompany;
import android.os.Parcel;
import android.os.Parcelable;


public class ItemDescription implements Parcelable
{

    private String desc;
    private String cost;

    protected ItemDescription(Parcel in){
        desc = in.readString();
        cost = in.readString();
    }

    public ItemDescription(String description, String price){
        this.desc = description;
        this.cost = price;
    }

    public static final Creator<ItemDescription> CREATOR = new Creator<ItemDescription>() {
        @Override
        public ItemDescription createFromParcel(Parcel parcel) {
            return new ItemDescription(parcel);
        }

        @Override
        public ItemDescription[] newArray(int i) {
            return new ItemDescription[i];
        }
    };

    @Override
    public int describeContents(){
        return 0;
    }

    public String getDescription(){
        return this.desc;
    }

    public void setDescription(String description){
        this.desc = description;
    }

    public String getPrice(){
        return this.cost;
    }

    public void setPrice(String price){
        this.cost = price;
    }

    public static Creator<ItemDescription> getCreator(){
        return CREATOR;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i){
        parcel.writeString(desc);
        parcel.writeString(cost);
    }
}
