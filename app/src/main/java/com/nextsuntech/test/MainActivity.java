package com.nextsuntech.test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout checkoutBT;
    Dialog cleanCartDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        checkoutBT = findViewById(R.id.bt_main_checkout);


        checkoutBT.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_main_checkout:
                clearCartDialog();
                break;
            case R.id.bt_clearCartDialog_YesPlease:
                Toast.makeText(this, "ok...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_clearCartDialog_cancel:
                cleanCartDialog.dismiss();
                break;
        }
    }

    private void clearCartDialog() {

        RelativeLayout yesPleaseBT;
        TextView cancelBT;

        cleanCartDialog = new Dialog(this);
        cleanCartDialog.setContentView(R.layout.clear_cart_dialog);
        cleanCartDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        Window window = cleanCartDialog.getWindow();
        window.setGravity(Gravity.CENTER);

        yesPleaseBT=cleanCartDialog.findViewById(R.id.bt_clearCartDialog_YesPlease);
        cancelBT =cleanCartDialog.findViewById(R.id.tv_clearCartDialog_cancel);

        yesPleaseBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "yesPlease", Toast.LENGTH_SHORT).show();
                cleanCartDialog.dismiss();
            }
        });

        cancelBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanCartDialog.dismiss();
            }
        });
        window.setLayout(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT);
        cleanCartDialog.show();
    }
}