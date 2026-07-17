package com.example.calculadoratalleryes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Calculadora()
        }
    }
}

@Composable
fun Calculadora() {
    var numero1 by remember { mutableStateOf("") }
    var numero2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "CALCULADORA", fontSize = 28.sp)

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "Num 1")
        TextField(
            value = numero1,
            onValueChange = { numero1 = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Num 2")
        TextField(
            value = numero2,
            onValueChange = { numero2 = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Resultado")
        TextField(
            value = resultado,
            onValueChange = {},
            readOnly = true
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = {
            val n1 = numero1.toDoubleOrNull() ?: 0.0
            val n2 = numero2.toDoubleOrNull() ?: 0.0
            resultado = (n1 + n2).toString()
        }) {
            Text(text = "SUMAR")
        }
    }
}