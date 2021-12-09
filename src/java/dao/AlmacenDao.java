package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Almacen;

public class AlmacenDao {

    Conexion conn;

    public AlmacenDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insert(Almacen alm) {
        String sql = "insert into almacen values (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, alm.getId_almacen());
            ps.setString(2, alm.getAlmacen());
            ps.setInt(3, alm.getNumero());
            ps.setString(4, alm.getDescripcion());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean update(Almacen alm) {
        String sql = "update almacen set almacen=?, numero=?, descripcion=? where id_almacen=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, alm.getAlmacen());
            ps.setInt(2, alm.getNumero());
            ps.setString(3, alm.getDescripcion());
            ps.setInt(4, alm.getId_almacen());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<Almacen> selectAll() {
        String sql = "select * from almacen";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Almacen alm;
            List<Almacen> lista = new LinkedList<>();
            while (rs.next()) {
                alm = new Almacen(rs.getInt("id_almacen"));
                alm.setAlmacen(rs.getString("almacen"));
                alm.setNumero(rs.getInt("numero"));
                alm.setDescripcion(rs.getString("descripcion"));
                lista.add(alm);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Almacen> selectById(int id_almacen) {
        String sql = "select * from almacen where id_almacen = ?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_almacen);
            ResultSet rs = ps.executeQuery();
            Almacen alm;
            List<Almacen> lista = new LinkedList<>();
            while (rs.next()) {
                alm = new Almacen(rs.getInt("id_almacen"));
                alm.setAlmacen(rs.getString("almacen"));
                alm.setNumero(rs.getInt("numero"));
                alm.setDescripcion(rs.getString("descripcion"));
                lista.add(alm);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean delete(int id_almacen) {
        String sql = "delete from almacen where id_almacen=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_almacen);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
