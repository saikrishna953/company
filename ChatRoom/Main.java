package com.company.ChatRoom;

public class Main {

    public static void main(String[] args)
    {
        MediatorInterface mediatorInterface = new ChatRoom();

        User user1 = new ChatRoomUser("1","sai",mediatorInterface);
        User user2 = new ChatRoomUser("2","kri",mediatorInterface);

        mediatorInterface.addUser(user1);
        mediatorInterface.addUser(user2);
        user1.send("hello bro","2");
        user2.send("Hey buddy", "1");

    }
}
