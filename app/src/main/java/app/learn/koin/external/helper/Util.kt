package app.learn.koin.external.helper

import android.support.v4.widget.CircularProgressDrawable
import android.widget.ImageView
import app.learn.koin.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadImageUrl(url: String) {
    val circularProgressDrawable = CircularProgressDrawable(this.rootView.context)
    circularProgressDrawable.strokeWidth = 5f
    circularProgressDrawable.centerRadius = 30f
    circularProgressDrawable.setColorSchemeColors(R.color.colorPrimaryDark)
    circularProgressDrawable.start()
    Glide.with(this.rootView.context)
        .load(url)
        .apply(RequestOptions().placeholder(circularProgressDrawable))
        .into(this)
}