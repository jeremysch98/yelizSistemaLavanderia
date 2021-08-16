package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class UsuarioDAO extends Usuario{   
    private int vu,au,id;
    private String nomu;

    public UsuarioDAO() {
    }
    
    public int ValidarUsuario(){
        ConexionBD cn=new ConexionBD();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        try{
            con=cn.Conexion();
            String sql="select * from tb_usuarios where usuario='"+getUsuario()+"' and contraseña='"+getContraseña()+"'";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            if(rs.next()){
                vu=1;
            }else{
                JOptionPane.showMessageDialog(null, "Usuario y/o Contraseña incorrecta.", "¡Error!" ,JOptionPane.ERROR_MESSAGE);
                vu=0;
            }
        }catch(Exception e){
        }
        return vu;
    }
    
    public int AñadirUsuario(){
        ConexionBD cn=new ConexionBD();
        Connection con;
        PreparedStatement ps;
        
        try{
            con=cn.Conexion();
            String sql="insert into tb_usuarios(usuario,contraseña,nombres,apellidos) values('"+getUsuario()+"','"+getContraseña()+"','"+getNombres()+"','"+getApellidos()+"')";
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            au=1;
        }catch(Exception e){  
        }
        return au;
    }
    
    public String NombreUsuario(){
        ConexionBD cn=new ConexionBD();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        try{
            con=cn.Conexion();
            String sql="select nombres from tb_usuarios where usuario='"+getUsuario()+"'";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                nomu=rs.getString(1);
            }
        }catch(Exception e){  
        }
        return nomu;
    }
    
    public int IdUsuario(){
        ConexionBD cn=new ConexionBD();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        try{
            con=cn.Conexion();
            String sql="select idusuario from tb_usuarios where nombres='"+getNombres()+"'";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                id=rs.getInt(1);
            }
        }catch(Exception e){  
        }
        return id;
    }
}
