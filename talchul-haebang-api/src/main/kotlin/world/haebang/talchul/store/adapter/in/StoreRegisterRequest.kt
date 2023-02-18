package world.haebang.talchul.store.adapter.`in`

data class StoreRegisterRequest(
    val code: String,
    val name: String,
    val address: String,
    val url: String,
    val latitude: String? = null,
    val longitude: String? = null,
)