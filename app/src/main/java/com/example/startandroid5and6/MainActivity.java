package com.example.startandroid5and6;

import android.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TableLayout;
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
        TableLayout table = findViewById(R.id.table);
        snackbar.setOnClickListener(v ->
                Snackbar.make(table,R.string.snackbar_text, BaseTransientBottomBar.LENGTH_LONG).show()
        );

        MaterialButton dialogButton = findViewById(R.id.btn_dialog);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(R.string.dialog_title)
                .setMessage(R.string.dialog_message)
                .setPositiveButton(R.string.dialog_btn, (dialog, which) -> dialog.cancel());

        dialogButton.setOnClickListener(v ->
                builder.show()
        );
    }
}