package controlador;

import conexion.Conexion;
import dao.PincheDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Pinche;

public class PincheServlet extends HttpServlet {

    String msg;
    boolean respuesta;
    Conexion conn = new Conexion();
    PincheDao pdao = new PincheDao(conn);
    RequestDispatcher rd;
    List<Pinche> lista;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "insertar":
                insert(request, response);
                break;
            case "actualizar":
                update(request, response);
                break;
            case "seleccionar":
                selectAll(request, response);
                break;
            case "seleccionarById":
                selectById(request, response);
                break;
            case "eliminar":
                delete(request, response);
                break;
        }

    }

    protected void insert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int dni = Integer.parseInt(request.getParameter("dni"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        int tel_fijo = Integer.parseInt(request.getParameter("tel_fijo"));
        int tel_movil = Integer.parseInt(request.getParameter("tel_movil"));
        Pinche pin = new Pinche(0);
        pin.setDni(dni);
        pin.setNombre(nombre);
        pin.setApellido(apellido);
        pin.setTel_fijo(tel_fijo);
        pin.setTel_movil(tel_movil);
        respuesta=pdao.insert(pin);
        if (respuesta) {
            msg="dato guardado";
        }else{
            msg="no guardado";
        }
        request.setAttribute("msg", msg);
        
        rd = request.getRequestDispatcher("/registroPinches.jsp");
        rd.forward(request, response); 

    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_pinche = Integer.parseInt(request.getParameter("id_pinche"));
        int dni = Integer.parseInt(request.getParameter("dni"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        int tel_fijo = Integer.parseInt(request.getParameter("tel_fijo"));
        int tel_movil = Integer.parseInt(request.getParameter("tel_movil"));
        Pinche pin = new Pinche(id_pinche);
        pin.setDni(dni);
        pin.setNombre(nombre);
        pin.setApellido(apellido);
        pin.setTel_fijo(tel_fijo);
        pin.setTel_movil(tel_movil);
        respuesta = pdao.update(pin);
        if (respuesta) {
            msg="dato actualizado";
        }else{
            msg="dato NO actualizado";
        }
        lista= pdao.selectAll();
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/mostrarPinches.jsp");
        rd.forward(request, response);

    }

    protected void selectAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        lista = pdao.selectAll();
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/mostrarPinches.jsp");
        rd.forward(request, response);

    }

    protected void selectById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_pinche = Integer.parseInt(request.getParameter("id_pinche"));
        lista = pdao.selectById(id_pinche);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/editarPinches.jsp");
        rd.forward(request, response);

    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_pinche = Integer.parseInt(request.getParameter("id_pinche"));
        respuesta=pdao.delete(id_pinche);
        if (respuesta) {
            msg="registro eliminado";
        }else{
            msg="registro NO eliminado";
        }
        lista=pdao.selectAll();
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);
        rd=request.getRequestDispatcher("mostrarPinches.jsp");
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
