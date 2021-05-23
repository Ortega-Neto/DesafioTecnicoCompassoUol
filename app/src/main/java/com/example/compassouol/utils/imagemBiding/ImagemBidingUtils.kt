package com.example.compassouol.utils.imagemBiding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.compassouol.R

class ImagemBidingUtils{
    companion object{
        @JvmStatic
        @BindingAdapter("imagem")
        fun carregarImagem(view: ImageView, url: String){
            Glide.with(view)
                .load(url)
                .apply(RequestOptions().error(R.drawable.ic_no_image))
                .into(view)
        }
    }
}