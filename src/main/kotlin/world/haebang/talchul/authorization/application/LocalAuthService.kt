package world.haebang.talchul.authorization.application

import org.springframework.stereotype.Service
import java.io.File
import java.nio.charset.Charset
import java.nio.file.Files
import kotlin.io.path.Path

@Service
class LocalAuthService: AuthService {
    companion object {
        const val path: String = "/Users/ryudana/public.pem"
    }

    override fun get(): String {
        return Files.readString(Path(path))
    }
}