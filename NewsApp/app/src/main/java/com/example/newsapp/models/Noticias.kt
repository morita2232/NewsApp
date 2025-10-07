package com.example.newsapp.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


enum class Theme { ESPORTS, CULTURA, POLITICA
}

data class Noticias(
     @DrawableRes val imageResourceID: Int,
     @DrawableRes val writerImageResourceID: Int,
     @StringRes val titleResourceID: Int,
     @StringRes val subTitleResourceID: Int,
     val themeResourceID: Theme,
     @StringRes val writerNameResourceID: Int

)
