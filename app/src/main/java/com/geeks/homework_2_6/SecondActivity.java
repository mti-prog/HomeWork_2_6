package com.geeks.homework_2_6;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.geeks.homework_2_6.adapters.CategoryAdapter;
import com.geeks.homework_2_6.adapters.FoodAdapter;
import com.geeks.homework_2_6.clicklisteners.CategoryOnClickListener;
import com.geeks.homework_2_6.databinding.ActivitySecondBinding;
import com.geeks.homework_2_6.databinding.CategoryItemBinding;
import com.geeks.homework_2_6.items.CategoryItem;
import com.geeks.homework_2_6.items.FoodItem;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    private ActivitySecondBinding binding;
    private ArrayList<FoodItem> food = new ArrayList<>();
    private ArrayList<CategoryItem> category = new ArrayList<>();
    private CategoryItemBinding binding_category;
    private CategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        binding_category = CategoryItemBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        adapter = new CategoryAdapter(category, new CategoryOnClickListener() {
            @Override
            public void onClick(CategoryItem categoryItem) {

            }
        });
        binding.rvCategory.setLayoutManager(new LinearLayoutManager(SecondActivity.this, LinearLayoutManager.HORIZONTAL, false ));
        binding.rvCategory.setAdapter(adapter);
        categoryInit();
        FoodAdapter foodAdapter = new FoodAdapter(food, binding.rvFood);
        binding.rvFood.setLayoutManager(new LinearLayoutManager(SecondActivity.this, LinearLayoutManager.HORIZONTAL, false ));
        binding.rvFood.setAdapter(foodAdapter);
        BurgerInit();
    }

    private void categoryInit() {
        CategoryItem burger = new CategoryItem(R.drawable.ic_gray_hamburger, "Burgers");
        CategoryItem pizza = new CategoryItem(R.drawable.ic_gray_pizza, "Pizza");
        CategoryItem chicken = new CategoryItem(R.drawable.ic_gray_chicken, "Chicken ");
        category.add(burger);
        category.add(pizza);
        category.add(chicken);
    }

    private void BurgerInit() {
        FoodItem firstFood = new FoodItem("https://png.pngtree.com/png-clipart/20240830/original/pngtree-burger-with-floating-ingredient-png-image_15881303.png",
                "Salad Burger", "12$", 3.5f);
        FoodItem secondFood = new FoodItem("https://png.pngtree.com/png-clipart/20240830/original/pngtree-burger-with-floating-ingredient-png-image_15881303.png",
                "Salad Burger", "12$", 3.5f);
        FoodItem thirdFood = new FoodItem("https://png.pngtree.com/png-clipart/20240830/original/pngtree-burger-with-floating-ingredient-png-image_15881303.png",
                "Salad Burger", "12$", 3.5f);
        food.add(firstFood);
        food.add(secondFood);
        food.add(thirdFood);

    }

}