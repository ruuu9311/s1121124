package com.example.s1121124

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope.SlideDirection.Companion.Start
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.s1121124.ui.theme.S1121124Theme
import androidx.compose.ui.platform.LocalContext

import android.app.Activity
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            S1121124Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                    Greeting(
                        name = "android",
                        modifier = Modifier.padding(innerPadding)

                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val activity = (LocalContext.current as? Activity)
    var colors = arrayListOf(Color(0xff95fe95),Color(0xfffdca0f),Color(0xfffea4a4),Color(0xffa5dfed)
    )
    var Number by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colors[Number])
            .pointerInput(Unit) {
                detectDragGesturesAfterLongPress(
                    onDrag = { change, dragAmount -> change.consume()
                             /*if( dragAmount > 0){
                                 Number=(Number+1)%colors.size
                             }
                            else if(dragAmount < 0){
                                Number=(Number+1+colors.size)%colors.size
                            }*/
                                 }

                )
            }
    )
        Column(
            horizontalAlignment = Alignment . CenterHorizontally) {
            Text(
                text = "2024期末上機考(資管二B蔡鈞如)\n",
                modifier = modifier
            )
            Image(
                painter = painterResource(id = R.drawable.class_b),
                contentDescription = "",
            )
            Text(
                text = "遊戲持續時間 0 秒",
                //modifier = modifier
            )
            Text(
                text = "您的成績 0 分",
                //modifier = modifier
            )
            Button(onClick = {
                activity?.finish()
            }) {
                Text(text = "結束APP")
            }

        }
    }
