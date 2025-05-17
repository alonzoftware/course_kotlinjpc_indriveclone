package net.alonzochoque.indriveclone.presentation.screens.auth.register.components

import android.util.Log
import android.widget.Toast
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import net.alonzochoque.indriveclone.R
import net.alonzochoque.indriveclone.presentation.components.DefaultButton
import net.alonzochoque.indriveclone.presentation.components.DefaultOutlinedTextField
import net.alonzochoque.indriveclone.presentation.screens.auth.register.RegisterViewModel

@Composable
fun RegisterContent(
    navHostController: NavHostController,
    paddingValues: PaddingValues,
    vm: RegisterViewModel = hiltViewModel()
) {
    val state = vm.state
    val context = LocalContext.current
    LaunchedEffect(key1 = vm.errorMessageSwitchTrigger) {
        Log.d("RegisterContent", "Error: ${vm.errorMessage}")
        if(vm.errorMessage.isNotEmpty()){
            Toast.makeText(context,vm.errorMessage, Toast.LENGTH_SHORT).show()
        }
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
                    value = state.name,
                    label = "Nombre",
                    icon = Icons.Outlined.Person,
                    onValueChange = {
                        vm.onNameInput(it)
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
                DefaultOutlinedTextField(
                    modifier = Modifier,
                    value = state.lastname,
                    label = "Apellido",
                    icon = Icons.Outlined.Person,
                    onValueChange = {
                        vm.onLastnameInput(it)
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
                DefaultOutlinedTextField(
                    modifier = Modifier,
                    value = state.email,
                    label = "Email",
                    icon = Icons.Outlined.Email,
                    keyboardType = KeyboardType.Email,
                    onValueChange = {
                        vm.onEmailInput(it)
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
                DefaultOutlinedTextField(
                    modifier = Modifier,
                    value = state.phone,
                    label = "Telefono",
                    icon = Icons.Outlined.Phone,
                    keyboardType = KeyboardType.Number,
                    onValueChange = {
                        vm.onPhoneInput(it)
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
                DefaultOutlinedTextField(
                    modifier = Modifier,
                    value = state.password,
                    label = "Password",
                    icon = Icons.Outlined.Lock,
                    hideText = true,
                    onValueChange = {
                        vm.onPasswordInput(it)
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
                DefaultOutlinedTextField(
                    modifier = Modifier,
                    value = state.confirmPassword,
                    label = "Confirmar Password",
                    icon = Icons.Outlined.Lock,
                    hideText = true,
                    onValueChange = {
                        vm.onConfirmPasswordInput(it)
                    }
                )
                Spacer(modifier = Modifier.weight(1f))
                DefaultButton(
                    modifier = Modifier,
                    text = "Crear Usuario",
                    onClick = { vm.register() }
                )
                Spacer(modifier = Modifier.height(10.dp))
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

