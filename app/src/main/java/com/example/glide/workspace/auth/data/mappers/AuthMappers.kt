package com.example.glide.workspace.auth.data.mappers

import com.example.glide.workspace.auth.data.remote.dto.SignUpRequestDTO
import com.example.glide.workspace.auth.data.remote.dto.SignUpResponseDTO
import com.example.glide.workspace.auth.data.remote.dto.VerifyOtpRequestDTO
import com.example.glide.workspace.auth.data.remote.dto.VerifyOtpResponseDTO
import com.example.glide.workspace.auth.domain.models.SignUpResult
import com.example.glide.workspace.auth.domain.models.User
import com.example.glide.workspace.auth.domain.models.VerifyOtp
import com.example.glide.workspace.auth.domain.models.VerifyOtpResult

// DATA LAYER TO DOMAIN LAYER
fun SignUpRequestDTO.toUser(): User {
    return User(
        name = name,
        phone = phone,
        email = email,
        password = password,
        governmentId = governmentId,
        governmentIdType = governmentIdType,
        age = age,
        gender = gender,
        address = address
    )
}

// DATA  LAYER TO DOMAIN LAYER
fun SignUpResponseDTO.toSignUpResult(): SignUpResult {
    return SignUpResult(
        success = success,
        message = message
    )
}

// DOMAIN LAYER TO DATA LAYER
fun User.toSignUpRequestDTO(): SignUpRequestDTO {
    return SignUpRequestDTO(
        name = name, // ← Left: DTO property | Right: User property
        phone = phone, // DTO's 'phone' gets user's phone
        email = email,
        password = password,
        governmentId = governmentId,
        governmentIdType = governmentIdType,
        age = age,
        gender = gender,
        address = address
    )
}

// DOMAIN LAYER TO DATA LAYER
fun VerifyOtp.toVerifyOtpDTO(): VerifyOtpRequestDTO {
    return VerifyOtpRequestDTO(
        phone = phone,
        phoneOtp = phoneOtp,
        email = email,
        emailOtp = emailOtp
    )
}

// DATA LAYER TO DOMAIN LAYER
fun VerifyOtpResponseDTO.toVerifyOtpResult(): VerifyOtpResult {
    return VerifyOtpResult(
        success = success,
        message = message
    )
}