package world.haebang.talchul.authorization.adapter.`in`

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import world.haebang.talchul.authorization.application.AuthService

@RestController
@RequestMapping("/auth")
class AuthController(private val authService: AuthService) {

    @GetMapping
    fun getKey(): String {
        return authService.get()
    }
}