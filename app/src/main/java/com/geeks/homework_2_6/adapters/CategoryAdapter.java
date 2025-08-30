package com.geeks.homework_2_6.adapters;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.geeks.homework_2_6.R;
import com.geeks.homework_2_6.clicklisteners.CategoryOnClickListener;
import com.geeks.homework_2_6.databinding.CategoryItemBinding;
import com.geeks.homework_2_6.items.CategoryItem;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private ArrayList<CategoryItem> category = new ArrayList<>();
    private CategoryOnClickListener categoryOnClick;
    private int selectedPosition = 0;

    public CategoryAdapter(ArrayList<CategoryItem> category, CategoryOnClickListener categoryOnClickListener) {
        this.category = category;
        this.categoryOnClick = categoryOnClickListener;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CategoryItemBinding binding = CategoryItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CategoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.bind(category.get(position));
        CategoryItem item = category.get(position);
        holder.binding.tvFoodCate.setText(item.getName());
        if (position == selectedPosition) {
            holder.binding.tvFoodCate.setTextColor(Color.RED);
            holder.binding.ivFoodCate.setImageTintList(ColorStateList.valueOf(Color.RED));
            holder.binding.getRoot().setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.background_red_category));
        } else {
            holder.binding.tvFoodCate.setTextColor(Color.GRAY);
            holder.binding.ivFoodCate.setImageTintList(ColorStateList.valueOf(Color.GRAY));
            holder.binding.getRoot().setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.frame_def));
        }
        holder.itemView.setOnClickListener(v -> {
            int previousPosition = selectedPosition;
            selectedPosition = holder.getAdapterPosition();
            notifyItemChanged(previousPosition);
            notifyItemChanged(selectedPosition);
        });
    }

    @Override
    public int getItemCount() {
        return category.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        private CategoryItemBinding binding;

        public CategoryViewHolder(CategoryItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(CategoryItem categoryItem){
            binding.ivFoodCate.setImageResource(categoryItem.getImage());
            binding.tvFoodCate.setText(categoryItem.getName());
            binding.getRoot().setOnClickListener(v -> {
                categoryOnClick.onClick(categoryItem);
            });
        }
    }
}
