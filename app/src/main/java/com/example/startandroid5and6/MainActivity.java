package com.example.startandroid5and6;

import android.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialTextView showSecret = findViewById(R.id.name);
        FrameLayout secretLayout = findViewById(R.id.loading_layout);
        MaterialButton hideSecret = findViewById(R.id.secret);

        showSecret.setOnClickListener(view ->
                secretLayout.setVisibility(View.VISIBLE)
        );
        hideSecret.setOnClickListener(view ->
                secretLayout.setVisibility(View.GONE)
        );

        MaterialButton toast = findViewById(R.id.btn_toast);
        toast.setOnClickListener(v ->
                Toast.makeText(getApplicationContext(), R.string.toast_text, Toast.LENGTH_LONG).show()
        );

        MaterialButton snackbar = findViewById(R.id.btn_snackbar);
        AppCompatEditText screen = findViewById(R.id.screen);
        snackbar.setOnClickListener(v ->
                Snackbar.make(screen, R.string.snackbar_text, BaseTransientBottomBar.LENGTH_LONG).show()
        );

        MaterialButton dialogButton = findViewById(R.id.btn_dialog);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(R.string.dialog_title)
                .setMessage(R.string.dialog_message)
                .setPositiveButton(R.string.dialog_btn, (dialog, which) -> dialog.cancel());

        dialogButton.setOnClickListener(v ->
                builder.show()
        );

        MaterialButton touchDownButton = findViewById(R.id.btn_touch_down);
        touchDownButton.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                Toast.makeText(getApplicationContext(),
                        R.string.btn_touch_down_text,
                        Toast.LENGTH_SHORT).show();
                v.performClick();
                return true;
            }
            return false;
        });

        MaterialButton touchUpButton = findViewById(R.id.btn_touch_up);
        touchUpButton.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                Toast.makeText(getApplicationContext(),
                        R.string.btn_touch_up_text,
                        Toast.LENGTH_SHORT).show();
                v.performClick();
            }
            return false;
        });
    }
}