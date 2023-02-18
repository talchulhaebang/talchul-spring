package world.haebang.talchul.reservation.adapter.`in`

import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class ReservationSearchRequest(
    val storeCode: String,
    val date: String = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd"))
)