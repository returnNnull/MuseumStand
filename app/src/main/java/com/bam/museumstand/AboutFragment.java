package com.bam.museumstand;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bam.museumstand.databinding.FragmentAboutBinding;

public class AboutFragment extends Fragment {

    private FragmentAboutBinding __binding;
    private ExhibitViewModel __viewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        __binding = FragmentAboutBinding.inflate(inflater, container, false);
        __viewModel = new ViewModelProvider(requireActivity()).get(ExhibitViewModel.class);
        __viewModel.getExhibit().observe(getViewLifecycleOwner(), exhibit -> __binding.setExhibit(exhibit));
        return __binding.getRoot();
    }
}