package world.haebang.talchul.authorization.application

import org.apache.tomcat.util.codec.binary.Base64
import org.springframework.stereotype.Component
import java.nio.file.Files
import java.security.KeyFactory
import java.security.interfaces.RSAPrivateKey
import java.security.spec.PKCS8EncodedKeySpec
import kotlin.io.path.Path

@Component
class FileKeyManager {

    companion object {
        const val PUBLIC_KEY_PATH: String = "/Users/ryudana/public.pem"
        const val PRIVATE_KEY_PATH: String = "/Users/ryudana/private.pem"
        const val ALGORITHM: String = "RSA"
    }

    fun getPublicKeyText(): String {
        return readStringFromFile(PUBLIC_KEY_PATH)
    }

    fun loadPrivateKey(): RSAPrivateKey {
        val keyText = readStringFromFile(PRIVATE_KEY_PATH)
            .replace("-----BEGIN PRIVATE KEY-----\n", "")
            .replace("-----END PRIVATE KEY-----", "")

        val encoded = Base64.decodeBase64(keyText)
        return KeyFactory.getInstance(ALGORITHM)
            .generatePrivate(PKCS8EncodedKeySpec(encoded)) as RSAPrivateKey
    }

    private fun readStringFromFile(path: String): String {
        return Files.readString(Path(path))
    }
}