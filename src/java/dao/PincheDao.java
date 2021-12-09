package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Pinche;

public class PincheDao {

    Conexion conn;

    public PincheDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insert(Pinche pin) {
        String sql = "insert into pinches values (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, pin.getId_pinche());
            ps.setInt(2, pin.getDni());
            ps.setString(3, pin.getNombre());
            ps.setString(4, pin.getApellido());
            ps.setInt(5, pin.getTel_fijo());
            ps.setInt(6, pin.getTel_movil());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean update(Pinche pin) {
        String sql = "update pinches set dni=?, nombre=?, apellido=?, tel_fijo=?, tel_movil=? where id_pinche=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, pin.getDni());
            ps.setString(2, pin.getNombre());
            ps.setString(3, pin.getApellido());
            ps.setInt(4, pin.getTel_fijo());
            ps.setInt(5, pin.getTel_movil());
            ps.setInt(6, pin.getId_pinche());
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            System.out.println("vivo" + e);
            return false;
        }
    }

    public List<Pinche> selectAll() {
        String sql = "select * from pinches";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Pinche pin;
            List<Pinche> lista = new LinkedList<>();
            while (rs.next()) {
                pin = new Pinche(rs.getInt("id_pinche"));
                pin.setDni(rs.getInt("dni"));
                pin.setNombre(rs.getString("nombre"));
                pin.setApellido(rs.getString("apellido"));
                pin.setTel_fijo(rs.getInt("tel_fijo"));
                pin.setTel_movil(rs.getInt("tel_movil"));

                lista.add(pin);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Pinche> selectById(int id_pinche) {
        String sql = "select * from pinches where id_pinche=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_pinche);
            ResultSet rs = ps.executeQuery();
            Pinche pin;
            List<Pinche> lista = new LinkedList<>();
            while (rs.next()) {
                pin = new Pinche(rs.getInt("id_pinche"));
                pin.setDni(rs.getInt("dni"));
                pin.setNombre(rs.getString("nombre"));
                pin.setApellido(rs.getString("apellido"));
                pin.setTel_fijo(rs.getInt("tel_fijo"));
                pin.setTel_movil(rs.getInt("tel_movil"));

                lista.add(pin);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean delete(int id_pinche) {
        String sql = "delete from pinches where id_pinche=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_pinche);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
