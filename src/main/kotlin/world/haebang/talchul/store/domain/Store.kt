package world.haebang.talchul.store.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Store(
    val name: String,
    val address: String,
    val url: String,
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
        private set

    var latitude: String? = null
        private set

    var longitude: String? = null
        private set

    fun of(name: String, address: String, url: String): Store {
        return Store(name, address, url)
    }
}

