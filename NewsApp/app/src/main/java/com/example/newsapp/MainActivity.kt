package com.example.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newsapp.models.Noticias
import com.example.newsapp.models.Theme
import com.example.newsapp.ui.theme.NewsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppTheme {

                    NewsApp(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }


@Composable
fun NewsApp(modifier: Modifier){

    val layOutDirection = LocalLayoutDirection.current

    Surface(modifier = modifier
        .fillMaxSize()
        .statusBarsPadding()
        .padding(
            start = WindowInsets.safeDrawing
                .asPaddingValues()
                .calculateStartPadding(layOutDirection),
            end = WindowInsets.safeDrawing
                .asPaddingValues()
                .calculateEndPadding(layOutDirection)
        )){

        //LISTA

    }

}

@Composable
fun ListNoticias(noticiasLista : List<Noticias>, modifier: Modifier){
    LazyColumn(modifier = modifier) {

       items(noticiasLista){

           itemEnListaNoticias ->  NoticiasCard(
           infoNoticias = itemEnListaNoticias,
           modifier.padding(8.dp))

       }

    }
}

@Composable
fun NoticiasCard(infoNoticias: Noticias, modifier: Modifier = Modifier){

    Card(modifier = modifier) {

        Column(){

            Text(text = infoNoticias.themeResourceID.toString(), modifier = Modifier.padding(16.dp))
            Image(painter = painterResource(infoNoticias.imageResourceID), contentDescription = null, modifier = Modifier.fillMaxWidth().height(194.dp), contentScale = ContentScale.Crop)
            Text(text = stringResource(infoNoticias.titleResourceID), modifier = Modifier.padding(16.dp))
            Text(text = stringResource(infoNoticias.subTitleResourceID), modifier = Modifier.padding(16.dp))
            Image(painter = painterResource(infoNoticias.writerImageResourceID), contentDescription = null)
            Text(text = stringResource(infoNoticias.writerNameResourceID), modifier = Modifier.padding(16.dp))

        }

    }

}

@Preview
@Composable
fun ShowPreview(){
    NoticiasCard(Noticias(R.drawable.paisaje3, R.drawable.tails, R.string.titulo1, R.string.subtitulo1,
        Theme.ESPORTS, R.string.escritor1
    ), Modifier)
}