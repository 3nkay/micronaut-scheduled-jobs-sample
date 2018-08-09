package micronaut.scheduled.jobs.sample

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import io.micronaut.scheduling.annotation.Scheduled

import java.text.SimpleDateFormat

@CompileStatic
@Singleton
@Slf4j
class HelloWorldJob {

    @Scheduled(fixedDelay = "10s")
    void executeEvertyTen() {
        log.info("Simple Job every 10 seconds :{}", new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date()))
    }

    @Scheduled(fixedDelay = "45s", initialDelay = "5s")
    void executeEveryFourtyFive() {
        log.info("Simple Job every 45 seconds :{}", new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date()))
    }


}
