package com.hybcode.temperatureconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hybcode.temperatureconverter.ui.theme.TemperatureConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TemperatureConverterTheme {
                Surface {
                    MainActivityContent()
                }
            }
        }
    }
}

@Composable
fun MainActivityContent(){
    val celsius = remember { mutableStateOf(0) }
    val newCelsius = remember { mutableStateOf("") }
    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally){
        Header(R.drawable.sunrise, "sunrise image")
        EnterTemperature(newCelsius.value) {newCelsius.value = it }
        Row(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center) {
            ConvertButton {
                newCelsius.value.toIntOrNull()?.let {
                    celsius.value = it
                }
            }
        }
        TemperatureText(celsius.value)
    }
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
fun EnterTemperature(temperature: String, changed: (String) -> Unit){
    TextField(
        value = temperature ,
        onValueChange = changed,
        label = { Text(text = "Enter a temperature in Celsius") },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun TemperatureText(celsius: Int){
    val fahrenheit = (celsius.toDouble() * 9/5) + 32
    Text(text = "$celsius Celsius is $fahrenheit Fahrenheit")
}

@Composable
fun ConvertButton(clicked: () -> Unit){
    Button(onClick = clicked) {
        Text(text = "Convert")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainActivity(){
    TemperatureConverterTheme {
        Surface {
            MainActivityContent()
        }
    }
}







