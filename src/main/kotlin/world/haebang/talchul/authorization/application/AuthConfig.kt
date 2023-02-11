package world.haebang.talchul.authorization.application

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import world.haebang.talchul.authorization.application.AuthService
import world.haebang.talchul.authorization.application.LocalAuthService

@Configuration
class AuthConfig {

    @Bean
    fun authService(): AuthService {
        return LocalAuthService()
    }

}