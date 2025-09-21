 
=== auth/data/models/ApiResponse.kt ===
package com.example.glide.auth.data.models

data class ApiResponse(
    val success: Boolean,
    val message: String,
    val error: String? = null,
    val data: Map<String, Any>? = null
)
 
 
=== auth/data/models/Community.kt ===
package com.example.glide.auth.data.models

data class Community(
    val communityName:String = "",
    val creatorId:String = "",
)
 
 
=== auth/data/models/User.kt ===
package com.example.glide.auth.data.models

data class User(
    val name: String = "",
    val email: String = "",
    val phone: String = "",
    val communityName: String? = null,
    val roleId: String? = null,
    val accessId: String? = null
)
 
 
=== auth/data/remote/AuthService.kt ===
package com.example.glide.auth.data.remote

import com.example.glide.auth.data.models.ApiResponse
import com.example.glide.auth.data.models.User
import com.example.glide.auth.utils.EndPoints
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST(EndPoints.Community.CREATE)
    suspend fun createCommunity(@Body user: User): ApiResponse

    @POST(EndPoints.Auth.VERIFY_OTP)
    suspend fun verifyOtp(@Body body: Map<String, String>): ApiResponse
} 
 
=== auth/data/repository/AuthRepositoryImpl.kt ===
package com.example.glide.auth.data.repository

import com.example.glide.auth.data.models.User
import com.example.glide.auth.data.remote.AuthService
import com.example.glide.auth.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api: AuthService
) : AuthRepository {
    override suspend fun createCommunity(user: User): Result<String> {
        return try {
            val response = api.createCommunity(user)
            if (response.success) {
                Result.success(response.message)
            } else {
                Result.failure(Exception(response.error ?: "Unknown error"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun verifyOtp(phone: String, otp: String): Result<String> {
        val body = mapOf("phone" to phone, "otp" to otp)
        return try {
            val response = api.verifyOtp(body)
            if (response.success) {
                Result.success(response.message)
            } else {
                Result.failure(Exception(response.error ?: "Unknown error"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
} 
 
=== auth/di/NetworkModule.kt ===
package com.example.glide.auth.di

import com.example.glide.auth.data.remote.AuthService
import com.example.glide.auth.utils.EndPoints
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit():Retrofit {
        return Retrofit.Builder()
            .baseUrl(EndPoints.getBaseUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideAuthService(retrofit: Retrofit):AuthService {
        return retrofit.create(AuthService::class.java)
    }
} 
 
=== auth/di/RepositoryModule.kt ===
package com.example.glide.auth.di

import com.example.glide.auth.data.repository.AuthRepositoryImpl
import com.example.glide.auth.domain.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindAuthRepository(impl: AuthRepositoryImpl):AuthRepository
} 
 
=== auth/di/UseCaseModule.kt ===
package com.example.glide.auth.di

import com.example.glide.auth.domain.repository.AuthRepository
import com.example.glide.auth.domain.usecases.CreateCommunityUseCase
import com.example.glide.auth.domain.usecases.VerifyOtpUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideCreateCommunityUseCase(authRepository: AuthRepository): CreateCommunityUseCase {
        return CreateCommunityUseCase(authRepository)
    }

    @Provides
    @Singleton
    fun provideVerifyOtpUseCase(authRepository: AuthRepository): VerifyOtpUseCase {
        return VerifyOtpUseCase(authRepository)
    }
} 
 
=== auth/domain/repository/AuthRepository.kt ===
package com.example.glide.auth.domain.repository

import com.example.glide.auth.data.models.User

interface AuthRepository {
    suspend fun createCommunity(user: User): Result<String>
    suspend fun verifyOtp(phone: String, otp: String): Result<String>
} 
 
=== auth/domain/usecases/CreateCommunityUseCase.kt ===
package com.example.glide.auth.domain.usecases

import com.example.glide.auth.data.models.User
import com.example.glide.auth.domain.repository.AuthRepository
import javax.inject.Inject

class CreateCommunityUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(user: User):Result<String> {
        // De-structure the user object
        val ( name, email, phone, communityName, roleId, accessId) = user
        // Debug logging: Print all de structured fields
        println("name, email, phone, communityName, roleId, accessId: $name, $email, $phone, $communityName, $roleId, $accessId")

        // Business rule validations using destructured variables
        if(name.isBlank()) return Result.failure(exception = Exception("User name can not be black"))
        if(email.isBlank() || !email.contains("@")) return Result.failure(exception = Exception("Invalid user email"))
        if(phone.isBlank()) return Result.failure(exception = Exception("User phone number can not be blank"))
        if(communityName.isNullOrBlank()) return Result.failure(exception = Exception("Community name can not be black"))

        // Optional: Log after validation passes
        println("Validation passed for user: $name (email: $email)")

        return authRepository.createCommunity(user)
    }
} 
 
=== auth/domain/usecases/VerifyOtpUseCase.kt ===
package com.example.glide.auth.domain.usecases

import com.example.glide.auth.domain.repository.AuthRepository
import javax.inject.Inject

class VerifyOtpUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(phone: String, otp: String): Result<String> {
        if (phone.isBlank()) return Result.failure(Exception("Phone number cannot be blank"))
        if (otp.isBlank() || otp.length != 6) return Result.failure(Exception("OTP must be 6 digits"))
        return authRepository.verifyOtp(phone, otp)
    }
} 
 
=== auth/navigation/AppNavigation.kt ===
package com.example.glide.auth.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.glide.auth.presentation.view.CreateCommunityScreen
import com.example.glide.auth.presentation.view.HomeScreen
import com.example.glide.auth.presentation.view.OtpScreen


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") {
            WelcomeScreen(navController)
        }
        composable("create") {
            CreateCommunityScreen(navController)
        }
        composable("otp/{phone}") { backStackEntry ->
            val phone = backStackEntry.arguments?.getString("phone") ?: ""
            OtpScreen(phone, navController)
        }
        composable("home") {
            HomeScreen()
        }
    }
}

@Composable
fun WelcomeScreen(navController: NavHostController) {
    androidx.compose.foundation.layout.Column {
        androidx.compose.material3.Button(onClick = { navController.navigate("create") }) {
            androidx.compose.material3.Text("Start Creating Community")
        }
    }
} 
 
=== auth/presentation/view/CreateCommunity.kt ===
package com.example.glide.auth.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.glide.auth.data.models.User
import com.example.glide.auth.presentation.viewmodel.AuthViewModel

@Composable
fun CreateCommunityScreen(
    navController: NavController,
    viewModel: AuthViewModel = hiltViewModel()
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var communityName by remember { mutableStateOf("") }

    Column {
        TextField(value = name, onValueChange = { name = it }, label = { Text("Name") })
        TextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        TextField(value = phone, onValueChange = { phone = it }, label = { Text("Phone") })
        TextField(value = communityName, onValueChange = { communityName = it }, label = { Text("Community Name") })
        Button(onClick = {
            viewModel.createCommunity(User(name, email, phone, communityName))
        }) {
            Text("Create")
        }
        val createState by viewModel.createCommunityState.collectAsState()
        createState?.let { result ->
            if (result.isFailure) {
                Text("Error: ${result.exceptionOrNull()?.message ?: "Unknown error"}")
            }
        }
    }

    val createState by viewModel.createCommunityState.collectAsState()
    LaunchedEffect(createState) {
        createState?.let { result ->
            if (result.isSuccess) {
                navController.navigate("otp/$phone")
                viewModel.resetCreateState()
            }
        }
    }
} 
 
=== auth/presentation/view/HomeScreen.kt ===
package com.example.glide.auth.presentation.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen() {
    Text("Welcome to the Home Screen!")
} 
 
=== auth/presentation/view/OtpScreen.kt ===
package com.example.glide.auth.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.glide.auth.presentation.viewmodel.AuthViewModel

@Composable
fun OtpScreen(
    phone: String,
    navController: NavController,
    viewModel: AuthViewModel = hiltViewModel()
) {
    var otp by remember { mutableStateOf("") }

    Column {
        Text("Enter OTP sent to $phone")
        TextField(value = otp, onValueChange = { otp = it }, label = { Text("OTP") })
        Button(onClick = {
            viewModel.verifyOtp(phone, otp)
        }) {
            Text("Verify")
        }
        val verifyState by viewModel.verifyOtpState.collectAsState()
        verifyState?.let { result ->
            if (result.isFailure) {
                Text("Error: ${result.exceptionOrNull()?.message ?: "Unknown error"}")
            }
        }
    }

    val verifyState by viewModel.verifyOtpState.collectAsState()
    LaunchedEffect(verifyState) {
        verifyState?.let { result ->
            if (result.isSuccess) {
                navController.navigate("home")
                viewModel.resetVerifyState()
            }
        }
    }
} 
 
=== auth/presentation/viewmodel/AuthViewModel.kt ===
package com.example.glide.auth.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.glide.auth.data.models.User
import com.example.glide.auth.domain.usecases.CreateCommunityUseCase
import com.example.glide.auth.domain.usecases.VerifyOtpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val createCommunityUseCase: CreateCommunityUseCase,
    private val verifyOtpUseCase: VerifyOtpUseCase
) : ViewModel() {
    private val _createCommunityState = MutableStateFlow<Result<String>?>(null)
    val createCommunityState: StateFlow<Result<String>?> = _createCommunityState

    private val _verifyOtpState = MutableStateFlow<Result<String>?>(null)
    val verifyOtpState: StateFlow<Result<String>?> = _verifyOtpState

    fun createCommunity(user: User) {
        viewModelScope.launch {
            _createCommunityState.value = createCommunityUseCase(user)
        }
    }

    fun verifyOtp(phone: String, otp: String) {
        viewModelScope.launch {
            _verifyOtpState.value = verifyOtpUseCase(phone, otp)
        }
    }

    fun resetCreateState() {
        _createCommunityState.value = null
    }

    fun resetVerifyState() {
        _verifyOtpState.value = null
    }
} 
 
=== auth/utils/EndPoints.kt ===
package com.example.glide.auth.utils

object EndPoints {
    private const val BASE_URL = "http://10.0.2.2:5000/" // Emulator localhost

    object Auth {
        const val VERIFY_OTP = "api/auth/verify-otp"
    }

    object Community {
        const val CREATE = "api/community/create"
        const val JOIN = "api/community/join"
    }

    fun getBaseUrl(): String = BASE_URL
} 
