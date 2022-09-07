package com.bam.museumstand.language;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.bam.museumstand.databinding.LanguageListItemBinding;

import java.util.ArrayList;
import java.util.List;

public class LanguageRecyclerAdapter extends RecyclerView.Adapter<LanguageRecyclerAdapter.ViewHolder> {

    private List<LanguageItem> __list = new ArrayList<>();
    private ItemClickListener __listener;


    @FunctionalInterface
    public interface ItemClickListener {
        void click(LanguageItem product);
    }

    public void observe(ItemClickListener listener) {
        __listener = listener;
    }

    public void setList(List<LanguageItem> list) {
        __list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LanguageListItemBinding _binding = LanguageListItemBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(_binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getBinding().setLanguage(__list.get(position));
        holder.getBinding().getRoot().setOnClickListener(v -> {
            __listener.click(__list.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return __list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final LanguageListItemBinding __binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            __binding = DataBindingUtil.findBinding(itemView);
        }

        public LanguageListItemBinding getBinding() {
            return __binding;
        }
    }
}
