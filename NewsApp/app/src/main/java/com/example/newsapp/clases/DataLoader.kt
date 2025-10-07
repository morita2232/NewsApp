package com.example.newsapp.clases

import com.example.newsapp.R
import com.example.newsapp.models.Noticias
import com.example.newsapp.models.Theme


class DataLoader() {

    fun loadNews() : List<Noticias>{
        return listOf<Noticias>(
            Noticias(R.drawable.paisaje3, R.drawable.tails, R.string.titulo1, R.string.subtitulo1, Theme.CULTURA, R.string.escritor1),
            Noticias(R.drawable.paisaje3, R.drawable.tails, R.string.titulo2, R.string.subtitulo1, Theme.CULTURA, R.string.escritor2),
            Noticias(R.drawable.paisaje3, R.drawable.tails, R.string.titulo3, R.string.subtitulo3, Theme.CULTURA, R.string.escritor3),
            Noticias(R.drawable.paisaje3, R.drawable.tails, R.string.titulo1, R.string.subtitulo1, Theme.POLITICA, R.string.escritor1),
            Noticias(R.drawable.paisaje3, R.drawable.tails, R.string.titulo2, R.string.subtitulo2, Theme.POLITICA, R.string.escritor2),
            Noticias(R.drawable.paisaje3, R.drawable.tails, R.string.titulo3, R.string.subtitulo3, Theme.POLITICA, R.string.escritor3),
            Noticias(R.drawable.paisaje3, R.drawable.tails, R.string.titulo1, R.string.subtitulo1, Theme.ESPORTS, R.string.escritor1),
            Noticias(R.drawable.paisaje3, R.drawable.tails, R.string.titulo2, R.string.subtitulo2, Theme.ESPORTS, R.string.escritor2),
            Noticias(R.drawable.paisaje3, R.drawable.tails, R.string.titulo3, R.string.subtitulo3, Theme.ESPORTS, R.string.escritor3)
        )
    }

}