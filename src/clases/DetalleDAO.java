package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import vistas.RegistrarPedido;

public class DetalleDAO extends DetallePedido{
    private int au;
    private double pretotal;
    List<DetallePedido> list = new ArrayList<>();
  
    public void deleteall(){
    list.clear();
    }
    public  String hoy(){
        Date t = new Date();
        DateFormat df1 = DateFormat.getDateInstance();

        return df1.format(t);
}
     public int AñadirArticulo(){
        ConexionBD cn=new ConexionBD();
        Connection con;
        PreparedStatement ps;
        
        try{
            con=cn.Conexion();
            String sql="insert into tb_articulos(desart,cantart,preart,subtotal,codped) "
                    + "values('"+getDescripcion()+"','"+getCantidad()+"','"+getPrecio()+
                    "','"+getSubtotal()+"','"+getCodped()+"')";
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            au=1;
        }catch(Exception e){  
        }
        return au;
    }
public List<DetallePedido> LisPedido(String id) {
        List<DetallePedido> lis = new ArrayList<>();
        Connection conn = null;
        try {
            conn = ConexionBD.getConexion();
            String sql = "select codart, desart,cantart,preart,subtotal from tb_articulos where codped='"+id+"'";
            PreparedStatement st = conn.prepareStatement(sql);
           
            ResultSet rs = st.executeQuery();
           
            while (rs.next()) {
                DetallePedido a = new DetallePedido();
                a.setCoda(rs.getInt(1));
                a.setDescripcion(rs.getString(2));
                a.setCantidad(rs.getInt(3));
                a.setPrecio(rs.getDouble(4));
                a.setSubtotal(rs.getDouble(5));
                lis.add(a);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }

        return lis;
  }
  public int Anula(String cod) {
       int resp = 0;
        Connection conn = null;
        try {
            String sql = "delete from tb_articulos where codart='"+cod+"'";
            conn = ConexionBD.getConexion();
  
            PreparedStatement st = conn.prepareStatement(sql);
            
            resp = st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
        return resp;
    }
public int AnulaAll(String cod) {
       int resp = 0;
        Connection conn = null;
        try {
            String sql = "delete from tb_articulos where codped='"+cod+"'";
            conn = ConexionBD.getConexion();  
            PreparedStatement st = conn.prepareStatement(sql);
            
            resp = st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
        return resp;
    }  
    
public int Cambia() {
    ConexionBD cn=new ConexionBD();
        Connection con;
        PreparedStatement ps;

        try{
        con=cn.Conexion();
            String sql="update tb_articulos set desart='"+getDescripcion()+"', cantart='"+getCantidad()+"', preart='"+getPrecio()+"' where codart='"+getCoda()+"'";
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            au=1;
             
        }catch(Exception e){  
        }
        return au;
           
    }
public List<DetallePedido> TraerDes() {
        List<DetallePedido> lis = new ArrayList<>();
        Connection conn = null;
        try {
            conn = ConexionBD.getConexion();
            String sql = "select desart from tb_detarti";
            PreparedStatement st = conn.prepareStatement(sql);
           
            ResultSet rs = st.executeQuery();
           
            while (rs.next()) {
                DetallePedido a = new DetallePedido();
              
                a.setDescripcion(rs.getString(1));
           
                lis.add(a);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }

        return lis;
  }
              
public int MostrarPrecio(String des){
        ConexionBD cn=new ConexionBD();
        Connection con;
        PreparedStatement ps;
   ResultSet rs;

 try{
            con=cn.Conexion();
            String sql="select preart from tb_detarti where desart='"+des+"'";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
           
                 while (rs.next()) {
             
                setPrecio(rs.getDouble(1));
                
                 }
             au=1;
        }catch(Exception e){  
}
 return au;
}
public List<DetallePedido> LisArtxPed(String cod) {
        List<DetallePedido> lis = new ArrayList<>();
        Connection conn = null;
        try {
            conn = ConexionBD.getConexion();
            String sql = "select codart,desart,cantart,preart from tb_articulos where codped='"+cod+"'";
            PreparedStatement st = conn.prepareStatement(sql);
           
            ResultSet rs = st.executeQuery();
         
            while (rs.next()) {
                DetallePedido a = new DetallePedido();
                a.setCoda(Integer.parseInt(rs.getString(1)));
                a.setDescripcion(rs.getString(2));
                a.setCantidad(rs.getInt(3));
                a.setPrecio(rs.getDouble(4));
                lis.add(a);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }

        return lis;
  }

    public double pretotal(){
        ConexionBD cn=new ConexionBD();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        try{
            con=cn.Conexion();
            String sql="select sum(subtotal) from tb_articulos where codped='"+getCodped()+"'";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                pretotal=rs.getDouble(1);               
            }
        }catch(Exception e){  
        }
        return pretotal;
    }
}
