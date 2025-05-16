package net.alonzochoque.indriveclone.presentation.screens.auth.register.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Text
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import net.alonzochoque.indriveclone.R
import net.alonzochoque.indriveclone.presentation.components.DefaultButton
import net.alonzochoque.indriveclone.presentation.components.DefaultOutlinedTextField

@Composable
fun RegisterContent(navHostController: NavHostController, paddingValues: PaddingValues) {

    var name by remember {
        mutableStateOf(value = "")
    }
    var lastname by remember {
        mutableStateOf(value = "")
    }
    var email by remember {
        mutableStateOf(value = "")
    }
    var phone by remember {
        mutableStateOf(value = "")
    }
    var password by remember {
        mutableStateOf(value = "")
    }
    var confirmPassword by remember {
        mutableStateOf(value = "")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(color = 0xFFAC9E1F), Color(color = 0xFFFFE91F))
                )
            )
            .padding(paddingValues)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Login",
                color = Color.White,
                fontSize = 27.sp,
                modifier = Modifier
                    .rotate(degrees = 90f)
                    .padding(top = 10.dp)
//                        .clickable { navHostController.navigate(route = AuthScreen.Login.route) }
                    .clickable { navHostController.popBackStack() }
            )
            Spacer(modifier = Modifier.height(150.dp))
            Text(
                text = "Register",
                color = Color.White,
                fontSize = 33.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .rotate(degrees = 90f)
                    .padding(top = 60.dp)
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
                    .statusBarsPadding(),

//                        .padding(start = 25.dp)
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(20.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 15.dp)
                ) {
                    Image(
                        modifier = Modifier
                            .size(100.dp)
                            .align(Alignment.Center),
                        painter = painterResource(id = R.drawable.trip),
                        contentDescription = ""
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
                DefaultOutlinedTextField(
                    modifier = Modifier,
                    value = name,
                    label = "Nombre",
                    icon = Icons.Outlined.Person,
                    onValueChange = {
                        name = it
                    }
                )
                Spacer(modifier = Modifier.height(15.dp))
                DefaultOutlinedTextField(
                    modifier = Modifier,
                    value = lastname,
                    label = "Apellido",
                    icon = Icons.Outlined.Person,
                    onValueChange = {
                        lastname = it
                    }
                )
                Spacer(modifier = Modifier.height(15.dp))
                DefaultOutlinedTextField(
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
                DefaultOutlinedTextField(
                    modifier = Modifier,
                    value = phone,
                    label = "Telefono",
                    icon = Icons.Outlined.Phone,
                    keyboardType = KeyboardType.Number,
                    onValueChange = {
                        email = it
                    }
                )
                Spacer(modifier = Modifier.height(15.dp))
                DefaultOutlinedTextField(
                    modifier = Modifier,
                    value = password,
                    label = "Password",
                    icon = Icons.Outlined.Lock,
                    hideText = true,
                    onValueChange = {
                        password = it
                    }
                )
                Spacer(modifier = Modifier.height(15.dp))
                DefaultOutlinedTextField(
                    modifier = Modifier,
                    value = confirmPassword,
                    label = "Confirmar Password",
                    icon = Icons.Outlined.Lock,
                    hideText = true,
                    onValueChange = {
                        confirmPassword = it
                    }
                )
                Spacer(modifier = Modifier.weight(1f))
                DefaultButton(
                    modifier = Modifier,
                    text = "Crear Usuario",
                    onClick = {/*TODO*/ }
                )
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
                        text = "Ya tienes cuenta?",
                        color = Color.White,
                        fontSize = 17.sp
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "Inicia Sesion",
                        color = Color.White,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
//                                .clickable { navHostController.navigate(route = AuthScreen.Login.route) }
                            .clickable { navHostController.popBackStack() }
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }


}