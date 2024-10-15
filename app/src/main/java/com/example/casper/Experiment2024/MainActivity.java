package com.example.casper.Experiment2024;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //使用布局文件创建控件
        setContentView(R.layout.activity_main);
        TextView textViewHelloWorld = findViewById(R.id.textview_hellworld);
        textViewHelloWorld.setText(R.string.hello_china);
        textViewHelloWorld.setText(R.string.hello_jnu);

        // Create a ConstraintLayout
        ConstraintLayout layout = new ConstraintLayout(this);
        layout.setLayoutParams(new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.MATCH_PARENT
        ));

        // Create a TextView
        TextView textView = new TextView(this);
        textView.setId(View.generateViewId());
        textView.setText("Hello, World!");

        // Create a Button
        Button button = new Button(this);
        button.setId(View.generateViewId());
        button.setText("Click me");

        // Add views to the layout
        layout.addView(textView);
        layout.addView(button);

        // Set constraints
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(layout);

        // Center TextView horizontally and place it at the top
        constraintSet.connect(textView.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 100);
        constraintSet.connect(textView.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, 0);
        constraintSet.connect(textView.getId(), ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, 0);

        // Center Button horizontally and vertically between TextView and bottom
        constraintSet.connect(button.getId(), ConstraintSet.TOP, textView.getId(), ConstraintSet.BOTTOM, 0);
        constraintSet.connect(button.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0);
        constraintSet.connect(button.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, 0);
        constraintSet.connect(button.getId(), ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, 0);
        constraintSet.setVerticalBias(button.getId(), 0.5f); // 50% between TextView and bottom

        constraintSet.applyTo(layout);

        // Set the layout as the content view
        setContentView(layout);

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

    }
}