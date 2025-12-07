package com.example.glide.workspace.core.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.glide.R

data class MenuItem(
    val id: Int,
    val title: String,
    val route: String,
    val iconRes: Int = R.drawable.bell_icon
)

@Composable
fun MenuGrid(
    modifier: Modifier = Modifier,
    items: List<MenuItem>,
    onItemClick: (MenuItem) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),   // 3 per row, auto wraps
        modifier = modifier.padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items) { item ->
            MenuGridItem(item = item, onClick = { onItemClick(item) })
        }
    }
}

@Composable
fun MenuGridItem(
    item: MenuItem,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, Color.Black),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onPrimary),
        modifier = Modifier
            .size(110.dp)               // same size boxes
            .clickable { onClick() }
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = item.iconRes),
                contentDescription = item.title,
                modifier = Modifier.size(32.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = item.title,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun BottomSheetContent() {
    val menuList: List<MenuItem> = listOf(
        MenuItem(
            id = 2,
            title = "Roles",
            route = "current-community/roles"
        ),
        MenuItem(
            id = 3,
            title = "Settings",
            route = "current-community/settings"
        )
    )


    MenuGrid(
        items = menuList,
        onItemClick = {
            // TODO: navigate or action
        }
    )
}
