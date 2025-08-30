package com.geeks.homework_2_6;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.geeks.homework_2_6.adapters.CategoryAdapter;
import com.geeks.homework_2_6.adapters.FoodAdapter;
import com.geeks.homework_2_6.clicklisteners.CategoryOnClickListener;
import com.geeks.homework_2_6.databinding.ActivitySecondBinding;
import com.geeks.homework_2_6.items.CategoryItem;
import com.geeks.homework_2_6.items.FoodItem;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    private ActivitySecondBinding binding;
    private CategoryAdapter categoryAdapter;
    private FoodAdapter foodAdapter;
    private ArrayList<CategoryItem> categoryItems;
    private ArrayList<FoodItem> foodItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadDataCategory();
        loadDataFood(categoryItems.get(0)); // по умолчанию Pizza


        foodAdapter = new FoodAdapter(foodItems);
        binding.rvFood.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.rvFood.setAdapter(foodAdapter);


        categoryAdapter = new CategoryAdapter(categoryItems, categoryItem -> {
            loadDataFood(categoryItem);
            foodAdapter.setSelectedItem(-1);
        });
        binding.rvCategory.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.rvCategory.setAdapter(categoryAdapter);


        binding.etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                String query = s.toString().toLowerCase();


                int catIndex = categoryAdapter.getCategoryIndex(query);
                if (catIndex != -1) {
                    categoryAdapter.setSelectedCategory(catIndex);
                    binding.rvCategory.smoothScrollToPosition(catIndex);
                    loadDataFood(categoryItems.get(catIndex));
                    foodAdapter.setSelectedItem(-1);
                }


                int foodIndex = foodAdapter.getFirstMatchIndex(query);
                if (foodIndex != -1) {
                    binding.rvFood.smoothScrollToPosition(foodIndex);
                    foodAdapter.setSelectedItem(foodIndex);
                } else {
                    foodAdapter.setSelectedItem(-1);
                }
            }

            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
    }


    private void loadDataCategory() {
        categoryItems = new ArrayList<>();
        categoryItems.add(new CategoryItem(R.drawable.ic_gray_pizza, "Pizza"));
        categoryItems.add(new CategoryItem(R.drawable.ic_red_hamburger, "Burger"));
        categoryItems.add(new CategoryItem(R.drawable.ic_gray_chicken, "Chicken"));
    }


    private void loadDataFood(CategoryItem categoryItem) {
        foodItems.clear();
        switch (categoryItem.getName()) {
            case "Pizza":
                foodItems.add(new FoodItem("https://png.pngtree.com/png-vector/20240829/ourmid/pngtree-delicious-and-testy-cheese-burger-png-image_13659847.png", "Peperoni", "12$", 3.5f));
                foodItems.add(new FoodItem("https://png.pngtree.com/png-vector/20240829/ourmid/pngtree-delicious-and-testy-cheese-burger-png-image_13659847.png", "Margherita", "14$", 4.0f));
                foodItems.add(new FoodItem("https://png.pngtree.com/png-vector/20240829/ourmid/pngtree-delicious-and-testy-cheese-burger-png-image_13659847.png", "A Margherita", "14$", 4.0f));
                foodItems.add(new FoodItem("https://png.pngtree.com/png-vector/20240829/ourmid/pngtree-delicious-and-testy-cheese-burger-png-image_13659847.png", "B Margherita", "14$", 4.0f));
                foodItems.add(new FoodItem("https://png.pngtree.com/png-vector/20240829/ourmid/pngtree-delicious-and-testy-cheese-burger-png-image_13659847.png", "C Margherita", "14$", 4.0f));
                foodItems.add(new FoodItem("https://png.pngtree.com/png-vector/20240829/ourmid/pngtree-delicious-and-testy-cheese-burger-png-image_13659847.png", "D Margherita", "14$", 4.0f));
                foodItems.add(new FoodItem("https://png.pngtree.com/png-vector/20240829/ourmid/pngtree-delicious-and-testy-cheese-burger-png-image_13659847.png", "E Margherita", "14$", 4.0f));
                foodItems.add(new FoodItem("https://png.pngtree.com/png-vector/20240829/ourmid/pngtree-delicious-and-testy-cheese-burger-png-image_13659847.png", "F Margherita", "14$", 4.0f));
                foodItems.add(new FoodItem("https://png.pngtree.com/png-vector/20240829/ourmid/pngtree-delicious-and-testy-cheese-burger-png-image_13659847.png", "G Margherita", "14$", 4.0f));
                break;
            case "Burger":
                foodItems.add(new FoodItem("https://png.pngtree.com/png-vector/20240829/ourmid/pngtree-delicious-and-testy-cheese-burger-png-image_13659847.png", "Cheeseburger", "24$", 4.5f));
                foodItems.add(new FoodItem("https://png.pngtree.com/png-vector/20240829/ourmid/pngtree-delicious-and-testy-cheese-burger-png-image_13659847.png", "Double Burger", "30$", 4.7f));
                foodItems.add(new FoodItem("https://png.pngtree.com/png-vector/20240829/ourmid/pngtree-delicious-and-testy-cheese-burger-png-image_13659847.png", "A Burger", "30$", 4.7f));
                foodItems.add(new FoodItem("https://png.pngtree.com/png-vector/20240829/ourmid/pngtree-delicious-and-testy-cheese-burger-png-image_13659847.png", "B Burger", "30$", 4.7f));
                foodItems.add(new FoodItem("https://png.pngtree.com/png-vector/20240829/ourmid/pngtree-delicious-and-testy-cheese-burger-png-image_13659847.png", "C Burger", "30$", 4.7f));
                foodItems.add(new FoodItem("https://png.pngtree.com/png-vector/20240829/ourmid/pngtree-delicious-and-testy-cheese-burger-png-image_13659847.png", "D Burger", "30$", 4.7f));
                foodItems.add(new FoodItem("https://png.pngtree.com/png-vector/20240829/ourmid/pngtree-delicious-and-testy-cheese-burger-png-image_13659847.png", "E Burger", "30$", 4.7f));
                foodItems.add(new FoodItem("https://png.pngtree.com/png-vector/20240829/ourmid/pngtree-delicious-and-testy-cheese-burger-png-image_13659847.png", "F Burger", "30$", 4.7f));
                foodItems.add(new FoodItem("https://png.pngtree.com/png-vector/20240829/ourmid/pngtree-delicious-and-testy-cheese-burger-png-image_13659847.png", "G Burger", "30$", 4.7f));
                foodItems.add(new FoodItem("https://png.pngtree.com/png-vector/20240829/ourmid/pngtree-delicious-and-testy-cheese-burger-png-image_13659847.png", "h Burger", "30$", 4.7f));
                break;
            case "Chicken":
                foodItems.add(new FoodItem("https://png.pngtree.com/png-vector/20240829/ourmid/pngtree-delicious-and-testy-cheese-burger-png-image_13659847.png", "Fried Chicken", "32$", 2.5f));
                foodItems.add(new FoodItem("https://png.pngtree.com/png-vector/20240829/ourmid/pngtree-delicious-and-testy-cheese-burger-png-image_13659847.png", "Grilled Chicken", "28$", 3.8f));
                foodItems.add(new FoodItem("https://png.pngtree.com/png-vector/20240829/ourmid/pngtree-delicious-and-testy-cheese-burger-png-image_13659847.png", "H Chicken", "28$", 3.8f));
                foodItems.add(new FoodItem("https://png.pngtree.com/png-vector/20240829/ourmid/pngtree-delicious-and-testy-cheese-burger-png-image_13659847.png", "G Chicken", "28$", 3.8f));
                foodItems.add(new FoodItem("https://png.pngtree.com/png-vector/20240829/ourmid/pngtree-delicious-and-testy-cheese-burger-png-image_13659847.png", "F Chicken", "28$", 3.8f));
                foodItems.add(new FoodItem("https://png.pngtree.com/png-vector/20240829/ourmid/pngtree-delicious-and-testy-cheese-burger-png-image_13659847.png", "E Chicken", "28$", 3.8f));
                foodItems.add(new FoodItem("https://png.pngtree.com/png-vector/20240829/ourmid/pngtree-delicious-and-testy-cheese-burger-png-image_13659847.png", "D Chicken", "28$", 3.8f));
                foodItems.add(new FoodItem("https://png.pngtree.com/png-vector/20240829/ourmid/pngtree-delicious-and-testy-cheese-burger-png-image_13659847.png", "C Chicken", "28$", 3.8f));
                foodItems.add(new FoodItem("https://png.pngtree.com/png-vector/20240829/ourmid/pngtree-delicious-and-testy-cheese-burger-png-image_13659847.png", "B Chicken", "28$", 3.8f));
                foodItems.add(new FoodItem("https://png.pngtree.com/png-vector/20240829/ourmid/pngtree-delicious-and-testy-cheese-burger-png-image_13659847.png", "A Chicken", "28$", 3.8f));
                break;
        }
        if (foodAdapter != null) {
            foodAdapter.notifyDataSetChanged();
        }
    }
}