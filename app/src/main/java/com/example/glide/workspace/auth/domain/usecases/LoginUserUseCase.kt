package com.example.glide.workspace.auth.domain.usecases

import com.example.glide.workspace.auth.domain.models.LoginUser
import com.example.glide.workspace.auth.domain.models.LoginUserResult
import com.example.glide.workspace.auth.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUserUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(loginUserData: LoginUser): LoginUserResult {
        // DeStructure login data properties
        val (email, password) = loginUserData

        // validation logic
        if(email.isBlank()) return LoginUserResult(success = false, message = "Email is required!")
        if(password.isBlank()) return LoginUserResult(success = false, message = "Password is required")

        return try {
            authRepository.loginUser(loginUserData)
        }catch (e: Exception){
            LoginUserResult(success = false, message = "Unexpected error: ${e.localizedMessage ?: "Unknown"}")
        }
    }
}