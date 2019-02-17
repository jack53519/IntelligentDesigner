package com.settings;

public class Settings {
    private int windowWidth, windowHeight;
    private float aspectRatio;
    private boolean vSyncEnabled;

    public Settings(int windowHeight, float aspectRatio, boolean vSyncEnabled){
        this.windowHeight = windowHeight;
        this.aspectRatio = aspectRatio;
        this.windowWidth = (int)((float)windowHeight*aspectRatio);
        this.vSyncEnabled = vSyncEnabled;
    }

    public int getWindowHeight() {
        return windowHeight;
    }

    public int getWindowWidth() {
        return windowWidth;
    }

    public boolean isvSyncEnabled() {
        return vSyncEnabled;
    }
}
