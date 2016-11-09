package com.example.deepak14035.assignment4;

import java.util.Date;
import java.util.UUID;

/**
 * Created by deepak14035 on 08/11/2016.
 */
public class Crime {
    UUID mid;
    String mTitle;
    boolean mSolved;
    String mDate;

    public String getTitle(){
        return mTitle;
    }
    public UUID getId(){
        return mid;
    }
    public void setTitle(String title){
        mTitle=title;
    }
    public void setSolved(boolean solved){
        mSolved=solved;
    }
    public void setDate(String date){
        mDate=date;
    }
    public void setId(UUID id){
        mid=id;
    }
    public String getDate(){
        return mDate;
    }
    public boolean getSolved(){
        return mSolved;
    }
}
