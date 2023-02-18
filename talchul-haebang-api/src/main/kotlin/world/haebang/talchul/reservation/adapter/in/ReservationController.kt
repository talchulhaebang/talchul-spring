package world.haebang.talchul.reservation.adapter.`in`

import org.springframework.web.bind.annotation.*
import world.haebang.talchul.reservation.adapter.out.ReservationSearchResponse
import world.haebang.talchul.reservation.application.ReservationService

@RestController
@RequestMapping("/reservation")
class ReservationController(
    private val reservationService: ReservationService,
) {

    @GetMapping
    fun search(@RequestParam storeCode: String, @RequestParam date: String): List<ReservationSearchResponse> {
        return reservationService.search(ReservationSearchRequest(storeCode, date))
    }

    //@PostMapping
    fun create() {

    }

    //@DeleteMapping
    fun delete() {

    }

}