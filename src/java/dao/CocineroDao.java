package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Cocinero;

public class CocineroDao {

    Conexion conn;

    public CocineroDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insert(Cocinero cnr) {
        String sql = "insert into cocinero values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, cnr.getId_cocinero());
            ps.setInt(2, cnr.getDni());
            ps.setString(3, cnr.getNombres());
            ps.setString(4, cnr.getApellidos());
            ps.setInt(5, cnr.getTel_fijo());
            ps.setInt(6, cnr.getTel_movil());
            ps.setInt(7, cnr.getAnios_servicio());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean update(Cocinero cnr) {
        String sql = "update cocinero set dni=?, nombres=?, apellidos=?, tel_fijo=?, tel_movil=?, anios_servicio=? where id_cocinero=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, cnr.getDni());
            ps.setString(2, cnr.getNombres());
            ps.setString(3, cnr.getApellidos());
            ps.setInt(4, cnr.getTel_fijo());
            ps.setInt(5, cnr.getTel_movil());
            ps.setInt(6, cnr.getAnios_servicio());
            ps.setInt(7, cnr.getId_cocinero());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    
    public List<Cocinero> selectAll() {
        String sql = "select * from cocinero";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Cocinero cnr;
            List<Cocinero> lista = new LinkedList<>();
            while (rs.next()) {
                cnr = new Cocinero(rs.getInt("id_cocinero"));
                cnr.setDni(rs.getInt("dni"));
                cnr.setNombres(rs.getString("nombres"));
                cnr.setApellidos(rs.getString("apellidos"));
                cnr.setTel_fijo(rs.getInt("tel_fijo"));
                cnr.setTel_movil(rs.getInt("tel_movil"));
                cnr.setAnios_servicio(rs.getInt("anios_servicio"));
                lista.add(cnr);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("error: " + e);
            return null;
        }
    }
    
    public List<Cocinero> selectById(int id_cocinero) {
        String sql = "select * from cocinero where id_cocinero=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_cocinero);
            ResultSet rs = ps.executeQuery();
            Cocinero cnr;
            List<Cocinero> lista = new LinkedList<>();
            while (rs.next()) {
                cnr = new Cocinero(rs.getInt("id_cocinero"));
                cnr.setDni(rs.getInt("dni"));
                cnr.setNombres(rs.getString("nombres"));
                cnr.setApellidos(rs.getString("apellidos"));
                cnr.setTel_fijo(rs.getInt("tel_fijo"));
                cnr.setTel_movil(rs.getInt("tel_movil"));
                cnr.setAnios_servicio(rs.getInt("anios_servicio"));
                lista.add(cnr);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
    
     public boolean delete(int id_cocinero) {
        String sql = "delete from cocinero where id_cocinero=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_cocinero);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
