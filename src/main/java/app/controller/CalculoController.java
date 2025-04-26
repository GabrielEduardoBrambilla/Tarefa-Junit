package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import app.dto.Entrada;
import app.entity.Calculo;
import app.service.CalculoService;

@RestController
@RequestMapping("/api/calculos")
@CrossOrigin("*")
public class CalculoController {

    @Autowired
    private CalculoService calculoService;

    @PostMapping
    public ResponseEntity<Calculo> calcular(@RequestBody Entrada entrada) {
        try {
            Calculo calculo = this.calculoService.calcular(entrada);
            return new ResponseEntity<>(calculo, HttpStatus.OK);
        } catch (IllegalArgumentException | RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
