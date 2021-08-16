package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PedidoDAO extends GPedido{
private int au,ce;

  public int AñadirPedido(){
        ConexionBD cn=new ConexionBD();
        Connection con;
        PreparedStatement ps;
        
        try{
            con=cn.Conexion();
            String sql="insert into tb_pedidos(codped,fecrecped,fecentped,estped,dni)"
                    + " values('"+getCodp()+"','"+getFechae()+"','"+getFechar()+"','"+getEstado()+"','"+getDni()+"')";
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            au=1;
        }catch(Exception e){  
        }
        return au;
    }
  
  public List<GPedido> LisPed(String dni) {
        List<GPedido> lis = new ArrayList<>();
        Connection conn = null;
        try {
            conn = ConexionBD.getConexion();
            String sql = "select codped, fecrecped,fecentped,estped from tb_pedidos where dni='"+dni+"'";
            PreparedStatement st = conn.prepareStatement(sql);
           
            ResultSet rs = st.executeQuery();
    
            while (rs.next()) {
            GPedido a= new GPedido();
                a.setCodp(rs.getString(1));
                a.setFechar(rs.getString(2));
                a.setFechae(rs.getString(3));
                a.setEstado(rs.getString(4));
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
  
    public int CambiarEstadoEnt(String codped){
        ConexionBD cn=new ConexionBD();
        Connection con;
        PreparedStatement ps;

        try{
        con=cn.Conexion();
            String sql="update tb_pedidos set estped='ENTREGADO' where codped='"+codped+"'";
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            ce=1;
            setCodp(codped);
        }catch(Exception e){  
        }
        return ce;
    }
    
    public int CambiarEstadoEnc(String codped){
        ConexionBD cn=new ConexionBD();
        Connection con;
        PreparedStatement ps;

        try{
        con=cn.Conexion();
            String sql="update tb_pedidos set estped='EN CURSO' where codped='"+codped+"'";
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            ce=1;
            setCodp(codped);
        }catch(Exception e){  
        }
        return ce;
    }
}
