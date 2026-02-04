package pt.portugueseeats.kmp.presentation.restaurants

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.koin.compose.viewmodel.koinViewModel
import pt.portugueseeats.kmp.domain.Restaurant
import pt.portugueseeats.kmp.domain.error.ErrorEntity

@Composable
fun RestaurantsScreen(
    viewModel : RestaurantsViewModel = koinViewModel(),
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.load()
    }

    Box(modifier = Modifier.fillMaxSize().padding(top = 100.dp)) {
        when {
            state.isLoading -> LoadingView()
            state.error != null -> ErrorView(state.error!!)
            else -> RestaurantsList(state.restaurants)
        }
    }

}

@Composable
fun LoadingView() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorView(error: ErrorEntity) {
    Text("Error: ${error::class.simpleName}")
}

@Composable
fun RestaurantsList(restaurants: List<Restaurant>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(restaurants) { restaurant ->
            Column(modifier = Modifier.fillMaxWidth().height(100.dp)) {
                Text(
                    text = restaurant.name, color = Color.Black
                )
                Text(
                    text = restaurant.description, color = Color.Black
                )
            }
        }
    }
}
