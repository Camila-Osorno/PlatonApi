package models;

public class Inscripcion {
    private int id;
    private String estudiante;
    private String documento;
    private String carrera;
    private String asignatura;
    private String semestre;
    private String fechaInscripcion;
    private String estado;

    public Inscripcion() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getEstudiante() { return estudiante; }
    public void setEstudiante(String estudiante) { this.estudiante = estudiante; }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }

    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }

    public String getAsignatura() { return asignatura; }
    public void setAsignatura(String asignatura) { this.asignatura = asignatura; }

    public String getSemestre() { return semestre; }
    public void setSemestre(String semestre) { this.semestre = semestre; }

    public String getFechaInscripcion() { return fechaInscripcion; }
    public void setFechaInscripcion(String fechaInscripcion) { this.fechaInscripcion = fechaInscripcion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
