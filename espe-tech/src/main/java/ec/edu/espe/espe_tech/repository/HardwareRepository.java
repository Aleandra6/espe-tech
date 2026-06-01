package ec.edu.espe.espe_tech.repository;
import ec.edu.espe.espe_tech.entity.HardwareEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HardwareRepository
        extends JpaRepository<HardwareEntity, Long> {
}
