package com.bam.museumstand;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bam.museumstand.language.Languages;
import com.bam.museumstand.stand.Exhibit;

public class ExhibitViewModel extends AndroidViewModel {

    private MutableLiveData<Exhibit> __exhibit;

    private MutableLiveData<Float> __textScale = new MutableLiveData<>();

    private int count;

    public ExhibitViewModel(@NonNull Application application) {
        super(application);
    }
    public LiveData<Exhibit> getExhibit(){
        if (__exhibit == null){
            __exhibit = new MutableLiveData<>();
            loadExhibit(Languages.ENG);
        }
        return __exhibit;
    }

    public LiveData<Float> getScale(){
        if (__textScale == null){
            __textScale = new MutableLiveData<>();
            __textScale.setValue(0F);
        }
        return __textScale;
    }

    public void setTextScale(int scale) {

            if (scale > 0) __textScale.setValue(1.1F);
            else __textScale.setValue(0.8F);


    }

    public void loadExhibit(Languages languages) {
        __exhibit.setValue(AppItemsFactory.createExhibit(getApplication().getResources()).get(languages));
    }

}
