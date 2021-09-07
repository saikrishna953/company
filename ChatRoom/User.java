package com.company.ChatRoom;

public abstract class User {

    public String id;
    public String name;
    MediatorInterface mediatorInterface;
    User(String id, String name, MediatorInterface med){
        this.id = id;
        this.name = name;
        this.mediatorInterface = med;
    }

    public abstract void receive(String msg);
    public abstract void send(String msg,String id);
}
