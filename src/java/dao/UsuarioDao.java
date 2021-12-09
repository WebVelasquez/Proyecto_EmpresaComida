
package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Usuario;


public class UsuarioDao {
    
    Conexion conn;
    
    public UsuarioDao(Conexion conn){
        this.conn=conn;
    }
    
    public boolean login(String usuario, String clave) {
        String sql = "select usuario, clave from usuario where usuario = ? and clave = ?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, clave);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    
     public boolean insert(Usuario usr) {
        String sql = "insert into usuario values (?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, usr.getId_usuario());
            ps.setString(2, usr.getNombre());
            ps.setString(3, usr.getApellido());
            ps.setString(4, usr.getUsuario());
            ps.setString(5, usr.getClave());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
