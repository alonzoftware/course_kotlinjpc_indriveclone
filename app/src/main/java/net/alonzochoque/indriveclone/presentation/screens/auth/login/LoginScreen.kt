package net.alonzochoque.indriveclone.presentation.screens.auth.login

import android.R.attr.label
import android.R.attr.padding
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import net.alonzochoque.indriveclone.R
import net.alonzochoque.indriveclone.presentation.components.DefaultTextField
import net.alonzochoque.indriveclone.presentation.navigation.screen.auth.AuthScreen

@Composable
fun LoginScreen(navHostController: NavHostController) {
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
                        .clickable { navHostController.navigate(route = AuthScreen.Register.route) }
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
                    modifier = Modifier
                        .statusBarsPadding()
                        .padding(start = 25.dp)
                ) {
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Welcome",
                        color = Color.White,
                        fontSize = 35.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "back...",
                        color = Color.White,
                        fontSize = 35.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 15.dp)
                    ) {
                        Image(
                            modifier = Modifier
                                .size(150.dp)
                                .align(Alignment.CenterEnd),
                            painter = painterResource(id = R.drawable.car_white),
                            contentDescription = ""
                        )
                    }
                    Text(
                        text = "Log in",
                        color = Color.White,
                        fontSize = 27.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(40.dp))
//                    TextField(
//                        value = email,
//                        onValueChange = {
//                            email = it
//                        },
//                        label = {
//                            Text(text = "Email")
//                        }
//                    )
                    DefaultTextField(
                        modifier = Modifier,
                        value = email,
                        label = "Email",
                        icon = Icons.Outlined.Email,
                        keyboardType = KeyboardType.Email,
                        onValueChange = {
                            email = it
                        }
                    )
                    Spacer(modifier = Modifier.height(15.dp))
//                    TextField(
//                        value = password,
//                        onValueChange = {
//                            password = it
//                        },
//                        label = {
//                            Text(text = "Password")
//                        }
//                    )
                    DefaultTextField(
                        modifier = Modifier,
                        value = password,
                        label = "Password",
                        icon = Icons.Outlined.Lock,
                        hideText = true,
                        onValueChange = {
                            password = it
                        }
                    )
                    Spacer(modifier = Modifier.weight(1f))

                    Box(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Button(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .width(250.dp)
                                .height(55.dp),
                            colors = ButtonDefaults.buttonColors(Color.Black),
                            onClick = {

                            }
                        ) {
                            Text(text = "LOGIN", fontSize = 18.sp, color = Color.White)
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(
                            modifier = Modifier
                                .width(25.dp)
                                .height(1.dp)
                                .background(Color.White)
                        )
                        Text(
                            modifier = Modifier.padding(horizontal = 10.dp),
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
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "Registrate",
                            color = Color.White,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.height(50.dp))
                }
            }
        }

    }
}