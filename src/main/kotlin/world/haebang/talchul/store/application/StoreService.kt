package world.haebang.talchul.store.application

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import world.haebang.talchul.store.adapter.`in`.StoreRegisterRequest
import world.haebang.talchul.store.adapter.`in`.StoreSearchResponse
import world.haebang.talchul.store.adapter.out.StoreRepository
import world.haebang.talchul.store.domain.Store

@Service
class StoreService(
    private val storeRepository: StoreRepository,
) {

    fun findAll(): List<StoreSearchResponse> {
        val results = storeRepository.findAll()
        return if (results.size > 0) results.map { it.toResponse() } else listOf()
    }

    fun findById(id: Long): StoreSearchResponse {
        return storeRepository.findByIdOrNull(id)?.toResponse() ?: throw IllegalStateException("읎어용 읎어")
    }

    @Transactional
    fun register(request: StoreRegisterRequest) {
        check(storeRepository.findByCode(request.code) == null) { "해당 Code로 등록된 Store 정보가 존재합니다. code: ${request.code}" }
        storeRepository.save(Store.of(request.name, request.code, request.address, request.url, request.latitude, request.longitude))
    }

    @Transactional
    fun delete(id: Long) {
        val result = storeRepository.findByIdOrNull(id) ?: throw IllegalStateException("읎어영 읎어")
        storeRepository.delete(result)
    }
}