package com.bam.museumstand;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bam.museumstand.databinding.FragmentExhibitBinding;
import com.bam.museumstand.stand.Exhibit;


public class ExhibitFragment extends Fragment {

    private ExhibitViewModel __viewModel;
    private FragmentExhibitBinding __binding;

    public ExhibitFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        __binding = FragmentExhibitBinding.inflate(inflater, container, false);
        __viewModel = new ViewModelProvider(requireActivity()).get(ExhibitViewModel.class);
        __viewModel.getExhibit().observe(getViewLifecycleOwner(), exhibit -> __binding.setExhibit(exhibit));


        __viewModel.getScale().observe(getViewLifecycleOwner(), scale -> {

            ViewGroup _viewGroup = __binding.container;
            int count = _viewGroup.getChildCount();
            for (int i = 0; i < count; i++) {
                View _view = _viewGroup.getChildAt(i);
                if (_view instanceof TextView){
                    float size = ((TextView) _view).getTextSize();
                    float newSize = size * scale / getResources().getDisplayMetrics().density;
                        ((TextView) _view).setTextSize(TypedValue.COMPLEX_UNIT_SP, newSize);
                }
            }

        });

        return __binding.getRoot();
    }
}