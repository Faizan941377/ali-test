package com.nextsuntech.test.Checkout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.nextsuntech.test.Checkout.Adapter.CheckoutAdapterClass;
import com.nextsuntech.test.Model.CheckoutModelClass;
import com.nextsuntech.test.R;

import java.util.ArrayList;
import java.util.List;

public class CheckoutActivity extends AppCompatActivity {

    RecyclerView checkoutRV;
    CheckoutAdapterClass adapter;
    List<CheckoutModelClass> checkoutModelClassList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        checkoutRV = findViewById(R.id.rv_checkout);

        checkoutRV.setHasFixedSize(true);
        checkoutRV.setLayoutManager(new LinearLayoutManager(this));
        checkoutModelClassList = new ArrayList<>();
        checkoutModelClassList.add(new CheckoutModelClass("Candy","300",R.drawable.ico_back));
        checkoutModelClassList.add(new CheckoutModelClass("Candy","300",R.drawable.ico_back));
        checkoutModelClassList.add(new CheckoutModelClass("Candy","300",R.drawable.ico_back));
        checkoutModelClassList.add(new CheckoutModelClass("Candy","300",R.drawable.ico_back));
        checkoutModelClassList.add(new CheckoutModelClass("Candy","300",R.drawable.ico_back));
        checkoutModelClassList.add(new CheckoutModelClass("Candy","300",R.drawable.ico_back));


        adapter = new CheckoutAdapterClass(this,checkoutModelClassList);
        checkoutRV.setAdapter(adapter);
    }
}