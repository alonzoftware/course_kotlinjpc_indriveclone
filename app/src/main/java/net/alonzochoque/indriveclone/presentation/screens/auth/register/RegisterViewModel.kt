package net.alonzochoque.indriveclone.presentation.screens.auth.register

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(): ViewModel() {
    var state by mutableStateOf(RegisterState())
        private set

    var errorMessage by mutableStateOf("")
    var errorMessageSwitchTrigger by mutableStateOf(false)

    fun onNameInput(name: String) {
        state = state.copy(name = name)
    }

    fun onLastnameInput(lastname: String) {
        state = state.copy(lastname = lastname)
    }

    fun onEmailInput(email: String) {
        state = state.copy(email = email)
    }

    fun onPhoneInput(phone: String) {
        state = state.copy(phone = phone)
    }

    fun onPasswordInput(password: String) {
        state = state.copy(password = password)
    }

    fun onConfirmPasswordInput(confirmPassword: String) {
        state = state.copy(confirmPassword = confirmPassword)
    }

    fun register() {
        errorMessageSwitchTrigger = !errorMessageSwitchTrigger
        if (isValidForm()) {
            Log.d("RegisterViewModel", "Name: ${state.name}")
            Log.d("RegisterViewModel", "Lastname: ${state.lastname}")
            Log.d("RegisterViewModel", "Email: ${state.email}")
            Log.d("RegisterViewModel", "Phone: ${state.phone}")
            Log.d("RegisterViewModel", "Password: ${state.password}")
        }
    }

    fun isValidForm(): Boolean {
        errorMessage = ""
        if (state.name.isEmpty()) {
            errorMessage = "Ingresa el nombre"
            return false
        } else if (state.lastname.isEmpty()) {
            errorMessage = "Ingresa el apellido"
            return false
        } else if (state.email.isEmpty()) {
            errorMessage = "Ingresa el Email"
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = "Email no válido"
            return false
        } else if (state.phone.isEmpty()) {
            errorMessage = "Ingresa el teléfono"
            return false
        } else if (state.password.isEmpty()) {
            errorMessage = "Ingresa el Password"
            return false
        } else if (state.password.length < 6) {
            errorMessage = "El Password debe tener por lo menos 6 caracteres"
            return false
        } else if (state.confirmPassword.isEmpty()) {
            errorMessage = "Confirma el Password"
            return false
        } else if (state.password != state.confirmPassword) {
            errorMessage = "Los Passwords no coinciden"
            return false
        }
        return true
    }
}

