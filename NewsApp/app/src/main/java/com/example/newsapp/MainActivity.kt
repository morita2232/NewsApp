package com.example.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.clases.DataLoader
import com.example.newsapp.models.Noticias
import com.example.newsapp.models.Theme
import com.example.newsapp.ui.theme.NewsAppTheme
import com.example.newsapp.ui.theme.Purple80

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

        NoticiasPorTema(noticias = DataLoader().loadNews())

    }

}

@Composable
fun NoticiasPorTema(noticias: List<Noticias>) {

    val noticiasPorTema = noticias.groupBy { it.themeResourceID }
    val temas = noticiasPorTema.keys.toList()

    val headerColor = Color(0xFFAB290C)
    val bColor = Color(0xFF0F8C51)


    var currentIndex by remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.background(color = headerColor).fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            // Mostrar el tema actual
            Text(
                text = temas[currentIndex].name,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .padding(16.dp), textAlign = TextAlign.Center,
                color = Color.White

            )
        }
        Spacer(modifier = Modifier.height(16.dp))


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { if (currentIndex > 0) currentIndex-- },
                enabled = currentIndex > 0, colors = ButtonDefaults.buttonColors(
                    containerColor = bColor,
                    contentColor = Color.White
                )
            ) {
                Text("<-", fontSize = 45.sp)
            }

            Button(
                onClick = { if (currentIndex < temas.size - 1) currentIndex++ },
                enabled = currentIndex < temas.size - 1, colors = ButtonDefaults.buttonColors(
                    containerColor = bColor,
                    contentColor = Color.White
                )
            ) {
                Text("->", fontSize = 45.sp)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))


        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(noticiasPorTema[temas[currentIndex]] ?: emptyList()) { noticia ->
                NoticiasCard(noticia)
            }
        }
    }
}



@Composable
fun NoticiasCard(infoNoticias: Noticias, modifier: Modifier = Modifier){

    Card(modifier = modifier) {

        Column(){

            Image(painter = painterResource(infoNoticias.imageResourceID), contentDescription = null, modifier = Modifier.fillMaxWidth().height(194.dp), contentScale = ContentScale.Crop)
            Text(text = stringResource(infoNoticias.titleResourceID), modifier = Modifier.padding(16.dp), fontWeight = FontWeight.ExtraBold, fontSize = 20.sp)
            Text(text = stringResource(infoNoticias.subTitleResourceID), modifier = Modifier.padding(16.dp), fontWeight = FontWeight.SemiBold, fontSize = 15.sp)
            Image(painter = painterResource(infoNoticias.writerImageResourceID), contentDescription = null,Modifier.size(70.dp))
            Text(text = stringResource(infoNoticias.writerNameResourceID), modifier = Modifier.padding(16.dp), fontStyle = FontStyle.Italic)

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