package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Ingredientes;

public class IngredienteDao {

    Conexion conn;

    public IngredienteDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insert(Ingredientes ingd) {
        String sql = "insert into ingredientes values (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, ingd.getId_ingrediente());
            ps.setString(2, ingd.getIngrediente());
            ps.setString(3, ingd.getLetra());
            ps.setInt(4, ingd.getCantidad());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean update(Ingredientes ingd) {
        String sql = "update ingredientes set ingrediente=?, letra=?, cantidad=? where id_ingrediente=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, ingd.getIngrediente());
            ps.setString(2, ingd.getLetra());
            ps.setInt(3, ingd.getCantidad());
            ps.setInt(4, ingd.getId_ingrediente());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<Ingredientes> selectAll() {
        String sql = "select * from ingredientes";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Ingredientes ingd;
            List<Ingredientes> lista = new LinkedList<>();
            while (rs.next()) {
                ingd = new Ingredientes(rs.getInt("id_ingrediente"));
                ingd.setIngrediente(rs.getString("ingrediente"));
                ingd.setLetra(rs.getString("letra"));
                ingd.setCantidad(rs.getInt("cantidad"));
                lista.add(ingd);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("error: " + e);
            return null;
        }
    }

    public List<Ingredientes> selectById(int id_ingrediente) {
        String sql = "select * from ingredientes where id_ingrediente=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_ingrediente);
            ResultSet rs = ps.executeQuery();
            Ingredientes ingd;
            List<Ingredientes> lista = new LinkedList<>();
            while (rs.next()) {
                ingd = new Ingredientes(rs.getInt("id_ingrediente"));
                ingd.setIngrediente(rs.getString("ingrediente"));
                ingd.setLetra(rs.getString("letra"));
                ingd.setCantidad(rs.getInt("cantidad"));
                lista.add(ingd);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("error: " + e);
            return null;
        }
    }

    public boolean delete(int id_ingrediente) {
        String sql = "delete from ingredientes where id_ingrediente=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_ingrediente);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
