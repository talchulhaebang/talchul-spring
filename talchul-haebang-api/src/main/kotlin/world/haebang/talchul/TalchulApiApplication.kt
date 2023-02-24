package world.haebang.talchul

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class TalchulApiApplication

fun main(args: Array<String>) {
	runApplication<TalchulApiApplication>(*args)
}
