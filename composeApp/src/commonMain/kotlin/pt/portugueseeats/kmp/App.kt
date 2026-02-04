package pt.portugueseeats.kmp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import pt.portugueseeats.kmp.presentation.restaurants.RestaurantsScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        RestaurantsScreen()
    }
}