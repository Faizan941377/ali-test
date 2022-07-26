package com.nextsuntech.test.Checkout;

import static com.nextsuntech.test.Model.CheckoutModelClass.CART_ITEMS;
import static com.nextsuntech.test.Model.CheckoutModelClass.PRICE_DETAILS;
import static com.nextsuntech.test.Model.CheckoutModelClass.SHOPPING_DETAILS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.nextsuntech.test.Checkout.Adapter.Adapter;
import com.nextsuntech.test.Model.CheckoutModelClass;
import com.nextsuntech.test.R;

import java.util.ArrayList;
import java.util.List;

public class CheckoutActivity extends AppCompatActivity {

    RecyclerView checkoutRV;
    Adapter adapter;
    private List<CheckoutModelClass> checkoutModelClassList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        checkoutRV = findViewById(R.id.rv_checkout);

        checkoutRV.setHasFixedSize(true);
        checkoutRV.setLayoutManager(new LinearLayoutManager(this));
        checkoutModelClassList = new ArrayList<>();
        checkoutModelClassList.add(new CheckoutModelClass(CART_ITEMS,R.drawable.ico_back,"Candy","300"));
        checkoutModelClassList.add(new CheckoutModelClass(CART_ITEMS,R.drawable.ico_back,"Candy","300"));
        checkoutModelClassList.add(new CheckoutModelClass(CART_ITEMS,R.drawable.ico_back,"Candy","300"));

        checkoutModelClassList.add(new CheckoutModelClass(PRICE_DETAILS,"12","34","10","100"));


        adapter = new Adapter(this,checkoutModelClassList);
        checkoutRV.setAdapter(adapter);
    }
}