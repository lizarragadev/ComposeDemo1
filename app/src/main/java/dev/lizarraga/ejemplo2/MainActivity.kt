package dev.lizarraga.ejemplo2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.lizarraga.ejemplo2.ui.theme.Ejemplo2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ejemplo2Theme {
               Calculadora()
            }
        }
    }

    @Composable
    fun Calculadora() {
        Surface(modifier = Modifier.fillMaxSize()) {
            val modifier = Modifier
            val myViewModel = MyViewModel()
            PantallaPrincipal(modifier, myViewModel)
        }
    }

    @Composable
    fun PantallaPrincipal(modifier: Modifier, myViewModel: MyViewModel) {
        Column(modifier = Modifier.fillMaxSize()) {
            SeccionResultado(modifier, myViewModel)
            Divider()
            SeccionBotones(modifier, myViewModel)
        }
    }
    
    @Composable
    fun SeccionResultado(modifier: Modifier, myViewModel: MyViewModel) {
        Column(modifier = Modifier
            .height(300.dp)
            .fillMaxWidth(),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center) {
            Text(text = myViewModel.input, modifier.padding(end = 25.dp, top = 50.dp), 
                fontSize = 40.sp, color = Color.Blue, fontWeight = FontWeight.Bold
            )
            Text(text = myViewModel.result, modifier.padding(end = 25.dp, bottom = 80.dp), 
            fontSize = 60.sp, color = Color.DarkGray)
        }
    }
    
    @Composable
    fun SeccionBotones(modifier: Modifier, myViewModel: MyViewModel) {
        Column(modifier.fillMaxSize()) {
            Row(
                modifier
                    .fillMaxSize()
                    .weight(1F),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically) {
                BotonCalc(name = "C", modifier = modifier, Color.Red, myViewModel)
                BotonCalc(name = "(", modifier = modifier, Color.DarkGray, myViewModel)
                BotonCalc(name = ")", modifier = modifier, Color.DarkGray, myViewModel)
                BotonCalc(name = "/", modifier = modifier, Color.DarkGray, myViewModel)

            }
            Row(
                modifier
                    .fillMaxSize()
                    .weight(1F),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically) {
                BotonCalc(name = "7", modifier = modifier, Color.DarkGray, myViewModel)
                BotonCalc(name = "8", modifier = modifier, Color.DarkGray, myViewModel)
                BotonCalc(name = "9", modifier = modifier, Color.DarkGray, myViewModel)
                BotonCalc(name = "*", modifier = modifier, Color.DarkGray, myViewModel)
            }
            Row(
                modifier
                    .fillMaxSize()
                    .weight(1F),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically) {
                BotonCalc(name = "4", modifier = modifier, Color.DarkGray, myViewModel)
                BotonCalc(name = "5", modifier = modifier, Color.DarkGray, myViewModel)
                BotonCalc(name = "6", modifier = modifier, Color.DarkGray, myViewModel)
                BotonCalc(name = "-", modifier = modifier, Color.DarkGray, myViewModel)

            }
            Row(
                modifier
                    .fillMaxSize()
                    .weight(1F),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically) {
                BotonCalc(name = "1", modifier = modifier, Color.DarkGray, myViewModel)
                BotonCalc(name = "2", modifier = modifier, Color.DarkGray, myViewModel)
                BotonCalc(name = "3", modifier = modifier, Color.DarkGray, myViewModel)
                BotonCalc(name = "+", modifier = modifier, Color.DarkGray, myViewModel)

            }
            Row(
                modifier
                    .fillMaxSize()
                    .weight(1F),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically) {
                BotonCalc(name = "0", modifier = modifier, Color.DarkGray, myViewModel)
                BotonCalc(name = ",", modifier = modifier, Color.DarkGray, myViewModel)
                BotonCalc(name = "%", modifier = modifier, Color.DarkGray, myViewModel)
                BotonCalc(name = "=", modifier = modifier, Color.Yellow, myViewModel)

            }
        }
    }

    @Composable
    fun BotonCalc(name: String, modifier: Modifier, color: Color,
                  myViewModel: MyViewModel) {
        when(name) {
            "=" -> {
                Button(onClick = { myViewModel.getResultt() },
                    modifier.size(70.dp, 70.dp),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(Color.Green)) {
                    Text(text = name, textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold, fontSize = 30.sp, color = color)
                }
            }
            "C" -> {
                Button(onClick = { myViewModel.onInputChange("") },
                    modifier.size(70.dp, 70.dp),
                    shape = CircleShape) {
                    Text(text = name, textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold, fontSize = 30.sp, color = color)
                }
            }
            else -> {
                Button(onClick = { myViewModel.onInputChange(name) },
                    modifier.size(70.dp, 70.dp),
                    shape = CircleShape) {
                    Text(text = name, textAlign = TextAlign.Center,
                        fontSize = 30.sp, color = color)
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        Ejemplo2Theme {
            Calculadora()
        }
    }
}