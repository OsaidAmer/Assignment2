package com.example.pcp.as1;

/**
 * Created by Pcp on 16/12/2016.
 */

public class Lecture {
    String topic;
    String date;
    String lectureNumber;
    int iconId;
    int btnId;


    public Lecture(){

    }

    public Lecture(String topic, String lectureNumber, String date,int iconId){
        this.topic = topic;
        this.lectureNumber = lectureNumber;
        this.date = date;
        this.iconId = iconId;
    }
    public Lecture(String topic, String lectureNumber, String date,int iconId,int btnId){
        this.topic = topic;
        this.lectureNumber = lectureNumber;
        this.date = date;
        this.iconId = iconId;
        this.btnId = btnId;
    }

    public String getTopic() {
        return topic;
    }

    public String getLectureNumber() {
        return lectureNumber;
    }

    public void setLectureNumber(String lectureNumber) {
        this.lectureNumber = lectureNumber;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getBtnId() {
        return btnId;
    }

    public void setBtnId(int btnId) {
        this.btnId = btnId;
    }


}
