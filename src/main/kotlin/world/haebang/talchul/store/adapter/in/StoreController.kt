package world.haebang.talchul.store.adapter.`in`

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import world.haebang.talchul.store.application.StoreService

@RestController
@RequestMapping("/store")
class StoreController(
    private val storeService: StoreService,
) {

    @GetMapping
    fun search(): List<StoreSearchResponse> {
        return storeService.findAll()
    }

    @GetMapping("{storeId}")
    fun searchById(@PathVariable storeId: Long): StoreSearchResponse? {
        return storeService.findById(storeId)
    }

    @PostMapping
    fun register(@RequestBody request: StoreRegisterRequest) {
        return storeService.register(request)
    }

    @DeleteMapping("{storeId}")
    fun delete(@PathVariable storeId: Long) {
        storeService.delete()
    }
}