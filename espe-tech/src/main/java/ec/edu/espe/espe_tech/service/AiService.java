package ec.edu.espe.espe_tech.service;

import ec.edu.espe.espe_tech.dto.InventoryReportDTO;
import ec.edu.espe.espe_tech.entity.Categoria;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AiService {
    public String generarResumen(
            Map<Categoria, InventoryReportDTO> reporte) {

        StringBuilder resumen = new StringBuilder();

        resumen.append("=== RESUMEN DEL INVENTARIO ===\n\n");

        for (InventoryReportDTO dto : reporte.values()) {

            resumen.append("Categoría: ")
                    .append(dto.getCategoria())
                    .append("\n");

            resumen.append("Valor Total: $")
                    .append(dto.getValorTotal())
                    .append("\n");

            resumen.append("Promedio: $")
                    .append(dto.getPromedio())
                    .append("\n");

            resumen.append("Equipo más caro: ")
                    .append(dto.getEquipoMasCaro())
                    .append("\n\n");
        }

        return resumen.toString();
    }
}
