package com.example.amazingcounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amazingcounter.ui.theme.AmazingCounterTheme
import kotlinx.coroutines.flow.MutableStateFlow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmazingCounterTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xffCDF0EA)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CounterButton()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AmazingCounterTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xffCDF0EA)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CounterButton()
            }
        }
    }
}

@Composable
fun CounterButton() {
    var counter = remember {
        mutableStateOf(value = 0)
    }
    var buttonColor = remember {
        mutableStateOf(Color(0xff6AC4B7))
    }
    Box(
        modifier = Modifier
            .size(148.dp)
            .background(color = buttonColor.value, shape = RoundedCornerShape(36.dp))
            .clickable {
                when(++counter.value){
                    10 -> buttonColor.value = Color.Blue
                    20 -> buttonColor.value = Color.Green
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = counter.value.toString(),
            style = TextStyle(color = Color.White, fontSize = 36.sp)
        )
    }
}