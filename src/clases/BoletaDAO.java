package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class BoletaDAO extends Boleta{
    private int par;
    
    public int AñadirBoleta(){
        ConexionBD cn=new ConexionBD();
        Connection con;
        PreparedStatement ps;
        try{
            con=cn.Conexion();
            String sql="insert into tb_boletas(codbol,fecemi,pretotal,idusuario,codped) "
                    + "values('"+getCodbol()+"','"+getFecemi()+"',"+getPretotal()+","+getIdusuario()+",'"+getCodped()+"')";
            ps=con.prepareStatement(sql);
            ps.executeQuery();
            par=1;
        }catch(Exception e){
        }
        return par;
    }
    
    public int GenCodBoleta(){
        ConexionBD cn=new ConexionBD();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        
        try{
            con=cn.Conexion();
            String sql="exec generar_codbol";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
           
            while (rs.next()) {
                setCodbol(rs.getString(1));
                par=1;
            }
            
        }catch(Exception e){        
        }
        return par;
    }    
}
