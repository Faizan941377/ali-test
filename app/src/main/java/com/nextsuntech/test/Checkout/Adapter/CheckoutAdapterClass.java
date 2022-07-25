package com.nextsuntech.test.Checkout.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nextsuntech.test.Model.CheckoutModelClass;
import com.nextsuntech.test.R;

import java.util.List;

public class CheckoutAdapterClass extends RecyclerView.Adapter<CheckoutAdapterClass.ViewHolder> {

    Context mContext;
    List<CheckoutModelClass> checkoutAdapterClassList;

    public CheckoutAdapterClass(Context mContext, List<CheckoutModelClass> checkoutAdapterClassList) {
        this.mContext = mContext;
        this.checkoutAdapterClassList = checkoutAdapterClassList;
    }

    @NonNull
    @Override
    public CheckoutAdapterClass.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_cart_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CheckoutAdapterClass.ViewHolder holder, int position) {
        holder.titleTV.setText(checkoutAdapterClassList.get(position).getTitle());
        holder.priceTV.setText(checkoutAdapterClassList.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return checkoutAdapterClassList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView titleTV;
        TextView priceTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTV =itemView.findViewById(R.id.tv_rowCartItem_title);
            priceTV =itemView.findViewById(R.id.tv_rowCartItem_price);
        }
    }
}
