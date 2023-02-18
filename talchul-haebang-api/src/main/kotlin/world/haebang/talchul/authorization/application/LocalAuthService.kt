package world.haebang.talchul.authorization.application

import org.apache.tomcat.util.codec.binary.Base64
import org.springframework.stereotype.Service
import java.nio.charset.Charset
import javax.crypto.Cipher

@Service
class LocalAuthService(
    private val fileKeyManager: FileKeyManager
) : AuthService {

    override fun getPublicKeyText(): String {
        return fileKeyManager.getPublicKeyText()
    }

    override fun decrypt(encrypted: String): String {
        return Cipher.getInstance(FileKeyManager.ALGORITHM)
            .also { it.init(Cipher.DECRYPT_MODE, fileKeyManager.loadPrivateKey()) }
            .let { it.doFinal(Base64.decodeBase64(encrypted)) }
            .toString(Charset.defaultCharset())
    }
}