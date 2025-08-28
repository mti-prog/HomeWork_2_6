package com.geeks.homework_2_6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.geeks.homework_2_6.databinding.RvFoodItemBinding;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    private ArrayList<FoodItem> food = new ArrayList<>();

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
    }

    @Override
    public int getItemCount() {
        return food.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {
        private RvFoodItemBinding binding;

        public FoodViewHolder(RvFoodItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(FoodItem foodItem){
            Glide.with(binding.getRoot()).load(foodItem.getImage()).into(binding.ivFood);
            binding.tvNameFood.setText(foodItem.getName());
            binding.tvPriceFood.setText(foodItem.getPrice());
            binding.rbFood.setRating(foodItem.getRating());
        }
    }
}
