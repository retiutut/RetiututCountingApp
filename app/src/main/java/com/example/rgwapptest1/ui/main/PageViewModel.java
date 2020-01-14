package com.example.rgwapptest1.ui.main;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class PageViewModel extends ViewModel {

    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();

    private LiveData<String> mText = Transformations.map(mIndex, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            return "Hello world from section: " + input;
        }
    });

    public void setIndex(int index) {
        mIndex.setValue(index);
    }

    public LiveData<String> getText() {
        return mText;
    }

    /////////////////////// Create a LiveData with an Integer ///////////////////////
    private MutableLiveData<Integer> liveData;

    public MutableLiveData<Integer> getLiveData() {
        if (liveData == null) {
            liveData = new MutableLiveData<Integer>();
            liveData.setValue(0);
        }
        return liveData;
    }
}