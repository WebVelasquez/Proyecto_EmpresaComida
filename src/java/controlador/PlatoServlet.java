package controlador;

import conexion.Conexion;
import dao.PlatoDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Plato;

public class PlatoServlet extends HttpServlet {

    String msg;
    boolean respuesta;
    Conexion conn = new Conexion();
    PlatoDao pltdao = new PlatoDao(conn);
    RequestDispatcher rd;
    List<Plato> lista;

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
            case "actualizar":
                update(request, response);
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
        String platos = request.getParameter("platos");
        String tipo = request.getParameter("tipo");
        double precio = Integer.parseInt(request.getParameter("precio"));
        Plato plt = new Plato(0);
        plt.setPlatos(platos);
        plt.setTipo(tipo);
        plt.setPrecio(precio);
        respuesta = pltdao.insert(plt);
        if (respuesta) {
            msg = "REGISTRO GUARDADO";
        } else {
            msg = "REGISTRO NO GUARDADO";
        }
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/registroPlato.jsp");
        rd.forward(request, response);

    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_plato = Integer.parseInt(request.getParameter("id_plato"));
       String platos = request.getParameter("platos");
       String tipo = request.getParameter("tipo");
       double precio = Integer.parseInt(request.getParameter("precio"));
       Plato plt = new Plato(id_plato);
       plt.setPlatos(platos);
       plt.setTipo(tipo);
       plt.setPrecio(precio);
       respuesta=pltdao.update(plt);
        if (respuesta) {
            msg="REGISTRO ACTUALIZADO";
        }
        else{
            msg="SU REGISTRO NO SE ACTUALIZO";
        }
        lista = pltdao.selectAll();
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);
        rd=request.getRequestDispatcher("/mostrarPlato.jsp");
        rd.forward(request, response);

    }

    protected void selectAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       lista = pltdao.selectAll();
       request.setAttribute("lista", lista);
       rd=request.getRequestDispatcher("/mostrarPlato.jsp");
       rd.forward(request, response);

    }

    protected void selectById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_plato = Integer.parseInt(request.getParameter("id_plato"));
       lista = pltdao.selectById(id_plato);
       request.setAttribute("lista", lista);
       rd=request.getRequestDispatcher("/editarPlato.jsp");
       rd.forward(request, response);

    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_plato = Integer.parseInt(request.getParameter("id_plato"));
       respuesta = pltdao.delete(id_plato);
        if (respuesta) {
            msg="REGISTRO ELIMINADO";
        }
        else{
            msg="NO SE PUDO ELIMINAR";
        }
        lista = pltdao.selectAll();
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/mostrarPlato.jsp");
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
