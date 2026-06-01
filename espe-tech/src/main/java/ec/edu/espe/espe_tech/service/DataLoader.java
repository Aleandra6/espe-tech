package ec.edu.espe.espe_tech.service;

import ec.edu.espe.espe_tech.entity.*;
import ec.edu.espe.espe_tech.repository.HardwareRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner{
    private final HardwareRepository repository;

    public DataLoader(HardwareRepository repository) {
        this.repository = repository;
}
    @Override
    public void run(String... args) {

        repository.save(
                new HardwareEntity(
                        null,
                        "Dell XPS",
                        Categoria.LAPTOP,
                        new BigDecimal("1500"),
                        LocalDate.now().minusYears(2),
                        Estado.ACTIVO));

        repository.save(
                new HardwareEntity(
                        null,
                        "HP ProDesk",
                        Categoria.PC,
                        new BigDecimal("1200"),
                        LocalDate.now().minusYears(1),
                        Estado.ACTIVO));

        repository.save(
                new HardwareEntity(
                        null,
                        "IBM Server",
                        Categoria.SERVIDOR,
                        new BigDecimal("5000"),
                        LocalDate.now().minusYears(3),
                        Estado.ACTIVO));
    }
}

