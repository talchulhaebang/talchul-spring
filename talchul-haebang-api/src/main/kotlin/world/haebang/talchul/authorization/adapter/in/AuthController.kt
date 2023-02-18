package world.haebang.talchul.authorization.adapter.`in`

import org.springframework.web.bind.annotation.*
import world.haebang.talchul.authorization.application.AuthService

@RestController
@RequestMapping("/auth")
class AuthController(private val authService: AuthService) {

    @GetMapping
    fun getKey(): String {
        return authService.getPublicKeyText()
    }

    @PostMapping("/decrypt")
    fun decrypt(@RequestBody message: String): String {
        return authService.decrypt(message)
    }
}