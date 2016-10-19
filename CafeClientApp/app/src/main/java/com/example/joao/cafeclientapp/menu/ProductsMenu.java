package com.example.joao.cafeclientapp.menu;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by norim on 17/10/2016.
 */

public class ProductsMenu implements Parcelable, Serializable{
    private HashMap<Integer, Product> products;

    public ProductsMenu(HashMap<Integer, Product> m){
        this.products = m;
    }

    public ProductsMenu(Parcel parcel){
        parcel.readHashMap(HashMap.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeMap(products);
    }

    public static final Creator<ProductsMenu> CREATOR = new Creator<ProductsMenu>() {
        @Override
        public ProductsMenu createFromParcel(Parcel in) {
            return new ProductsMenu(in);
        }

        @Override
        public ProductsMenu[] newArray(int size) {
            return new ProductsMenu[size];
        }
    };

    public HashMap<Integer,Product> getProducts() {
        return products;
    }
}