package pt.portugueseeats.kmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform