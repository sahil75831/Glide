package com.example.glide.workspace.community.presentation.screens.current_community

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.glide.workspace.core.components.TopBarWithAvatar
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.glide.workspace.community.presentation.screens.roles.CreateRole

import com.example.glide.workspace.core.components.BottomSheet
import com.example.glide.workspace.core.components.BottomSheetContent


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrentCommunityHomeScreen(
    parentNavController: NavController,
    currentCommunityId: String = "",
    modifier: Modifier = Modifier
) {
    // state for bottom sheet
    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false
    )
    var showSheet by remember { mutableStateOf(false) }

    // nested navigation inside green area
    val childNavController = rememberNavController()

    Box(modifier = Modifier.fillMaxSize()) {

        Column(modifier = Modifier.fillMaxSize().background(Color.Transparent)) {

            TopBarWithAvatar(
                onBackClick = {
                    val popped = childNavController.popBackStack()
                    if (!popped) parentNavController.popBackStack()
                },
                onGridClick = { showSheet = true }
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent)
            ) {
                ChildNavHost(childNavController, currentCommunityId)
            }
        }
    }

    // BOTTOM SHEET
    if (showSheet) {
        ModalBottomSheet(

            sheetState = bottomSheetState,
            onDismissRequest = { showSheet = false },
            containerColor = MaterialTheme.colorScheme.onPrimary
        ) {
            BottomSheet{ BottomSheetContent() }
        }
    }
}





@Composable
fun ChildNavHost(navController: NavHostController, currentCommunityId: String) {
    NavHost(
        navController = navController,
        startDestination = "roles"
    ) {

        composable("roles") {
            CreateRole(currentCommunityId)
        }

        composable("screen2") {
            Screen2(
                onNext = { navController.navigate("screen3") }
            )
        }

        composable("screen3") {
            Screen3(onNext = {})
        }
    }
}




@Composable
fun Screen2(onNext: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Screen 2")
        Button(onClick = onNext) {
            Text("Go to Screen 3")
        }
    }
}



@Composable
fun Screen3(onNext: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Screen 3")
        Button(onClick = onNext) {
            Text("Go to Screen 3")
        }
    }
}


