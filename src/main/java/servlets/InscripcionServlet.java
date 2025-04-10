package servlets;

import models.Inscripcion;
import services.InscripcionService;
import com.google.gsongit remote add origing.Gson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/inscripciones/*")
public class InscripcionServlet extends HttpServlet {

    private InscripcionService servicio = new InscripcionService();
    private Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader reader = req.getReader();
        Inscripcion inscripcion = gson.fromJson(reader, Inscripcion.class);
        boolean registrada = servicio.registrar(inscripcion);

        if (registrada) {
            resp.setStatus(HttpServletResponse.SC_CREATED);
            resp.getWriter().write("Inscripción registrada");
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("No se pudo registrar la inscripción");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");

        String path = req.getPathInfo();
        if (path == null || path.equals("/")) {
            List<Inscripcion> lista = servicio.listar();
            resp.getWriter().write(gson.toJson(lista));
        } else if (path.startsWith("/carrera")) {
            String nombre = req.getParameter("nombre");
            List<Inscripcion> resultado = servicio.buscarPorCarrera(nombre);
            resp.getWriter().write(gson.toJson(resultado));
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}