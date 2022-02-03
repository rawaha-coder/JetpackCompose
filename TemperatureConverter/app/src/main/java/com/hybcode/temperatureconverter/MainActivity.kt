package com.hybcode.temperatureconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityContent()
        }
    }
}

@Composable
fun MainActivityContent(){
    Header(R.drawable.sunrise, "sunrise image")
    TemperatureText(celsius = 0)
}

@Composable
fun Header(image: Int, description: String){
    Image(
        painter = painterResource(image),
        contentDescription = description,
        modifier = Modifier
            .height(180.dp)
            .fillMaxWidth(),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun TemperatureText(celsius: Int){
    val fahrenheit = (celsius.toDouble() * 9/5) + 32
    Text(text = "$celsius Celsius is $fahrenheit Fahrenheit")
}

@Preview(showBackground = true)
@Composable
fun PreviewMainActivity(){
    MainActivityContent()
}







