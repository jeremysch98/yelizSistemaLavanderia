package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ClienteDAO extends Cliente{
    private int bc,rc,dc,au;

    public ClienteDAO() {
    }
    
    public int BuscarCliente(){
        ConexionBD cn=new ConexionBD();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        try{
            con=cn.Conexion();
            String sql="select * from tb_clientes where dni="+getDni()+"";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            if(rs.next()){               
                bc=1;
            }else{
                JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
                bc=0;
            }
        }catch(Exception e){  
        }
        return bc;
    }
    
    public int RegistrarCliente(){
        ConexionBD cn=new ConexionBD();
        Connection con;
        PreparedStatement ps;
        
        try{
            con=cn.Conexion();
            String sql="insert into tb_clientes(dni,nomcli,apecli,dircli,emailcli,telcli)"
                    + " values('"+getDni()+"','"+getNom()+"','"+getApe()+"','"+getDir()+"','"+getEmail()+"','"+getTel()+"')";
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            rc=1;
        }catch(Exception e){            
        }
        return rc;
    }
    
    public int DatosCliente(){
        ConexionBD cn=new ConexionBD();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        try{
            con=cn.Conexion();
            String sql="select * from tb_clientes where dni="+getDni()+"";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                setDni(Integer.parseInt(rs.getString(1)));
                setNom(rs.getString(2));
                setApe(rs.getString(3));
                setDir(rs.getString(4));
                setEmail(rs.getString(5));
                setTel(Integer.parseInt(rs.getString(6)));
            }
            dc=1;
        }catch(Exception e){  
        }
        return dc;
    }
    
}
