package com.company.ChatRoom;

public class ChatRoomUser extends User {
    ChatRoomUser(String id, String name, MediatorInterface med) {
        super(id, name, med);
    }

    @Override
    public void receive(String msg) {
        System.out.println(this.name + "::Received message -" + msg);
    }

    @Override
    public void send(String msg, String id) {

        System.out.println(this.name + " :: Sending Message : " + msg);
        mediatorInterface.sendMessage(msg, id);
    }
}
