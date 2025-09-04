package com.example.app

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
    var isToggled by rememberSaveable { mutableStateOf(false) }

    // Lista de ícones e legendas
    val itens = listOf(
        Pair(R.drawable.pix_100, "Área Pix e Transferir"),
        Pair(R.drawable.dinheiro_100, "Pegar Emprestado"),
        Pair(R.drawable.dolar_americano_96, "Converter Limite"),
        Pair(R.drawable.caixa_100, "Caixinha Turbo"),
        Pair(R.drawable.iphone_100, "Recarga Celular"),
        Pair(R.drawable.duracao_financa_100, "Caixinhas Investir")
    )

    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxSize()) {
        // Barra superior
        Surface(
            tonalElevation = 3.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .statusBarsPadding(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Ícone da esquerda
                    IconButton(onClick = {}, modifier = Modifier.size(40.dp)) {
                        Icon(imageVector = Icons.Filled.Person, contentDescription = "Esquerda")
                    }

                    // Ícones da direita
                    Row {
                        IconButton(onClick = {}, modifier = Modifier.size(40.dp)) {
                            Icon(imageVector = Icons.Filled.Visibility, contentDescription = "Direita 1")
                        }
                        IconButton(onClick = {}, modifier = Modifier.size(40.dp)) {
                            Icon(imageVector = Icons.Filled.Help, contentDescription = "Direita 2")
                        }
                        IconButton(onClick = {}, modifier = Modifier.size(40.dp)) {
                            Icon(imageVector = Icons.Filled.PrivacyTip, contentDescription = "Direita 3")
                        }
                    }
                }

                // Card azul central
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .statusBarsPadding(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        color = Color(0xFF1E88E5),
                        contentColor = Color.White,
                        shadowElevation = 4.dp,
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                imageVector = Icons.Filled.GolfCourse,
                                contentDescription = "Golf",
                                modifier = Modifier.size(40.dp)
                            )
                            Text(
                                text = "Confira seu score do mês",
                                style = MaterialTheme.typography.headlineSmall,
                                fontStyle = FontStyle.Italic,
                                fontSize = 24.sp,
                                modifier = Modifier.padding(start = 16.dp)
                            )
                        }
                    }
                }
            }
        }

        // Linha de saldo
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Top
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Saldo em conta!", style = MaterialTheme.typography.headlineMedium)
                Text(
                    text = "R$ 9999",
                    fontSize = 20.sp,
                    color = Color.Green,
                    style = MaterialTheme.typography.headlineMedium
                )
            }
            Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.End) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos, contentDescription = "seta")
            }
        }

//        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp), thickness = 2.dp, color = Color.Gray)

        // Linha rolável de ícones com legendas
        Row(
            modifier = Modifier
                .horizontalScroll(scrollState)
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            itens.forEach { (icone, legenda) ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Surface(
                        modifier = Modifier.size(60.dp),
                        shape = CircleShape,
                        color = Color.White
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Image(
                                painter = painterResource(id = icone),
                                contentDescription = legenda,
                                modifier = Modifier.size(32.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = legenda,
                        fontSize = 12.sp,
                        color = Color.Black,
                        maxLines = 2
                    )
                }
            }
        }

        // Card azul central
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .statusBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                color = Color(color = 0xFFCAD5E2),
                contentColor = Color.White,
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Image(
                            painter = painterResource(id  = R.drawable.pagar_100),
                            contentDescription = "a",
                            modifier = Modifier.size(32.dp)
                        )
                    }
                    Column(){
                        Row(){
                            Text(
                                text = "Dinheiro adicional",
                                style = MaterialTheme.typography.headlineSmall,
                                fontStyle = FontStyle.Italic,
                                fontSize = 24.sp,
                                modifier = Modifier.padding(start = 16.dp),
                                color = Color.Black
                            )
                        }
                        Row(){
                            Text(
                                text = "Opções de crédito disponível",
                                style = MaterialTheme.typography.headlineSmall,
                                fontSize = 19.sp,
                                modifier = Modifier.padding(start = 16.dp),
                                color = Color.Black
                            )
                        }
                    }
                }
            }
        }

        val cards = listOf(
            Pair(R.drawable.pagar_100, "Dinheiro adicional"),
            Pair(R.drawable.pix_100, "Área Pix e Transferir"),
            Pair(R.drawable.dinheiro_100, "Pegar Emprestado"),
            Pair(R.drawable.dolar_americano_96, "Converter Limite")
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp) // espaço entre os cards
        ) {
            items(cards.size) { index ->
                val (icone, titulo) = cards[index]
                Surface(
                    color = Color(0xFFCAD5E2),
                    contentColor = Color.White,
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .width(250.dp) // largura fixa para cada card
                        .height(100.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = icone),
                            contentDescription = titulo,
                            modifier = Modifier.size(32.dp)
                        )
                        Column(
                            modifier = Modifier.padding(start = 16.dp),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = titulo,
                                style = MaterialTheme.typography.headlineSmall,
                                fontStyle = FontStyle.Italic,
                                fontSize = 20.sp,
                                color = Color.Black
                            )
                            Text(
                                text = "Opções de crédito disponível",
                                style = MaterialTheme.typography.bodyMedium,
                                fontSize = 16.sp,
                                color = Color.Black
                            )
                        }
                    }
                }
            }
        }

    }
}
