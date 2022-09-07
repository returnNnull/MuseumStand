package com.bam.museumstand;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.Toast;

import com.bam.museumstand.databinding.ActivityMainBinding;
import com.bam.museumstand.language.LanguageItem;
import com.bam.museumstand.language.LanguageRecyclerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding __binding;
    private ExhibitViewModel __viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        __binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(__binding.getRoot());

        __viewModel = new ViewModelProvider(this).get(ExhibitViewModel.class);

//        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_activity_main);
//        NavController navController = navHostFragment.getNavController();
//        BottomNavigationView bottomNav = __binding.navView;
//        NavigationUI.setupWithNavController(bottomNav, navController);

        RecyclerView _languageRecyclerView = __binding.languageRecyclerView;
        LanguageRecyclerAdapter _languageRecyclerAdapter = new LanguageRecyclerAdapter();
        _languageRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        _languageRecyclerAdapter.observe(product -> __viewModel.loadExhibit(product.getCode()));
        _languageRecyclerAdapter.setList(AppItemsFactory.createLanguageItems(getResources()));
        _languageRecyclerView.setAdapter(_languageRecyclerAdapter);


        View.OnClickListener zoomInListener = v -> {
            __viewModel.setTextScale(1);
            v.startAnimation(new ScaleAnimation(0, 120, 0, 120));
        };

        View.OnClickListener zoomOutListener = v -> {
            __viewModel.setTextScale(-1);
            v.startAnimation(new ScaleAnimation(0, 120, 0, 120));
        };

        __binding.zoomIn.setOnClickListener(zoomInListener);
        __binding.zoomOut.setOnClickListener(zoomOutListener);



    }
}