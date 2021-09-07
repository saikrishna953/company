package com.company.ChatRoom;

import java.util.HashMap;
import java.util.Map;

public class ChatRoom implements MediatorInterface{
    Map<String,User> map = new HashMap<>();

    @Override
    public void sendMessage(String msg, String userid) {
        User user  = map.get(userid);
        user.receive(msg);
    }

    @Override
    public void addUser(User user) {
        map.put(user.id,user);
    }
}
