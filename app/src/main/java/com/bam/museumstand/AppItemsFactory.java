package com.bam.museumstand;

import android.content.Context;
import android.content.res.Resources;

import androidx.core.content.res.ResourcesCompat;

import java.net.ContentHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AppItemsFactory {

    public static List<LanguageItem> getLanguageItems(Resources resources){

        return Arrays.asList(
                new LanguageItem(Languages.RUS, ResourcesCompat.getDrawable(resources, R.drawable.flag_of_russia_svg, null)),
                new LanguageItem(Languages.ENG, ResourcesCompat.getDrawable(resources, R.drawable.flag_of_the_united_kingdom_svg, null))
        );
    }

    
}
