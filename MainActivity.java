package com.in.threeloki.spiritualpractice;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private int dp(float value) {
        return (int) (value * getResources().getDisplayMetrics().density + 0.5f);
    }

    private TextView text(String value, float size, int color, boolean bold) {
        TextView view = new TextView(this);
        view.setText(value);
        view.setTextSize(size);
        view.setTextColor(color);
        view.setGravity(Gravity.CENTER);
        if (bold) {
            view.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        }
        return view;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView scrollView = new ScrollView(this);
        scrollView.setBackgroundColor(Color.rgb(250, 247, 240));

        LinearLayout main = new LinearLayout(this);
        main.setOrientation(LinearLayout.VERTICAL);
        main.setPadding(dp(20), dp(30), dp(20), dp(30));

        TextView title = text(
                "3loki",
                36,
                Color.rgb(120, 65, 20),
                true
        );

        TextView subtitle = text(
                "SPIRITUAL PRACTICE",
                18,
                Color.rgb(170, 95, 25),
                true
        );

        TextView welcome = text(
                "Welcome to your spiritual journey",
                22,
                Color.rgb(45, 45, 45),
                true
        );

        TextView description = text(
                "Explore practices for body, breath, mind and inner awareness.",
                16,
                Color.DKGRAY,
                false
        );

        main.addView(title, new LinearLayout.LayoutParams(
                -1, dp(55)
        ));

        main.addView(subtitle, new LinearLayout.LayoutParams(
                -1, dp(40)
        ));

        main.addView(welcome, new LinearLayout.LayoutParams(
                -1, dp(70)
        ));

        main.addView(description, new LinearLayout.LayoutParams(
                -1, dp(70)
        ));

        addPractice(main, "Meditation",
                "Calm the mind and develop inner awareness.");

        addPractice(main, "Pranayama",
                "Discover conscious breathing practices.");

        addPractice(main, "Asanas",
                "Build balance, strength and flexibility.");

        addPractice(main, "Mudras",
                "Explore traditional hand gestures and practices.");

        addPractice(main, "Breathework",
                "Practice conscious breathing for relaxation and awareness.");

        addPractice(main, "Teachings",
                "Learn and explore spiritual teachings.");

        TextView footer = text(
                "3loki Spiritual Practice",
                14,
                Color.GRAY,
                false
        );

        footer.setPadding(0, dp(25), 0, dp(10));

        main.addView(footer);

        scrollView.addView(main);
        setContentView(scrollView);
    }

    private void addPractice(LinearLayout parent, String title, String description) {

        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setGravity(Gravity.CENTER);
        card.setPadding(dp(15), dp(12), dp(15), dp(12));
        card.setBackgroundColor(Color.WHITE);

        TextView heading = text(
                title,
                20,
                Color.rgb(120, 65, 20),
                true
        );

        TextView info = text(
                description,
                14,
                Color.DKGRAY,
                false
        );

        Button button = new Button(this);
        button.setText("Explore");
        button.setTextSize(14);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        MainActivity.this,
                        title + " section coming soon",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        card.addView(heading, new LinearLayout.LayoutParams(
                -1, dp(40)
        ));

        card.addView(info, new LinearLayout.LayoutParams(
                -1, dp(55)
        ));

        card.addView(button, new LinearLayout.LayoutParams(
                -2, dp(50)
        ));

        LinearLayout.LayoutParams cardParams =
                new LinearLayout.LayoutParams(-1, dp(175));

        cardParams.setMargins(0, 0, 0, dp(15));

        parent.addView(card, cardParams);
    }
}
