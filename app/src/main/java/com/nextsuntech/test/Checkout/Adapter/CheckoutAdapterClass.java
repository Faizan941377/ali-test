package com.nextsuntech.test.Checkout.Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nextsuntech.test.Model.CheckoutModelClass;
import com.nextsuntech.test.R;

import java.util.List;

public class CheckoutAdapterClass extends RecyclerView.Adapter<CheckoutAdapterClass.ViewHOlder> {

    Context mContext;
    List<CheckoutModelClass> checkoutModelClassList;

    public CheckoutAdapterClass(Context mContext, List<CheckoutModelClass> checkoutModelClassList) {
        this.mContext = mContext;
        this.checkoutModelClassList = checkoutModelClassList;
    }

    @NonNull
    @Override
    public CheckoutAdapterClass.ViewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_cart_item,parent,false);
        return new ViewHOlder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CheckoutAdapterClass.ViewHOlder holder, int position) {
        holder.titleTV.setText(checkoutModelClassList.get(position).getTitle());
        holder.priceTV.setText(checkoutModelClassList.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return checkoutModelClassList.size();
    }

    public class ViewHOlder extends RecyclerView.ViewHolder {

        TextView titleTV;
        TextView priceTV;
        ImageView productImageIV;

        public ViewHOlder(@NonNull View itemView) {
            super(itemView);

            titleTV = itemView.findViewById(R.id.tv_rowCartItem_title);
            priceTV = itemView.findViewById(R.id.tv_rowCartItem_price);
            productImageIV = itemView.findViewById(R.id.iv_rowCartItem_productImage);
        }
    }
}

