package com.example.accompany;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable
{
    private String Id;
    private String FirstName;
    private String LastName;
    private String Email;
    private String PhoneNumber;
    private String StreetAddress;
    private String ApartmentNumber;
    private String City;
    private String State;
    private String Zip;
    private Boolean IsEnrolled;

    protected User(Parcel in){
        Id = in.readString();
        FirstName = in.readString();
        LastName = in.readString();
        Email = in.readString();
        PhoneNumber = in.readString();
        StreetAddress = in.readString();
        ApartmentNumber = in.readString();
        City = in.readString();
        State = in.readString();
        Zip = in.readString();
        IsEnrolled = Boolean.valueOf(in.readString());
    }

    public User(String id, String firstName, String lastName, String email, String phoneNumber, String streetAddress, String apartmentNumber, String city, String state, String zip, Boolean isEnrolled)
    {
        this.Id = id;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Email = email;
        this.PhoneNumber = phoneNumber;
        this.StreetAddress = streetAddress;
        this.ApartmentNumber = apartmentNumber;
        this.City = city;
        this.State = state;
        this.Zip = zip;
        this.IsEnrolled = isEnrolled;
    }

    public User()
    {

    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel parcel) {
            return new User(parcel);
        }

        @Override
        public User[] newArray(int i) {
            return new User[i];
        }
    };

    @Override
    public int describeContents(){
        return hashCode();
    }

    public static Creator<User> getCREATOR(){
        return CREATOR;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i){
        parcel.writeString(Id);
        parcel.writeString(FirstName);
        parcel.writeString(LastName);
        parcel.writeString(Email);
        parcel.writeString(PhoneNumber);
        parcel.writeString(StreetAddress);
        parcel.writeString(ApartmentNumber);
        parcel.writeString(City);
        parcel.writeString(State);
        parcel.writeString(Zip);
        parcel.writeString(Boolean.toString(IsEnrolled));
    }

    public String getId(){
        return Id;
    }

    public void setId(String id){
        Id = id;
    }

    public String getFirstName(){
        return FirstName;
    }

    public void setFirstName(String firstName){
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName){
        LastName = lastName;
    }

    public String getEmail(){
        return Email;
    }

    public void setEmail(String email){
        Email = email;
    }

    public String getAddress(){
        return StreetAddress;
    }

    public void setAddress(String address){
        StreetAddress = address;
    }

    public String getPhoneNumber(){
        return PhoneNumber;
    }

    public void setPhoneNumber(String phone){
        PhoneNumber = phone;
    }

    public String getAppartmentNumber(){
        return ApartmentNumber;
    }

    public void setApartmentNumber(String apartmentNum){
        ApartmentNumber = apartmentNum;
    }

    public String getCity(){
        return City;
    }

    public void setCity(String city){
        City = city;
    }

    public String getState(){
        return State;
    }

    public void setState(String state){
        State = state;
    }

    public String getZip(){
        return Zip;
    }

    public void setZip(String zip){
        Zip = zip;
    }

    public Boolean getIsEnrolled(){
        return IsEnrolled;
    }

    public void setIsEnrolled(Boolean isEnrolled){
        IsEnrolled = isEnrolled;
    }
}
