package com.geeks.homework_2_6.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.geeks.homework_2_6.R;
import com.geeks.homework_2_6.databinding.RvFoodItemBinding;
import com.geeks.homework_2_6.items.FoodItem;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    private ArrayList<FoodItem> food;
    private int selectedItem = -1;

    public FoodAdapter(ArrayList<FoodItem> food) {
        this.food = food;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RvFoodItemBinding binding = RvFoodItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FoodViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        holder.bind(food.get(position));
        if (position == selectedItem) {
            holder.binding.getRoot().setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.background_red_food));
            holder.binding.tvNameFood.setTextColor(Color.WHITE);
            holder.binding.tvPriceFood.setTextColor(Color.WHITE);
        } else {
            holder.binding.getRoot().setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.frame_def));
            holder.binding.tvNameFood.setTextColor(Color.GRAY);
            holder.binding.tvPriceFood.setTextColor(Color.GRAY);
        }

        holder.itemView.setOnClickListener(v -> {
            int prev = selectedItem;
            selectedItem = holder.getAdapterPosition();
            notifyItemChanged(prev);
            notifyItemChanged(selectedItem);
        });
    }

    @Override
    public int getItemCount() {
        return food.size();
    }

    public void setSelectedItem(int position) {
        selectedItem = position;
        notifyDataSetChanged();
    }

    public int getFirstMatchIndex(String query) {
        query = query.toLowerCase();
        for (int i = 0; i < food.size(); i++) {
            if (food.get(i).getName().toLowerCase().contains(query)) return i;
        }
        return -1;
    }

    public static class FoodViewHolder extends RecyclerView.ViewHolder {
        private RvFoodItemBinding binding;

        public FoodViewHolder(RvFoodItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(FoodItem foodItem) {
            Glide.with(binding.getRoot()).load(foodItem.getImage()).into(binding.ivFood);
            binding.tvNameFood.setText(foodItem.getName());
            binding.tvPriceFood.setText(foodItem.getPrice());
            binding.rbFood.setRating(foodItem.getRating());
        }
    }
}
