
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmpleadoDao {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Empleado validar(String usser, String dni){
        Empleado em=new Empleado();
            String sql="select * from empleado where USSER=? and DNI=?";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, usser);
            ps.setString(2, dni);
            rs=ps.executeQuery();
            while(rs.next()){
                em.setId(rs.getInt("idempleado"));
                em.setUsser(rs.getString("usser"));
                em.setDni(rs.getString("dni"));
                em.setNom(rs.getString("nombres"));
            }
        } catch(Exception e){
            
        }
        return em;
    }
    public List listar(){
        String sql="select * from empleado";
        List<Empleado>lista=new ArrayList<>();
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Empleado em=new Empleado();
                em.setId(rs.getInt(1));
                em.setDni(rs.getNString(2));
                em.setNom(rs.getString(3));
                em.setTel(rs.getString(4));
                em.setEstado(rs.getString(5));
                em.setUsser(rs.getString(6));
                lista.add(em);
            }
        }catch(Exception e){
        }
        return lista;
    }
    
    public int agregar(Empleado em){
        String sql="insert into empleado(DNI, NOMBRE, TELEFONO, ESTADO,USSER)value(?,?,?,?,?)";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUsser());
            ps.executeUpdate();

        }catch (Exception e){
            
        }
        return r;
    }
    public Empleado listarId(int id){
        Empleado emp=new Empleado();
        String sql="select * from empleado where IDEMPLEADO"+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                emp.setDni(rs.getString(2));
                emp.setNom(rs.getString(3));
                emp.setTel(rs.getString(4));
                emp.setEstado(rs.getString(5));
                emp.setUsser(rs.getString(6));
            }
        } catch (Exception e) {
        }
        return emp;
    }
    
    public int actualizar(Empleado em){
        String sql="update empleado set DNI=?, NOMBRE=?, TELEFONO=?, ESTADO=?,USSER=? where IDEMPLEADO=?";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUsser());
            ps.setInt(6, em.getId());
            ps.executeUpdate();

        }catch (Exception e){
            
        }
        return r;
    }
    
    
    public void delete (int id){
        String sql="delete from empelado where IDEMPLEADO"+id;

            try{
                con=cn.Conexion();
                ps=con.prepareStatement(sql);
                ps.executeUpdate();
                



            }catch(Exception e){
            }
}
}
