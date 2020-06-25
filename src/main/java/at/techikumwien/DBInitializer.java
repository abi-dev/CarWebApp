package at.techikumwien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;
import java.util.List;

@Configuration
@Profile("!test")
public class DBInitializer {
    private final CarRepository carRepository;

    public DBInitializer(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void handleApplicationEvent() {
        carRepository.saveAll(
                List.of(
                        new Car("Peter"),
                        new Car("Benni")
                )
        );
    }
}
