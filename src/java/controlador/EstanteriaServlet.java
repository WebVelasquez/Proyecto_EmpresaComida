package controlador;

import conexion.Conexion;
import dao.AlmacenDao;
import dao.EstanteriaDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Almacen;
import modelo.Estanteria;

public class EstanteriaServlet extends HttpServlet {

    String msg;
    boolean respuesta;
    Conexion conn = new Conexion();
    EstanteriaDao estdao = new EstanteriaDao(conn);
    AlmacenDao almdao = new AlmacenDao(conn);
    RequestDispatcher rd;
    List<Estanteria> lista;
    List<Almacen> listaAlmacenes;

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
            case "seleccionarById":
                selectById(request, response);
                break;
            case "irinsertar":
                irInsertar(request, response);
                break;
            case "seleccionar":
                selectAll(request, response);
                break;
            case "eliminar":
                delete(request, response);
                break;
        }

    }

    protected void insert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String estante = request.getParameter("estante");
        String tamaño = request.getParameter("tamanio");
        int id_almacen = Integer.parseInt(request.getParameter("id_almacen"));
        Estanteria estr = new Estanteria(0);
        Almacen alm = new Almacen(id_almacen);
        estr.setEstante(estante);
        estr.setTamaño(tamaño);
        estr.setId_almacen(alm);
        respuesta = estdao.insert(estr);
        if (respuesta) {
            msg = "REGISTRO GUARDADO";
        } else {
            msg = "REGISTRO NO GUARDADO";
        }
        request.setAttribute("msg", msg);

        rd = request.getRequestDispatcher("/registroEstante.jsp");
        rd.forward(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_estanteria = Integer.parseInt(request.getParameter("id_estanteria"));
        String estante = request.getParameter("estante");
        String tamaño = request.getParameter("tamanio");
        int id_almacen = Integer.parseInt(request.getParameter("id_almacen"));
        Estanteria estr = new Estanteria(id_estanteria);
        Almacen alm = new Almacen(id_almacen);
        estr.setEstante(estante);
        estr.setTamaño(tamaño);
        estr.setId_almacen(alm);
        respuesta = estdao.update(estr);
        if (respuesta) {
            msg = "guardado correctamente";
        } else {
            msg = "no guardado";
        }
        lista = estdao.selectAll();
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/mostrarEstanteria.jsp");
        rd.forward(request, response);

    }

    protected void selectAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        lista = estdao.selectAll();
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/mostrarEstanteria.jsp");
        rd.forward(request, response);

    }

    protected void selectById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_estanteria = Integer.parseInt(request.getParameter("id_estanteria"));
        lista = estdao.selectById(id_estanteria);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/editarEstanteria.jsp");
        rd.forward(request, response);

    }

    protected void irInsertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        listaAlmacenes = almdao.selectAll();
        lista = estdao.selectAll();
        request.setAttribute("listaAlmacenes", listaAlmacenes);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/registroEstante.jsp");
        rd.forward(request, response);

    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_estanteria = Integer.parseInt(request.getParameter("id_estanteria"));
        respuesta = estdao.delete(id_estanteria);
        if (respuesta) {
            msg = "dato eliminado";
        } else {
            msg = "no eliminado";
        }
        lista = estdao.selectAll();
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/mostrarEstanteria.jsp");
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
