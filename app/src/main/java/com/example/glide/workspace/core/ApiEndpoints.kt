package com.example.glide.workspace.core

object ApiEndpoints {
    // For emulator
    const val BASE_URL: String = "http://10.0.2.2:3000/"
    // For physical device testing - use your computer's IP
//    const val BASE_URL: String = "http://192.168.1.5:3000/"

    const val SIGN_UP_USER: String = "/api/auth/user-create"
    const val VERIFY_OTP: String = "/api/auth/user/verify-otp"
    const val LOGIN_USER: String = "/api/auth/user-login"
    const val CREATE_COMMUNITY: String = "/api/community/create-community"
    const val FETCH_USER_COMMUNITY: String = "/api/community/user/list-community"
    const val JOIN_COMMUNITY: String = "/api/community/join-new-user"
    const val CREATE_CURRENT_COMMUNITY_ROLE: String = "/permission/create-role"
    const val FETCH_ALL_PERMISSIONS: String = "/permission/get-all-permissions"

}