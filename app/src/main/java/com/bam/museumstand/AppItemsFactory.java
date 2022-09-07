package com.bam.museumstand;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import androidx.core.content.res.ResourcesCompat;

import com.bam.museumstand.language.LanguageItem;
import com.bam.museumstand.language.Languages;
import com.bam.museumstand.stand.Author;
import com.bam.museumstand.stand.Exhibit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppItemsFactory {

    public static List<LanguageItem> createLanguageItems(Resources resources){

        return Arrays.asList(
                new LanguageItem(Languages.ENG, getDrawable(resources, R.drawable.flag_of_the_united_kingdom_svg)),
                new LanguageItem(Languages.CHN, getDrawable(resources, R.drawable.republic_of_china_flag)),
                new LanguageItem(Languages.FRA, getDrawable(resources, R.drawable.flag_of_france)),
                new LanguageItem(Languages.ITA, getDrawable(resources, R.drawable.italia_flag)),
                new LanguageItem(Languages.ESP, getDrawable(resources, R.drawable.spanish_flag))
        );
    }


    public static Map<Languages, Exhibit> createExhibit(Resources resources){
        Map<Languages, Exhibit> result = new HashMap<>();
        Arrays.stream(Languages.values()).forEach(e -> {
            Exhibit _exhibit = getExhibit(e);
            _exhibit.getAuthor().setImg(getDrawable(resources, R.drawable.author));
            result.put(e, _exhibit);
        });
        return result;
    }


    private static Exhibit getExhibit(Languages languages){
        return new Exhibit(getExhibitName(languages), getExhibitAbout(languages), getExhibitAuthor(languages));
    }

    private static String getExhibitName(Languages languages){
        switch (languages){
            case RUS: return "Зима в Голландском городе";
            case CHN: return "荷蘭小鎮的冬天";
            case ENG: return "Winter in a Dutch town";
            case FRA: return "L'hiver dans une ville hollandaise";
            case ESP: return "Invierno en un pueblo holandés";
            case ITA: return "Inverno in una città olandese";
            default: return "";
        }
    }

    private  static String getExhibitAbout(Languages languages){
        switch (languages){
            case RUS: return "дерево, масло";
            case CHN: return "木頭、油";
            case ENG: return "wood, oil";
            case FRA: return "bois, huile";
            case ESP: return "madera, aceite";
            case ITA: return "legno, olio";
            default: return "";
        }
    }

    private static Author getExhibitAuthor(Languages languages){

        return  new Author(getAuthorName(languages), getAuthorYears(languages), getAuthorAbout(languages));
    }

    private static String getAuthorYears(Languages languages) {

        switch (languages){
            case RUS: return "(1586 - Май 14, 1666)";
            case CHN: return "（1586 年 - 1666 年 5 月 14 日）";
            case ENG: return "(1586 - May 14, 1666)";
            case FRA: return "(1586 - 14 mai 1666)";
            case ESP: return "(1586 - 14 de mayo de 1666)";
            case ITA: return "(1586 - 14 maggio 1666)";
            default: return "";
        }

    }

    private static String getAuthorAbout(Languages languages) {
        switch (languages){
            case RUS: return "Утрехт Нидерландский художник жанровых картин, деревенских сцен," +
                    " моральных аллегорий, пейзажей и библейских историй.";
            case CHN: return "烏得勒支荷蘭畫家，擅長風俗畫、鄉村場景、道德寓言、風景和聖經故事";
            case ENG: return "Utrecht Netherlandish painter of genre paintings, village scenes, moral allegories, landscapes and biblical stories.";
            case FRA: return "Utrecht Néerlandais peintre de scènes de genre, de scènes villageoises, d'allégories morales, de paysages et de récits bibliques.";
            case ESP: return "Utrecht Pintor holandés de pinturas de género, escenas de pueblos, alegorías morales, paisajes e historias bíblicas.";
            case ITA: return "Utrecht Pittore olandese di dipinti di genere, scene di villaggio, allegorie morali, paesaggi e racconti biblici.";
            default: return "";
        }
    }

    private static String getAuthorName(Languages languages) {
        switch (languages){
            case RUS: return "Иост Корнелис Дрохслот";
            case CHN: return "Jost Corneliz Drochsloot";
            case ENG: return "Jost Corneliz Drochsloot";
            case FRA: return "Jost Corneliz Drochsloot";
            case ESP: return "Jost Corneliz Drochsloot";
            case ITA: return "Jost Corneliz Drochsloot";
            default: return "";
        }
    }


    private static Drawable getDrawable(Resources resources, int resId){
        return ResourcesCompat.getDrawable(resources, resId, null);
    }

    
}
