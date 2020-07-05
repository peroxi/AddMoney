package com.addmoney.view.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("bind:imageDrawable")
    fun setButtonDrawable(imageView: ImageView, drawableRes: Int){
        imageView.setImageResource(drawableRes)
    }

    @JvmStatic
    @BindingAdapter("bind:visibility")
    fun setVisibility(view: View, value: Boolean) {
        view.visibility = if (value) View.VISIBLE else View.GONE
    }
}