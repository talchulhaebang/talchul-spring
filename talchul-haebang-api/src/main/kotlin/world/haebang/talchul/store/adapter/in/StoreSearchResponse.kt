package world.haebang.talchul.store.adapter.`in`

import world.haebang.talchul.domain.Store

data class StoreSearchResponse(
    val id: Long,
    val name: String,
    val address: String,
    val url: String,
    val longitude: String? = null,
    val latitude: String? = null,
) {

    companion object {
        fun from(store: Store): StoreSearchResponse {
            return StoreSearchResponse(
                id = store.id!!,
                name = store.name,
                address = store.address,
                url = store.url,
                longitude = store.longitude,
                latitude = store.latitude
            )
        }
    }

}