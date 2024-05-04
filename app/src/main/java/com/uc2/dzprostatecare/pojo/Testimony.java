package com.uc2.dzprostatecare.pojo;

public class Testimony {
    private String name;
    private int itemID;
    private String UrlVideo;
    private String story;
    private String title;

    public Testimony(String name, int itemID, String urlVideo, String story, String title) {
        this.name = name;
        this.itemID = itemID;
        UrlVideo = urlVideo;
        this.story = story;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public int getItemID() {
        return itemID;
    }

    public String getUrlVideo() {
        return UrlVideo;
    }

    public String getStory() {
        return story;
    }

    public String getTitle() {
        return title;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public void setUrlVideo(String urlVideo) {
        UrlVideo = urlVideo;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
