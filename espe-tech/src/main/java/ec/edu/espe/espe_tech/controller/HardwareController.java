package ec.edu.espe.espe_tech.controller;

import ec.edu.espe.espe_tech.service.HardwareService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hardware")
public class HardwareController {
    private final HardwareService service;

    public HardwareController(HardwareService service) {
        this.service = service;
    }

    @GetMapping("/imperativo")
    public Object imperativo() {
        return service.reporteImperativo();
    }

    @GetMapping("/funcional")
    public Object funcional() {
        return service.reporteFuncional();
    }
    @GetMapping("/resumen")
    public String resumen() {
        return service.generarResumen();
    }
}
