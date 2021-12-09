package controlador;

import conexion.Conexion;
import dao.UsuarioDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;

public class UsuarioServlet extends HttpServlet {

    boolean respuesta;
    String msg;
    RequestDispatcher rd;
    Conexion conn = new Conexion();
    UsuarioDao usdao = new UsuarioDao(conn);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "insertar":
                insert(request, response);
                break;
            case "login":
                login(request, response);
                break;
            case "logout":
                logout(request, response);
                break;
        }

    }

    protected void insert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");
        Usuario usr = new Usuario(0);
        usr.setNombre(nombre);
        usr.setApellido(apellido);
        usr.setUsuario(usuario);
        usr.setClave(clave);
        respuesta=usdao.insert(usr);
        if (respuesta) {
            msg="Usuario creado";
        }else{
            msg="Campos incorrectos";
        }
        request.setAttribute("msg", msg);
        rd=request.getRequestDispatcher("/registroUser.jsp");
        rd.forward(request, response);
        

    }

    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");

        if (usdao.login(usuario, clave)) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            request.getRequestDispatcher("/Dashboard.jsp").forward(request, response);
            rd.forward(request, response);
        } else {
            msg = "usuario o clave incorrecta";
            request.setAttribute("msg", msg);
            rd = request.getRequestDispatcher("/Login.jsp");
            rd.forward(request, response);
        }

    }

    protected void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        sesion.invalidate();
        rd = request.getRequestDispatcher("/Login.jsp");
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
