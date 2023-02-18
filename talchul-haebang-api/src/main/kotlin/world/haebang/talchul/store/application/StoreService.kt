package world.haebang.talchul.store.application

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import world.haebang.talchul.store.adapter.`in`.StoreRegisterRequest
import world.haebang.talchul.store.adapter.`in`.StoreSearchResponse
import world.haebang.talchul.store.adapter.out.StoreRepository
import world.haebang.talchul.domain.Store

@Service
class StoreService(
    private val storeRepository: StoreRepository,
) {

    fun findAll(): List<StoreSearchResponse> {
        val results = storeRepository.findAll()
        return if (results.size > 0) results.map { StoreSearchResponse.from(it) } else listOf()
    }

    fun findById(id: Long): StoreSearchResponse {
        return storeRepository.findByIdOrNull(id)?.let { StoreSearchResponse.from(it) }
            ?: throw IllegalStateException("해당 Id로 등록된 Store 정보가 존재하지 않습니다.")
        // TODO 별도 Exception 정의
    }

    @Transactional
    fun register(request: StoreRegisterRequest) {
        check(storeRepository.findByCode(request.code) == null) { "해당 Code로 등록된 Store 정보가 존재합니다. code: ${request.code}" }
        storeRepository.save(
            Store.of(
                name = request.name,
                code = request.code,
                address = request.address,
                url = request.url,
                latitude = request.latitude,
                longitude = request.longitude
            )
        )
    }

    @Transactional
    fun delete(id: Long) {
        val result = storeRepository.findByIdOrNull(id) ?: throw IllegalStateException("해당 Id로 등록된 Store 정보가 존재하지 않습니다.")
        storeRepository.delete(result)
    }
}