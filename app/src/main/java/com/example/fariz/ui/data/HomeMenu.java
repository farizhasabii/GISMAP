package com.example.fariz.ui.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dimdimasdim on 10/03/2018.
 */

public class HomeMenu implements Parcelable{

    private int imgMenu;

    private String titleMenu;

    public HomeMenu(int imgMenu, String titleMenu) {
        this.imgMenu = imgMenu;
        this.titleMenu = titleMenu;
    }

    protected HomeMenu(Parcel in) {
        imgMenu = in.readInt();
        titleMenu = in.readString();
    }

    public static final Creator<HomeMenu> CREATOR = new Creator<HomeMenu>() {
        @Override
        public HomeMenu createFromParcel(Parcel in) {
            return new HomeMenu(in);
        }

        @Override
        public HomeMenu[] newArray(int size) {
            return new HomeMenu[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(imgMenu);
        parcel.writeString(titleMenu);
    }
}
