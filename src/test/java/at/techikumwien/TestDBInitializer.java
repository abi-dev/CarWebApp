package at.techikumwien;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;

import java.util.List;

@Configuration
@Profile("test")
public class TestDBInitializer {
    private final CarRepository carRepository;

    public TestDBInitializer(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void handleApplicationEvent() {
        carRepository.saveAll(
                List.of(
                        new Car("TestPeter"),
                        new Car("TestBenni")
                )
        );
    }
}
