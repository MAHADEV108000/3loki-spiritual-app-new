package com.in.threeloki.spiritualpractice;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {

    private int dp(int value) {
        return (int) (value * getResources().getDisplayMetrics().density + 0.5f);
    }

    private TextView createText(String text, int size, int color, boolean bold) {
        TextView view = new TextView(this);
        view.setText(text);
        view.setTextSize(size);
        view.setTextColor(color);
        view.setGravity(Gravity.CENTER);
        view.setPadding(dp(10), dp(10), dp(10), dp(10));

        if (bold) {
            view.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        }

        return view;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView scrollView = new ScrollView(this);
        scrollView.setFillViewport(true);
        scrollView.setBackgroundColor(Color.WHITE);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER_HORIZONTAL);
        layout.setPadding(dp(20), dp(30), dp(20), dp(30));

        TextView title = createText(
                "3loki",
                34,
                Color.rgb(120, 65, 20),
                true
        );

        TextView subtitle = createText(
                "SPIRITUAL PRACTICE",
                18,
                Color.rgb(150, 80, 20),
                true
        );

        TextView welcome = createText(
                "Welcome to your spiritual journey",
                22,
                Color.BLACK,
                true
        );

        TextView description = createText(
                "Explore spiritual practices for body, breath and mind.",
                16,
                Color.DKGRAY,
                false
        );

        layout.addView(title, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                dp(70)
        ));

        layout.addView(subtitle, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                dp(50)
        ));

        layout.addView(welcome, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                dp(80)
        ));

        layout.addView(description, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                dp(80)
        ));

        addSection(layout, "Meditation");
        addSection(layout, "Pranayama");
        addSection(layout, "Asanas");
        addSection(layout, "Mudras");
        addSection(layout, "Breathework");
        addSection(layout, "Teachings");

        TextView footer = createText(
                "3loki Spiritual Practice",
                14,
                Color.GRAY,
                false
        );

        layout.addView(footer, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                dp(60)
        ));

        scrollView.addView(layout);
        setContentView(scrollView);
    }

    private void addSection(LinearLayout layout, String name) {

        TextView section = createText(
                name,
                20,
                Color.rgb(120, 65, 20),
                true
        );

        section.setBackgroundColor(Color.rgb(250, 247, 240));

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        dp(65)
                );

        params.setMargins(0, 0, 0, dp(12));

        layout.addView(section, params);
    }
}
