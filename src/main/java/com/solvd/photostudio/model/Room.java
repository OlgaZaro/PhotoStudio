package com.solvd.photostudio.model;


public class Room {
    private int id;
    private String title;
    private String roomPrice;
    private int photoShootID;

    public Room(int id, String title, String roomPrice, int photoShootID) {
        this.id = id;
        this.title = title;
        this.roomPrice = roomPrice;
        this.photoShootID = photoShootID;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getRoomPrice() {
        return roomPrice;
    }

    public int getPhotoShootID() {
        return photoShootID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRoomPrice(String roomPrice) {
        this.roomPrice = roomPrice;
    }

    public void setPhotoShootID(int photoShootID) {
        this.photoShootID = photoShootID;
    }

    @Override
    public String toString() {
        return "Room " +
                "id = " + id +
                ", title = '" + title + '\'' +
                ", roomPrice = '" + roomPrice + '\'' +
                ", photoShootId = " + photoShootID + '\n';
    }
}
