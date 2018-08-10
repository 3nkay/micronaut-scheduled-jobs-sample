package micronaut.scheduled.jobs.sample

import groovy.transform.CompileStatic
import io.micronaut.context.event.ApplicationEventListener
import io.micronaut.runtime.Micronaut
import io.micronaut.runtime.server.event.ServerStartupEvent

import javax.inject.Singleton

@CompileStatic
@Singleton
class Application implements ApplicationEventListener<ServerStartupEvent> {

    private final RegisterUserCase registerUserCase

    Application(RegisterUserCase registerUserCase) {
        this.registerUserCase = registerUserCase
    }

    static void main(String[] args) {
        Micronaut.run(Application)
    }

    @Override
    void onApplicationEvent(ServerStartupEvent event) {
        try {
            registerUserCase.register("harry@micronaut.example")
            Thread.sleep(20_000)
            registerUserCase.register("ron@micronaut.example")
        } catch (InterruptedException e) {
            e.printStackTrace()
        }
    }
}