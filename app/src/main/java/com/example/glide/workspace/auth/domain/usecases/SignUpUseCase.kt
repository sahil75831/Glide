package com.example.glide.workspace.auth.domain.usecases

import com.example.glide.workspace.auth.domain.models.SignUpResult
import com.example.glide.workspace.auth.domain.models.User
import com.example.glide.workspace.auth.domain.repository.AuthRepository

class SignUpUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(user: User): SignUpResult {
        // DeStructure user properties
        val (name, phone, email, password, governmentId, governmentIdType, age, gender, address) = user

        // 1 Validate inputs
        if (name.isBlank()) return SignUpResult(false, "Name cannot be empty.")
        if (governmentIdType.isBlank()) return SignUpResult(false, "GovernmentId Type cannot be empty.")
        if (gender.isBlank()) return SignUpResult(false, "Gender cannot be empty.")
        if (address.isBlank()) return SignUpResult(false, "Address cannot be empty.")
        if (email.isBlank() || !isValidEmail(email)) return SignUpResult(false, "Invalid email format.")
        if (phone.isBlank() || !isValidPhone(phone)) return SignUpResult(false, "Invalid phone number.")
        if (password.length < 8) return SignUpResult(false, "Password must be at least 8 characters long.")
        if (governmentId.isBlank()) return SignUpResult(false, "Government ID is required.")
        if (age < 18) return SignUpResult(false, "User must be 18 or older.")

        // 2 Delegate to repository
        return try {
            authRepository.signUp(user)
        } catch (e: Exception) {
            SignUpResult(false, "Unexpected error: ${e.localizedMessage ?: "Unknown"}")
        }
    }

    // ---------------------------
    // 🔧 Validation Helpers
    // ---------------------------
    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidPhone(phone: String): Boolean {
        return phone.matches(Regex("^[6-9][0-9]{9}$"))
    }
}
