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
    private ArrayList<FoodItem> food = new ArrayList<>();
    private int selectedItem = 0;
    private RecyclerView recyclerView;

    public FoodAdapter(ArrayList<FoodItem> food, RecyclerView recyclerView) {
        this.food = food;
        this.recyclerView = recyclerView;
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
        FoodItem item = food.get(position);
        holder.binding.tvNameFood.setText(item.getName());
        if (position == selectedItem){
            holder.binding.getRoot().setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.background_red_food));
            holder.itemView.animate().scaleX(1.1f).scaleY(1.1f).setDuration(200).start();
            holder.binding.tvNameFood.setTextColor(Color.WHITE);
            holder.binding.tvPriceFood.setTextColor(Color.WHITE);
        }else{
            holder.binding.getRoot().setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.frame_def));
            holder.itemView.animate().scaleX(1f).scaleY(1f).setDuration(200).start();
            holder.binding.tvNameFood.setTextColor(Color.GRAY);
            holder.binding.tvPriceFood.setTextColor(Color.GRAY);
        }
        holder.itemView.setOnClickListener(v -> {
            int previousPosition = selectedItem;
            selectedItem = holder.getAdapterPosition();
            notifyItemChanged(previousPosition);
            notifyItemChanged(selectedItem);
            recyclerView.smoothScrollToPosition(selectedItem);
        });
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
