package ec.edu.espe.espe_tech.entity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HardwareEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private BigDecimal precio;

    private LocalDate fechaCompra;

    @Enumerated(EnumType.STRING)
    private Estado estado;
}
