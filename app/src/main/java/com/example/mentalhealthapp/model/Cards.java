package com.example.mentalhealthapp.model;

import androidx.constraintlayout.widget.ConstraintLayout;

public class Cards {
    private int imageProfile;
    private String cardtext;

    public Cards(int imageProfile, String cardtext) {
        this.imageProfile = imageProfile;
        this.cardtext = cardtext;
    }

    public int getImageProfile() {
        return imageProfile;
    }

    public void setImageProfile(int imageProfile) {
        this.imageProfile = imageProfile;
    }

    public String getCardtext() {
        return cardtext;
    }

    public void setCardtext(String  cardtext) {
        this.cardtext = cardtext;
    }
}
