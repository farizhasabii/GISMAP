package com.example.fariz.ui.data;

/**
 * Created by dimdimasdim on 10/03/2018.
 */

public class HomeMenu {

    private int imgMenu;

    private String titleMenu;

    public HomeMenu(int imgMenu, String titleMenu) {
        this.imgMenu = imgMenu;
        this.titleMenu = titleMenu;
    }

    public int getImgMenu() {
        return imgMenu;
    }

    public void setImgMenu(int imgMenu) {
        this.imgMenu = imgMenu;
    }

    public String getTitleMenu() {
        return titleMenu;
    }

    public void setTitleMenu(String titleMenu) {
        this.titleMenu = titleMenu;
    }
}
