package com.menglang.nestedrecyclerview;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.menglang.nestedrecyclerview.adapter.ParentAdapter;
import com.menglang.nestedrecyclerview.model.Category;
import com.menglang.nestedrecyclerview.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView parentRecyclerView;
    private ParentAdapter parentAdapter;
    private List<Category> categoryList; // Declare the list

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Handle insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize RecyclerView
        parentRecyclerView = findViewById(R.id.parentRecyclerView);
        parentRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize category list
        categoryList = new ArrayList<>();

        // Sample data
        List<Product> trending = Arrays.asList(
                new Product("Extraction 2", "https://image.tmdb.org/t/p/w500/A7EByudX0eOzlkQ2FIbogzyazm2.jpg"),
                new Product("Rebel Moon", "https://image.tmdb.org/t/p/w500/8rpDcsfLJypbO6vREc0547VKqEv.jpg")
        );

        List<Product> recentlyAdded = Arrays.asList(
                new Product("The Mother", "https://image.tmdb.org/t/p/w500/jrw684BhFJZ9Jac6KJda3hSQkxt.jpg"),
                new Product("Lift", "https://image.tmdb.org/t/p/w500/46sp1Z9b2PPTgCMyA87g9aTLUXi.jpg")

        );

        List<Product> topRated = Arrays.asList(
                new Product("The Gray Man", "https://image.tmdb.org/t/p/w500/27Mj3rFYP3xqFy7lnz17vEd8Ms.jpg"),
                new Product("Red Notice", "https://image.tmdb.org/t/p/w500/lAXONuqg41NwUMuzMiFvicDET9Y.jpg")
        );


        categoryList.add(new Category("Trending Now", trending));
        categoryList.add(new Category("Recently Added", recentlyAdded));
        categoryList.add(new Category("topRated New", topRated));

        // Set adapter
        parentAdapter = new ParentAdapter(categoryList);
        parentRecyclerView.setAdapter(parentAdapter);
    }
}
