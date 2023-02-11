package world.haebang.talchul.authorization.application

interface AuthService {
    fun getPublicKeyText(): String
    fun decrypt(encrypted: String): String
}