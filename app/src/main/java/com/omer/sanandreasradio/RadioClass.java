package com.omer.sanandreasradio;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class RadioClass {
    private int radioID;
    private String radioName;


    public RadioClass(int radioID, String radioName) {
        this.radioID = radioID;
        this.radioName = radioName;

    }

    public int getRadioID() {
        return radioID;
    }

    public String getRadioName() {
        return radioName;
    }

}
