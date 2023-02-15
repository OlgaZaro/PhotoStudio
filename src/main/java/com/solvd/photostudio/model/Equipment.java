package com.solvd.photostudio.model;


public class Equipment {
    private int id;
    private String title;
    private int photoShootId;

    public Equipment(int id, String title, int photoShootId) {
        this.id = id;
        this.title = title;
        this.photoShootId = photoShootId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPhotoShootId() {
        return photoShootId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPhotoShoot_id(int photoShootId) {
        this.photoShootId = photoShootId;
    }

    @Override
    public String toString() {
        return "Equipment " +
                "id = " + id +
                ", title = '" + title + '\'' +
                ", photoShootId = " + photoShootId + '\n';
    }
}
