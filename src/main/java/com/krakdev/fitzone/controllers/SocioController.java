package com.krakdev.fitzone.controllers;

import com.krakdev.fitzone.entidades.Socio;
import com.krakdev.fitzone.services.ServicioSocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/socios")
public class SocioController {

    @Autowired
    private ServicioSocio servicioSocio;

    @PostMapping
    public ResponseEntity<Socio> crearSocio(@RequestBody Socio socio) {
        Socio nuevoSocio = servicioSocio.crear(socio);
        return new ResponseEntity<>(nuevoSocio, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Socio>> listarSocios() {
        List<Socio> socios = servicioSocio.listar();
        return new ResponseEntity<>(socios, HttpStatus.OK);
    }

    @GetMapping("/estado")
    public ResponseEntity<List<Socio>> buscarPorEstado(@RequestParam boolean activo) {
        List<Socio> socios = servicioSocio.buscarPorEstado(activo);
        return new ResponseEntity<>(socios, HttpStatus.OK);
    }
}