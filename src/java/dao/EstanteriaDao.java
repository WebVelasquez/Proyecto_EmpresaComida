package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Almacen;
import modelo.Estanteria;

public class EstanteriaDao {

    Conexion conn;

    public EstanteriaDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insert(Estanteria estr) {
        String sql = "insert into estanteria values (?,?,?,?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, estr.getId_estanteria());
            ps.setString(2, estr.getEstante());
            ps.setString(3, estr.getTamaño());
            ps.setInt(4, estr.getId_almacen().getId_almacen());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
            return false;
        }
    }

    public boolean update(Estanteria estr) {
        String sql = "update estanteria set estante = ?, tamaño = ?, id_almacen = ? where id_estanteria= ?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            Almacen alm = estr.getId_almacen();
            ps.setString(1, estr.getEstante());
            ps.setString(2, estr.getTamaño());
            ps.setInt(3, alm.getId_almacen());
            ps.setInt(4, estr.getId_estanteria());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("ya hombe" + e);
            return false;
        }
    }

    public List<Estanteria> selectAll() {
        String sql = "select * from estanteria";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Estanteria estr;
            List<Estanteria> lista = new LinkedList<>();
            while (rs.next()) {
                Almacen alm = new Almacen(rs.getInt("id_almacen"));
                estr = new Estanteria(rs.getInt("id_estanteria"));
                estr.setEstante(rs.getString("estante"));
                estr.setTamaño(rs.getString("tamaño"));
                estr.setId_almacen(alm);
                lista.add(estr);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("error: " + e);

            return null;
        }
    }
    public List<Estanteria> selectById(int id) {
        String sql = "select * from estanteria where id_estanteria=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Estanteria estr;
            List<Estanteria> lista = new LinkedList<>();
            while (rs.next()) {
                Almacen alm = new Almacen(rs.getInt("id_almacen"));
                estr = new Estanteria(rs.getInt("id_estanteria"));
                estr.setEstante(rs.getString("estante"));
                estr.setTamaño(rs.getString("tamaño"));
                estr.setId_almacen(alm);
                lista.add(estr);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("error: " + e);

            return null;
        }
    }
    
    public boolean delete(int id_estanteria) {
            String sql = "delete from estanteria where id_estanteria = ?";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ps.setInt(1, id_estanteria);
                ps.executeUpdate();
                return true;
            } catch (Exception e) {
                return false;
            }
        }

}
