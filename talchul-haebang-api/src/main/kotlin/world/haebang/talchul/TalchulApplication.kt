package world.haebang.talchul

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class TalchulApplication

fun main(args: Array<String>) {
	runApplication<TalchulApplication>(*args)
}
