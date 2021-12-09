package controlador;

import conexion.Conexion;
import dao.AlmacenDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Almacen;

public class AlmacenServlet extends HttpServlet {

    String msg;
    boolean respuesta;
    Conexion conn = new Conexion();
    AlmacenDao almdao = new AlmacenDao(conn);
    RequestDispatcher rd;
    List<Almacen> lista;

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
        String almacen = request.getParameter("almacen");
        int numero = Integer.parseInt(request.getParameter("numero"));
        String descripcion = request.getParameter("descripcion");
        Almacen alm = new Almacen(0);
        alm.setAlmacen(almacen);
        alm.setNumero(numero);
        alm.setDescripcion(descripcion);
        respuesta = almdao.insert(alm);
        if (respuesta) {
            msg = "ALMACEN REGISTRADO";
        } else {
            msg = "ALMACEN NO GUARDADO";
        }
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/registroAlmacen.jsp");
        rd.forward(request, response);

    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_almacen = Integer.parseInt(request.getParameter("id_almacen"));
        String almacen = request.getParameter("almacen");
        int numero = Integer.parseInt(request.getParameter("numero"));
        String descripcion = request.getParameter("descripcion");
        Almacen alm = new Almacen(id_almacen);
        alm.setAlmacen(almacen);
        alm.setNumero(numero);
        alm.setDescripcion(descripcion);
        respuesta = almdao.update(alm);
        if (respuesta) {
            msg = "guardado correctamente";
        } else {
            msg = "no guardado";
        }
        lista = almdao.selectAll();
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/mostrarAlmacen.jsp");
        rd.forward(request, response);

    }

    protected void selectById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_almacen = Integer.parseInt(request.getParameter("id_almacen"));
        lista = almdao.selectById(id_almacen);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/editarAlmacen.jsp");
        rd.forward(request, response);

    }

    protected void selectAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        lista = almdao.selectAll();
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/mostrarAlmacen.jsp");
        rd.forward(request, response);

    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_almacen = Integer.parseInt(request.getParameter("id_almacen"));
        respuesta = almdao.delete(id_almacen);
        if (respuesta) {
            msg = "dato eliminado";
        } else {
            msg = "no eliminado";
        }
        lista = almdao.selectAll();
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/mostrarAlmacen.jsp");
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
