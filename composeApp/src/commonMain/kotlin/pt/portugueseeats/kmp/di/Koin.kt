package pt.portugueseeats.kmp.di


import io.ktor.client.HttpClient
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.includes
import org.koin.dsl.module
import pt.portugueseeats.kmp.data.RestaurantApi
import pt.portugueseeats.kmp.data.network.KtorHttpClient
import pt.portugueseeats.kmp.data.repository.RestaurantsRepositoryImpl
import pt.portugueseeats.kmp.domain.repository.RestaurantsRepository
import pt.portugueseeats.kmp.domain.use_case.GetRestaurantsUseCase
import pt.portugueseeats.kmp.presentation.restaurants.RestaurantsViewModel

val networkModule = module {
    single { KtorHttpClient(isDebug = true) }
    single<HttpClient> { get<KtorHttpClient>().client }
    single { RestaurantApi(get()) }
}

val repositoryModule = module {
    single<RestaurantsRepository> { RestaurantsRepositoryImpl(get()) }
}

val useCaseModule = module {
    factory { GetRestaurantsUseCase(get()) }
}

val viewModelModule = module {
    factory { RestaurantsViewModel(get()) }
}

val appModule = module {
    includes(networkModule, repositoryModule, useCaseModule, viewModelModule)
}

fun initKoin(configuration: KoinAppDeclaration? = null) {
    startKoin {
        includes(configuration)
        modules(
            appModule
        )
        printLogger(Level.DEBUG)
    }
}
