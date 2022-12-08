package com.hfad.myapplication;

import java.util.ArrayList;

public class DataBase {
    private static ArrayList<Message> messages;

    public static ArrayList<Message> getMessages() {
        if (messages == null) {
            loadData();
        }
        return messages;
    }

    private static void loadData() {
        messages = new ArrayList<Message>();

        ArrayList<String> messagesSent = new ArrayList<String>();
        messagesSent.add("Study for Calc Final");
        messagesSent.add("Study for Bio Final");
        messagesSent.add("Study for CompSci Final");
        messagesSent.add("Study for Art Final");
        messagesSent.add("Study for Chem Final");
        messagesSent.add("Study for Multi Final");
        messagesSent.add("Study for Film Final");
        messagesSent.add("Study for Game Final");
        messagesSent.add("Study for Lan Final");
        messagesSent.add("Study for Hist Final");
        messagesSent.add("Last");

        for (int i=0; i < messagesSent.size(); i++){
            messages.add(new Message(messagesSent.get(i), Message.TYPE_SENT));
        }
        for (int i=0; i < messagesSent.size(); i = i + 3){
            messages.get(i).setType(Message.TYPE_RECEIVED);
        }
        System.out.println(messages);
    }
}

