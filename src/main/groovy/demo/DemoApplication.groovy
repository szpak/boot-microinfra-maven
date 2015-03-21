package demo

import com.ofg.infrastructure.environment.EnvironmentSetupVerifier
import groovy.transform.TypeChecked
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.EnableAspectJAutoProxy

import static com.ofg.config.BasicProfiles.*

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@TypeChecked
class DemoApplication {

    static void main(String[] args) {
        SpringApplication application = new SpringApplication(DemoApplication)
        application.addListeners(new EnvironmentSetupVerifier([DEVELOPMENT, PRODUCTION, TEST]))
        application.run(args)
    }
}