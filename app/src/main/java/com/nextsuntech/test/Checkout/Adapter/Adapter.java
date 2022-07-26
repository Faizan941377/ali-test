package com.nextsuntech.test.Checkout.Adapter;

import static com.nextsuntech.test.Model.CheckoutModelClass.CART_ITEMS;
import static com.nextsuntech.test.Model.CheckoutModelClass.PRICE_DETAILS;
import static com.nextsuntech.test.Model.CheckoutModelClass.SHOPPING_DETAILS;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nextsuntech.test.Checkout.CheckoutActivity;
import com.nextsuntech.test.Model.CheckoutModelClass;
import com.nextsuntech.test.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter {

    private List<CheckoutModelClass> checkoutModelClassList;

    public Adapter(CheckoutActivity checkoutActivity, List<CheckoutModelClass> checkoutModelClassList) {
        this.checkoutModelClassList = checkoutModelClassList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (checkoutModelClassList.get(position).getViewType()) {
            case 1:
                return CART_ITEMS;
            case 2:
                return PRICE_DETAILS;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case CART_ITEMS:
                View viewCartItems = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_cart_item, parent, false);
                return new ItemViewHolder(viewCartItems);
            case PRICE_DETAILS:
                View viewPriceDetails = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_checkout_price, parent, false);
                return new PriceViewHolder(viewPriceDetails);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (checkoutModelClassList.get(position).getViewType()) {
            case CART_ITEMS:
                Integer productImage = checkoutModelClassList.get(position).getImage();
                String title = checkoutModelClassList.get(position).getTitle();
                String price = checkoutModelClassList.get(position).getPrice();
                ((ItemViewHolder) holder).setCartItem(title, price, productImage);
                break;
            case PRICE_DETAILS:
                String subTotal = checkoutModelClassList.get(position).getSubTotal();
                String shippingFee = checkoutModelClassList.get(position).getShippingFee();
                String coupon = checkoutModelClassList.get(position).getCoupon();
                String orderTotal = checkoutModelClassList.get(position).getOrderTotal();
                ((PriceViewHolder) holder).setPrices(subTotal, shippingFee, coupon, orderTotal);
            default:
                return;
        }
    }

    @Override
    public int getItemCount() {
        return checkoutModelClassList.size();
    }

    class PriceViewHolder extends RecyclerView.ViewHolder {

        TextView subTotalTV;
        TextView shippingFeeTV;
        TextView couponTV;
        TextView orderTotalTV;

        public PriceViewHolder(@NonNull View itemView) {
            super(itemView);
            subTotalTV = itemView.findViewById(R.id.tv_checkout_subtotal);
            shippingFeeTV = itemView.findViewById(R.id.tv_checkout_shippingFee);
            couponTV = itemView.findViewById(R.id.tv_checkout_coupon);
            orderTotalTV = itemView.findViewById(R.id.tv_checkout_OrderTotal);
        }

        private void setPrices(String subTotal, String shippingFee, String coupon, String orderTotal) {
            subTotalTV.setText(subTotal);
            shippingFeeTV.setText(shippingFee);
            couponTV.setText(coupon);
            orderTotalTV.setText(orderTotal);
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView titleTV;
        TextView priceTV;
        ImageView productImageIV;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTV = itemView.findViewById(R.id.tv_rowCartItem_title);
            priceTV = itemView.findViewById(R.id.tv_rowCartItem_price);
            productImageIV = itemView.findViewById(R.id.iv_rowCartItem_productImage);
        }

        private void setCartItem(String title, String price, int productImage) {
            titleTV.setText(title);
            priceTV.setText(price);
            productImageIV.setImageResource(productImage);
        }
    }
}
