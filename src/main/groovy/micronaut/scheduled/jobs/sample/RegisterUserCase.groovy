package micronaut.scheduled.jobs.sample

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import io.micronaut.scheduling.TaskScheduler

import javax.inject.Singleton
import java.text.SimpleDateFormat
import java.time.Duration

@CompileStatic
@Slf4j
@Singleton
class RegisterUserCase {

    protected final TaskScheduler taskScheduler
    protected final EmailUseCase emailUseCase

    RegisterUserCase(TaskScheduler taskScheduler, EmailUseCase emailUseCase) {
        this.taskScheduler = taskScheduler
        this.emailUseCase = emailUseCase
    }

    void register(String email) {
        log.info("saving {} at {}", email, new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date()))
        scheduleFollowupEmail(email, "Welcome to Micronaut")
    }

    private void scheduleFollowupEmail(String email, String message) {
        EmailTask task = new EmailTask(emailUseCase: emailUseCase, email: email, message: message)
        taskScheduler.schedule(Duration.ofMinutes(1), task)
    }
}
