package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Plato;

public class PlatoDao {

    Conexion conn;

    public PlatoDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insert(Plato plt) {
        String sql = "insert into plato values (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, plt.getId_plato());
            ps.setString(2, plt.getPlatos());
            ps.setString(3, plt.getTipo());
            ps.setDouble(4, plt.getPrecio());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean update(Plato plt) {
        String sql = "update plato set platos=? , tipo=?, precio=? where id_plato=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, plt.getPlatos());
            ps.setString(2, plt.getTipo());
            ps.setDouble(3, plt.getPrecio());
            ps.setInt(4, plt.getId_plato());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
     public List<Plato> selectAll(){
        String sql="select * from plato";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Plato plt;
            List<Plato> lista = new LinkedList<>();
            while(rs.next()){
                plt = new Plato(rs.getInt("id_plato"));
                plt.setPlatos(rs.getString("platos"));
                plt.setTipo(rs.getString("tipo"));
                plt.setPrecio(rs.getDouble("precio"));
                lista.add(plt);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
     
     public List<Plato> selectById(int id_plato){
        String sql="select * from plato where id_plato=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_plato);
            ResultSet rs = ps.executeQuery();
            Plato plt;
            List<Plato> lista = new LinkedList<>();
            while(rs.next()){
                plt = new Plato(rs.getInt("id_plato"));
                plt.setPlatos(rs.getString("platos"));
                plt.setTipo(rs.getString("tipo"));
                plt.setPrecio(rs.getDouble("precio"));
                lista.add(plt);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
     
      public boolean delete(int id_plato) {
        String sql = "delete from plato where id_plato=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_plato);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
