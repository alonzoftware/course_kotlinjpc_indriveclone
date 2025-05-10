package net.alonzochoque.indriveclone.presentation.screens.auth.login

import android.R.attr.label
import android.R.attr.padding
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.alonzochoque.indriveclone.R

@Composable
fun LoginScreen() {
    var email by remember {
        mutableStateOf(value = "")
    }
    var password by remember {
        mutableStateOf(value = "")
    }
    Scaffold(
        contentWindowInsets = WindowInsets.navigationBars
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(color = 0xFFAC9E1F), Color(color = 0xFFFFE91F))
                    )
                )
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Login",
                    color = Color.White,
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .rotate(degrees = 90f)
                        .padding(top = 10.dp)
                )
                Spacer(modifier = Modifier.height(150.dp))
                Text(
                    text = "Register",
                    color = Color.White,
                    fontSize = 27.sp,
                    modifier = Modifier
                        .rotate(degrees = 90f)
                        .padding(top = 30.dp)
                )
                Spacer(modifier = Modifier.height(200.dp))
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 60.dp, bottom = 35.dp)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(Color(color = 0xFFFEFA1E), Color(color = 0xFFF3CE00))
                        ),
                        shape = RoundedCornerShape(
                            topStart = 35.dp,
                            bottomStart = 35.dp
                        )

                    )
            ) {
                Column(
                    modifier = Modifier.statusBarsPadding()
                ) {
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Welcome",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "back...",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Image(
                        modifier = Modifier.size(150.dp),
                        painter = painterResource(id = R.drawable.car_white),
                        contentDescription = ""
                    )
                    Text(
                        text = "Log in",
                        color = Color.White,
                        fontSize = 27.sp,
                        fontWeight = FontWeight.Bold
                    )

                    TextField(
                        value = email,
                        onValueChange = {
                            email = it
                        },
                        label = {
                            Text(text = "Email")
                        }
                    )
                    TextField(
                        value = password,
                        onValueChange = {
                            password = it
                        },
                        label = {
                            Text(text = "Password")
                        }
                    )
                    Button(
                        onClick = {

                        }
                    ) {
                        Text(text = "Iniciar Sesion")
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Spacer(
                            modifier = Modifier
                                .width(25.dp)
                                .height(1.dp)
                                .background(Color.White)
                        )
                        Text(
                            text = "O",
                            color = Color.White, fontSize = 17.sp
                        )
                        Spacer(
                            modifier = Modifier
                                .width(25.dp)
                                .height(1.dp)
                                .background(Color.White)
                        )

                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "No tienes cuenta?",
                            color = Color.White,
                            fontSize = 17.sp
                        )
                        Text(
                            text = "Registrate",
                            color = Color.White,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold
                        )


                    }
                }
            }
        }

    }
}