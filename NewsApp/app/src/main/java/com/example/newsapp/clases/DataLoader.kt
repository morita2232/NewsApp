package com.example.newsapp.clases

import com.example.newsapp.R
import com.example.newsapp.models.Noticias
import com.example.newsapp.models.Theme


class DataLoader() {

    fun loadNews() : List<Noticias>{
        return listOf<Noticias>(
            // CULTURA
            Noticias(R.drawable.patates, R.drawable.potatowriter, R.string.titulo1, R.string.subtitulo1, Theme.CULTURA, R.string.escritor1),
            Noticias(R.drawable.catsculpture, R.drawable.fancycat, R.string.titulo2, R.string.subtitulo2, Theme.CULTURA, R.string.escritor2),
            Noticias(R.drawable.theatre, R.drawable.duck, R.string.titulo3, R.string.subtitulo3, Theme.CULTURA, R.string.escritor3),

            // POLITICA
            Noticias(R.drawable.pizzabd, R.drawable.pizza, R.string.titulo4, R.string.subtitulo4, Theme.POLITICA, R.string.escritor4),
            Noticias(R.drawable.businesspjs, R.drawable.eepy, R.string.titulo5, R.string.subtitulo5, Theme.POLITICA, R.string.escritor5),
            Noticias(R.drawable.moonbd, R.drawable.moon, R.string.titulo6, R.string.subtitulo6, Theme.POLITICA, R.string.escritor6),

            // ESPORTS
            Noticias(R.drawable.tournament, R.drawable.gamercat, R.string.titulo7, R.string.subtitulo7, Theme.ESPORTS, R.string.escritor7),
            Noticias(R.drawable.twitch, R.drawable.gamer, R.string.titulo8, R.string.subtitulo8, Theme.ESPORTS, R.string.escritor8),
            Noticias(R.drawable.vr, R.drawable.tinycat, R.string.titulo9, R.string.subtitulo9, Theme.ESPORTS, R.string.escritor9)
        )

    }

}