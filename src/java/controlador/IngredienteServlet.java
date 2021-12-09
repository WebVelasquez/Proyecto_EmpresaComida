package controlador;

import conexion.Conexion;
import dao.IngredienteDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Ingredientes;

public class IngredienteServlet extends HttpServlet {
    
    String msg;
    boolean respuesta;
    Conexion conn = new Conexion();
    IngredienteDao indao = new IngredienteDao(conn);
    RequestDispatcher rd;
    List<Ingredientes> lista;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch(action){
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
        String ingrediente = request.getParameter("ingrediente");
        String letra = request.getParameter("letra");
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        Ingredientes ingr = new Ingredientes(0);
        ingr.setIngrediente(ingrediente);
        ingr.setLetra(letra);
        ingr.setCantidad(cantidad);
        respuesta = indao.insert(ingr);
        if (respuesta) {
            msg="registro guardado";
        }else{
            msg="registro NO guardado";
        }
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/registroIngredientes.jsp");
        rd.forward(request, response);
        

    }
    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_ingrediente = Integer.parseInt(request.getParameter("id_ingrediente"));
        String ingrediente = request.getParameter("ingrediente");
        String letra = request.getParameter("letra");
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        Ingredientes ingr = new Ingredientes(id_ingrediente);
        ingr.setIngrediente(ingrediente);
        ingr.setLetra(letra);
        ingr.setCantidad(cantidad);
        respuesta = indao.update(ingr);
        if (respuesta) {
            msg="REGISTRO ACTUALIZADO";
        }
        else{
            msg="REGISTRO NO ACTUALIZADO";
        }
        lista=indao.selectAll();
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/mostrarIngredientes.jsp");
        rd.forward(request, response);
        

    }
    protected void selectAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         lista = indao.selectAll();
        request.setAttribute("lista", lista);
        rd= request.getRequestDispatcher("/mostrarIngredientes.jsp");
        rd.forward(request, response);
        

    }
    protected void selectById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_ingrediente = Integer.parseInt(request.getParameter("id_ingrediente"));
        lista = indao.selectById(id_ingrediente);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/editarIngredientes.jsp");
        rd.forward(request, response);
        

    }
    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_ingrediente = Integer.parseInt(request.getParameter("id_ingrediente"));
        respuesta=indao.delete(id_ingrediente);
        if (respuesta) {
            msg="registro eliminado";
        }else{
            msg="registro NO eliminado";
        }
        lista=indao.selectAll();
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);
        rd=request.getRequestDispatcher("/mostrarIngredientes.jsp");
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
