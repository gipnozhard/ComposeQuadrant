package com.lavrent.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lavrent.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingPreview() //функция препросмотра, для запуска ее на устройстве
                }
            }
        }
    }
}

@Composable
fun CardGreeting(
    title: String, // загалавие каждой карточки квадрата
    descriptinon: String, //описание карточки
    color: Color, // цвет карточки
    modifier: Modifier = Modifier // модификации контейнера в Compose
) {
    Column( // контейнер столбцов
        modifier = modifier
            .fillMaxSize() // занимать максимальный размер в контейнере
            .background(color) // цвет фона
            .padding(16.dp), // отступы
        horizontalAlignment = Alignment.CenterHorizontally, // содержимое контейнера занимает по горизонтали центральное значение контенера
        verticalArrangement = Arrangement.Center // содержимое контейнера занимает по вертикали центральное значение контенера

    ) {
        Text(
            text = title,
            modifier = Modifier.padding(16.dp),
            fontWeight = FontWeight.Bold // жирный шрифт
        )
        Text(
            text = descriptinon,
            textAlign = TextAlign.Justify // раятянуть по весь контейнер текст
        )
    }
}

@Preview(showBackground = true) // видимый фон
@Composable
fun GreetingPreview() { // функия предпросмотра
    Column { // контейнер столбцов
        Row(Modifier.weight(1f)) { //контейнер ряд занимает половина контенера столбцов
            CardGreeting(  // функция одной из карточки
                title = "Text composable",
                descriptinon = "Displays text and follows the recommended Material Design guidelines.",
                modifier = Modifier.weight(1f), // карточка ханимает половину контенера рядов
                color = Color(0xFFEADDFF)
            )
            CardGreeting( // функция одной из карточки
                title = "Image composable",
                descriptinon = "Creates a composable that lays out and draws a given Painter class object.",
                modifier = Modifier.weight(1f), // карточка ханимает половину контенера рядов
                color = Color(0xFFD0BCFF)
            )
        }
        Row(Modifier.weight(1f)) {
            CardGreeting( // функция одной из карточки
                title = "Row composable",
                descriptinon = "A layout composable that places its children in a horizontal sequence.",
                modifier = Modifier.weight(1f), // карточка ханимает половину контенера рядов
                color = Color(0xFFB69DF8)
            )
            CardGreeting( // функция одной из карточки
                title = "Column composable",
                descriptinon = "A layout composable that places its children in a vertical sequence.",
                modifier = Modifier.weight(1f), // карточка ханимает половину контенера рядов
                color = Color(0xFFF6EDFF)
            )
        }
    }
}