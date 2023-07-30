package com.example.happybirthday

import android.os.Bundle
import android.text.Layout.Alignment
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    GreetingImage(message = getString(R.string.happy_birthday_text), form = getString(
                                            R.string.signature_text))
                }
            }
        }
    }
}
@Composable
fun GreetingImage(message:String,form:String,modifier: Modifier=Modifier){
    val image= painterResource(R.drawable.androidparty)
    Box {
        Image(painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha= 0.5F
        )
        GreetingText(message = message,
            form = form,
            modifier= Modifier
                .fillMaxSize()
                .padding(8.dp)
            )
    }
}
@Composable
fun GreetingText(message:String,form:String, modifier: Modifier=Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(8.dp)
    ) {
        Text(
            text = message,
            fontSize = 80.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = form,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HappyBirthdayTheme {
        GreetingImage(message = "Happy Birthday Tahira!","from Emma")
    }
}