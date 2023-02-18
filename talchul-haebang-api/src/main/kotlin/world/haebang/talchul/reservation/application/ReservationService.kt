package world.haebang.talchul.reservation.application

import org.springframework.stereotype.Service
import world.haebang.talchul.reservation.adapter.`in`.ReservationSearchRequest
import world.haebang.talchul.reservation.adapter.out.ReservationClient
import world.haebang.talchul.reservation.adapter.out.ReservationSearchResponse

@Service
class ReservationService(
    private val reservationClient: ReservationClient
) {

    fun search(request: ReservationSearchRequest): List<ReservationSearchResponse> {
        return reservationClient.search(request)
    }


}