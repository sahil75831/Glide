package com.example.glide.workspace.community.presentation.screens.join_explore_community


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.glide.workspace.community.domain.models.CommunityMembership
import com.example.glide.workspace.community.presentation.viewmodels.JoinExploreCommunityViewModel
import com.example.glide.workspace.core.components.ExploreCommunityCarousel
import com.example.glide.workspace.core.components.InputFieldVariant
import com.example.glide.workspace.core.components.ThemedPrimaryButton
import com.example.glide.workspace.core.components.ThemedPrimaryInputField

@Composable
fun JoinExploreCommunity(
    navController:  NavHostController ,
    modifier: Modifier = Modifier,
    viewModel: JoinExploreCommunityViewModel = hiltViewModel()
) {
    val ownerCommunities = viewModel.ownerCommunities
    val memberCommunities = viewModel.memberCommunities
    val isLoading = viewModel.isLoading
    val errorMessage = viewModel.errorMessage

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(modifier = modifier.fillMaxWidth().weight(0.71f)) {
            Column(modifier = modifier.fillMaxWidth().weight(1f)) {
                Text(
                    text = "Where souls connect, \n & \n vibes resonate",
                    modifier = modifier
                        .fillMaxWidth().padding(top = 18.dp),
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.primary,
                    lineHeight = 36.sp,
                )
            }
            // joining form
            Column(modifier = modifier.fillMaxWidth().weight(1f)) {
                Row(modifier = modifier.padding(8.dp)) {
                    ThemedPrimaryInputField(
                        variant = InputFieldVariant.Filled,
                        label = "Invitee code",
                        placeHolder = "e.g invitee:07e09ecb-05*****:Trusty",
                        value = viewModel.inviteeCode,
                        onValueChange = { viewModel.inviteeCode = it },
                        supportingText = ""
                    )
                }

                Row(modifier = modifier.padding(8.dp)) {
                    ThemedPrimaryButton(
                        onClick = { viewModel.joinCommunity() },
                        enabled = viewModel.inviteeCode.isNotEmpty() && !isLoading,
                        isLoading = isLoading,
                        text = "Join"
                    )
                }
            }
        }

        Column(modifier = modifier.fillMaxWidth().weight(1f)) {
            CommunitySection(navController, modifier, ownerCommunities)
            Spacer(modifier = Modifier.height(24.dp))
            CommunitySection(navController, modifier, memberCommunities)
        }
    }
}

@Composable
fun CommunitySection(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    communities: List<CommunityMembership> = emptyList(),
){
    Column(modifier = modifier) {
        Text(text = "Member communities")
        ExploreCommunityCarousel(navController, modifier, communities)
        Text(
            text = "see all >",
            modifier = modifier.fillMaxWidth(),
            textAlign = TextAlign.End,
            color = MaterialTheme.colorScheme.secondary
        )

    }
}