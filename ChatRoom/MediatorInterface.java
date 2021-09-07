package com.company.ChatRoom;

public interface MediatorInterface {

    void sendMessage(String msg,String userid);

    void addUser(User user);
}
