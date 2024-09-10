
package clases;

import java.sql.*;

public class Conexion {
    
    Connection cn;
    PreparedStatement ps;
    
    public Conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:5151/login", "root", "Batcountry2005");
            System.out.println("Conectado a la base de datos");
        } catch (Exception e) {
            System.out.println("Error al conectarse a la base de datos");
        } 
    }
    
    public int Reusuario(String Nombre, String Edad, String email, String Clave, int id) {
        int res = 0;
        try {
            ps = cn.prepareStatement("INSERT INTO Usuario (Nombre, Edad, email, Clave, id) Values (?, ?, ?, ?, ?)");
            ps.setString(1, Nombre);
            ps.setString(2, Edad);
            ps.setString(3, email);
            ps.setString(4, Clave);
            ps.setInt(5, id);           
            res = ps.executeUpdate();
            System.out.println("Usuario registrado correctamente");
        } catch (Exception e) {
            System.out.println("Error al registrar usuario");
        } 
        
        return res;
    }
    
   public ResultSet Miusuario() {
        ResultSet rs = null;
        try {
            ps = cn.prepareStatement("SELECT * FROM Usuario");
            rs = ps.executeQuery();
        } catch (Exception e) {
            System.out.println("Error al obtener usuarios");
        }
        return rs;
    }


    
    public int Acusuario (int id, String Nombre, String Edad, String email, String Clave){
        int res = 0;
        try {
            ps = cn.prepareStatement("UPDATE Usuario SET Nombre = ?, Edad = ?, email = ?, Clave = ? WHERE id = ?");
            ps.setString(1, Nombre);
            ps.setString(2, Edad);
            ps.setString(3, email);
            ps.setString(4, Clave);
            ps.setInt(5, id);
            res = ps.executeUpdate();
            System.out.println("Usuario actualizado correctamente");
        } catch (Exception e) {
            System.out.println("Error al actualizar el usuario");
        } 
        
        return res;
            
            
        }
    
       public int Elusuario (int id){
        int res = 0;
        try {
            ps = cn.prepareStatement("DELETE FROM Usuario WHERE id = ?");
            ps.setInt(1, id);
            res = ps.executeUpdate();
            System.out.println("Usuario eliminado correctamente");
        } catch (Exception e) {
            System.out.println("Error al eliminar el usuario");
        } 
        
        return res;
            
            
        }

    }

    