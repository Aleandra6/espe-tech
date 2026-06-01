package ec.edu.espe.espe_tech.service;

import ec.edu.espe.espe_tech.dto.InventoryReportDTO;
import ec.edu.espe.espe_tech.entity.Categoria;
import ec.edu.espe.espe_tech.entity.Estado;
import ec.edu.espe.espe_tech.entity.HardwareEntity;
import ec.edu.espe.espe_tech.repository.HardwareRepository;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class HardwareService {
    private final HardwareRepository repository;
    private final AiService aiService;

    public HardwareService(HardwareRepository repository, AiService aiService) {
        this.repository = repository;
        this.aiService=aiService;
    }

    public Map<Categoria, InventoryReportDTO> reporteImperativo() {

        List<HardwareEntity> equipos = repository.findAll();

        LocalDate limite = LocalDate.now().minusYears(5);

        Map<Categoria, List<HardwareEntity>> agrupados = new HashMap<>();

        for (HardwareEntity equipo : equipos) {

            if (equipo.getEstado() == Estado.ACTIVO &&
                    equipo.getFechaCompra().isAfter(limite)) {

                if (!agrupados.containsKey(equipo.getCategoria())) {
                    agrupados.put(equipo.getCategoria(),
                            new ArrayList<>());
                }

                agrupados.get(equipo.getCategoria()).add(equipo);
            }
        }

        Map<Categoria, InventoryReportDTO> resultado = new HashMap<>();

        for (Categoria categoria : agrupados.keySet()) {

            List<HardwareEntity> lista = agrupados.get(categoria);

            BigDecimal total = BigDecimal.ZERO;

            HardwareEntity masCaro = lista.get(0);

            for (HardwareEntity equipo : lista) {

                total = total.add(equipo.getPrecio());

                if (equipo.getPrecio()
                        .compareTo(masCaro.getPrecio()) > 0) {

                    masCaro = equipo;
                }
            }

            BigDecimal promedio =
                    total.divide(
                            BigDecimal.valueOf(lista.size()),
                            2,
                            RoundingMode.HALF_UP);

            InventoryReportDTO dto = new InventoryReportDTO();

            dto.setCategoria(categoria.name());
            dto.setValorTotal(total);
            dto.setPromedio(promedio);
            dto.setEquipoMasCaro(masCaro.getModelo());

            resultado.put(categoria, dto);
        }

        return resultado;
    }

    public Map<Categoria, InventoryReportDTO> reporteFuncional() {

        LocalDate limite = LocalDate.now().minusYears(5);

        return repository.findAll()
                .stream()

                .filter(h ->
                        h.getEstado() == Estado.ACTIVO)

                .filter(h ->
                        h.getFechaCompra().isAfter(limite))

                .collect(Collectors.groupingBy(
                        HardwareEntity::getCategoria))

                .entrySet()
                .stream()

                .collect(Collectors.toMap(

                        Map.Entry::getKey,

                        entry -> {

                            var lista = entry.getValue();

                            DoubleSummaryStatistics stats =
                                    lista.stream()

                                            .collect(Collectors
                                                    .summarizingDouble(
                                                            h -> h.getPrecio()
                                                                    .doubleValue()));

                            Optional<HardwareEntity> masCaro =
                                    lista.stream()

                                            .max(Comparator
                                                    .comparing(
                                                            HardwareEntity::getPrecio));

                            InventoryReportDTO dto =
                                    new InventoryReportDTO();

                            dto.setCategoria(
                                    entry.getKey().name());

                            dto.setValorTotal(
                                    BigDecimal.valueOf(
                                            stats.getSum()));

                            dto.setPromedio(
                                    BigDecimal.valueOf(
                                            stats.getAverage()));

                            dto.setEquipoMasCaro(
                                    masCaro
                                            .map(HardwareEntity::getModelo)
                                            .orElse("N/A"));

                            return dto;
                        }
                ));
    }
    public String generarResumen() {
        return aiService.generarResumen(
                reporteFuncional());
    }
}
