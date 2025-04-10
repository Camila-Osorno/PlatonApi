package services;

import models.Inscripcion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InscripcionService {
    private List<Inscripcion> inscripciones = new ArrayList<>();
    private int nextId = 1;

    public synchronized boolean registrar(Inscripcion inscripcion) {
        long totalEstudiante = inscripciones.stream()
                .filter(i -> i.getDocumento().equals(inscripcion.getDocumento()))
                .count();

        boolean yaRegistrado = inscripciones.stream()
                .anyMatch(i -> i.getDocumento().equals(inscripcion.getDocumento()) &&
                        i.getAsignatura().equalsIgnoreCase(inscripcion.getAsignatura()));

        if (totalEstudiante >= 7 || yaRegistrado) {
            return false;
        }

        inscripcion.setId(nextId++);
        inscripciones.add(inscripcion);
        return true;
    }

    public List<Inscripcion> listar() {
        return inscripciones;
    }

    public List<Inscripcion> buscarPorCarrera(String carrera) {
        return inscripciones.stream()
                .filter(i -> i.getCarrera().equalsIgnoreCase(carrera))
                .collect(Collectors.toList());
    }
}

