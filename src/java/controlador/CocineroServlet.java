package controlador;

import conexion.Conexion;
import dao.CocineroDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cocinero;

public class CocineroServlet extends HttpServlet {

    String msg;
    boolean respuesta;
    Conexion conn = new Conexion();
    CocineroDao cnrdao = new CocineroDao(conn);
    RequestDispatcher rd;
    List<Cocinero> lista;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "insertar":
                insert(request, response);
                break;
            case "seleccionar":
                selectAll(request, response);
                break;
            case "seleccionarById":
                selectById(request, response);
                break;
            case "actualizar":
                update(request, response);
                break;
            case "eliminar":
                delete(request, response);
                break;
        }

    }

    protected void insert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int dni = Integer.parseInt(request.getParameter("dni"));
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        int tel_fijo = Integer.parseInt(request.getParameter("tel_fijo"));
        int tel_movil = Integer.parseInt(request.getParameter("tel_movil"));
        int anios_servicio = Integer.parseInt(request.getParameter("anios_servicio"));
        Cocinero cnr = new Cocinero(0);
        cnr.setDni(dni);
        cnr.setNombres(nombres);
        cnr.setApellidos(apellidos);
        cnr.setTel_fijo(tel_fijo);
        cnr.setTel_movil(tel_movil);
        cnr.setAnios_servicio(anios_servicio);
        respuesta = cnrdao.insert(cnr);
        if (respuesta) {
            msg = "Empleado guardado";
        } else {
            msg = "Empleado NO guardado";
        }
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("registroCocinero.jsp");
        rd.forward(request, response);

    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_cocinero = Integer.parseInt(request.getParameter("id_cocinero"));
        int dni = Integer.parseInt(request.getParameter("dni"));
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        int tel_fijo = Integer.parseInt(request.getParameter("tel_fijo"));
        int tel_movil = Integer.parseInt(request.getParameter("tel_movil"));
        int anios_servicio = Integer.parseInt(request.getParameter("anios_servicio"));
        Cocinero cnr = new Cocinero(id_cocinero);
        cnr.setDni(dni);
        cnr.setNombres(nombres);
        cnr.setApellidos(apellidos);
        cnr.setTel_fijo(tel_fijo);
        cnr.setTel_movil(tel_movil);
        cnr.setAnios_servicio(anios_servicio);
        respuesta = cnrdao.update(cnr);
        if (respuesta) {
            msg = "Empleado actualizado";
        } else {
            msg = "Empleado NO actualizado";
        }
        lista= cnrdao.selectAll();
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/mostrarCocineros.jsp");
        rd.forward(request, response);

    }

    protected void selectAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         lista = cnrdao.selectAll();
        request.setAttribute("lista", lista);
        rd= request.getRequestDispatcher("/mostrarCocineros.jsp");
        rd.forward(request, response);

    }

    protected void selectById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_cocinero = Integer.parseInt(request.getParameter("id_cocinero"));
        lista = cnrdao.selectById(id_cocinero);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/editarCocinero.jsp");
        rd.forward(request, response);

    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_cocinero = Integer.parseInt(request.getParameter("id_cocinero"));
        respuesta=cnrdao.delete(id_cocinero);
        if (respuesta) {
            msg="registro eliminado";
        }else{
            msg="registro NO eliminado";
        }
        lista=cnrdao.selectAll();
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);
        rd=request.getRequestDispatcher("mostrarCocineros.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
