package world.haebang.talchul.store.adapter.`in`

data class StoreSearchResponse (
    val id: Long,
    val name: String,
    val address: String,
    val url: String,
    val longitude: String? = null,
    val latitude: String? = null,
)