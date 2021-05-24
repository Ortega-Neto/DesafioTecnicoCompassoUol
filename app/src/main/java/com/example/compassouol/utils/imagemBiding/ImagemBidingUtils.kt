package com.example.compassouol.utils.imagemBiding

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import com.example.compassouol.R

@GlideModule
class ImagemBidingUtils: AppGlideModule() {
    companion object{
        @JvmStatic
        @BindingAdapter("imagem")
        fun carregarImagem(view: ImageView, url: String){
            Glide.with(view)
                .load(url)
                .apply(RequestOptions().error(R.drawable.ic_no_image))
                .into(view)
        }

        fun inserirImagemNoImageView(view: ImageView, url: String, context: Context){
            Glide.with(context)
                .load(url)
                .apply(RequestOptions().error(R.drawable.ic_no_image))
                .into(view)
        }
    }
}