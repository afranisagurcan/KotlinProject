// Generated by view binder compiler. Do not edit!
package com.example.kotlinproject.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.kotlinproject.R;
import com.google.android.material.card.MaterialCardView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemAdapterBinding implements ViewBinding {
  @NonNull
  private final MaterialCardView rootView;

  @NonNull
  public final Button arrow;

  @NonNull
  public final ImageView itemImage;

  @NonNull
  public final LinearLayout itemLayout;

  @NonNull
  public final TextView itemPrice;

  @NonNull
  public final TextView itemTitle;

  private ItemAdapterBinding(@NonNull MaterialCardView rootView, @NonNull Button arrow,
      @NonNull ImageView itemImage, @NonNull LinearLayout itemLayout, @NonNull TextView itemPrice,
      @NonNull TextView itemTitle) {
    this.rootView = rootView;
    this.arrow = arrow;
    this.itemImage = itemImage;
    this.itemLayout = itemLayout;
    this.itemPrice = itemPrice;
    this.itemTitle = itemTitle;
  }

  @Override
  @NonNull
  public MaterialCardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemAdapterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemAdapterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_adapter, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemAdapterBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.arrow;
      Button arrow = ViewBindings.findChildViewById(rootView, id);
      if (arrow == null) {
        break missingId;
      }

      id = R.id.item_image;
      ImageView itemImage = ViewBindings.findChildViewById(rootView, id);
      if (itemImage == null) {
        break missingId;
      }

      id = R.id.item_layout;
      LinearLayout itemLayout = ViewBindings.findChildViewById(rootView, id);
      if (itemLayout == null) {
        break missingId;
      }

      id = R.id.item_price;
      TextView itemPrice = ViewBindings.findChildViewById(rootView, id);
      if (itemPrice == null) {
        break missingId;
      }

      id = R.id.item_title;
      TextView itemTitle = ViewBindings.findChildViewById(rootView, id);
      if (itemTitle == null) {
        break missingId;
      }

      return new ItemAdapterBinding((MaterialCardView) rootView, arrow, itemImage, itemLayout,
          itemPrice, itemTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
