package com.bam.museumstand.language;

import android.graphics.drawable.Drawable;

public class LanguageItem {
    private Languages code;
    private Drawable icon;

    public LanguageItem(Languages code, Drawable icon) {
        this.code = code;
        this.icon = icon;
    }

    public Languages getCode() {
        return code;
    }

    public void setCode(Languages code) {
        this.code = code;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }
}
