package world.haebang.talchul.domain

import javax.persistence.*

@Entity
@Table(name = "store")
class Store private constructor(
    val name: String,
    val code: String,
    val address: String,
    val url: String,
    var latitude: String?,
    var longitude: String?,
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
        private set

    companion object {
        fun of(name: String, code: String, address: String, url: String, latitude: String?, longitude: String?): Store {
            return Store(
                name = name,
                code = code,
                address = address,
                url = url,
                latitude = latitude,
                longitude = longitude
            )
        }
    }
}

