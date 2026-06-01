package ec.edu.espe.espe_tech.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class InventoryReportDTO {
    private String categoria;
    private BigDecimal valorTotal;
    private BigDecimal promedio;
    private String equipoMasCaro;
}
