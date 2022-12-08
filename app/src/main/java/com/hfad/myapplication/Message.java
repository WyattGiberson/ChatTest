package com.hfad.myapplication;

public class Message {
    private String message;
    private String time;
    private int type;

    public final static int TYPE_SENT = 0;
    public final static int TYPE_RECEIVED = 1;

    public Message(String m, String e, int t){
        message = m;
        type = t;
        time = e;
    }
    public void setType(int t){
        type = t;
    }


    public String getMessage(){
        return message;
    }
    public String getTime(){
        return time;
    }
    public int getType(){
        return type;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", type=" + type +
                ", time=" + time +
                '}';
    }
}
