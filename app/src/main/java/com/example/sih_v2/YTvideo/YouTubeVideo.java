package com.example.sih_v2.YTvideo;

public class YouTubeVideo {
    String videoUrl;
    //String videoAddress;
    //default constructor

    public YouTubeVideo() {
    }

    //Constructor with args
    public YouTubeVideo(String videoUrl) {
        this.videoUrl = videoUrl;

    }
    //Getter and Setter


    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
