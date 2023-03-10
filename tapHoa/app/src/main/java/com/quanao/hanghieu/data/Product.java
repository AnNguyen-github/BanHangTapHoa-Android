package com.quanao.hanghieu.data;

import android.widget.RatingBar;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;

public class Product implements Serializable {
    @SerializedName("id")
    String id;
    @SerializedName("name")
    String name;
    @SerializedName("price")
    String price;
    @SerializedName("type")
    String type;
    @SerializedName("description")
    String description;
    @SerializedName("imageView")
    String imageView;
    @SerializedName("quantity")
    String quantity;

    public Product(String id, String name, String price, String type, String description, String imageView,String quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.description = description;
        this.imageView = imageView;
        this.quantity = quantity;
    }

    public Product(String name) {
        this.name = name;
        this.price = "20";

        this.description = "description";

        this.type = "1";
        this.imageView = imageView;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getImageView() {
        return imageView;
    }

    public void setImageView(String imageView) {
        this.imageView = imageView;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
