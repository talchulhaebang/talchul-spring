package world.haebang.talchul.configuration

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