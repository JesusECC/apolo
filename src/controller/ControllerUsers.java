/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.users;

/**
 *
 * @author ANCAJIMA
 */
public class ControllerUsers {
    private conexion mysql = new conexion();
    private Connection cn= mysql.conectar();
    private String sSQL="";
    private String sSQL2="";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar(String buscar){
    DefaultTableModel modelo;
    String[] titulos  = {"ID","NAME","EMAIL","PASSWORD"};
    String[] registro= new String[4];
    totalregistros=0;
    modelo = new DefaultTableModel(null, titulos);
    
    sSQL = "select * users where email like '"+buscar+"%' order by id";
            
         try{
             Statement st= cn.createStatement();
             ResultSet rs= st.executeQuery(sSQL);
             while(rs.next()){
                 registro[0]= rs.getString("id");
                 registro[0]= rs.getString("name");
                 registro[0]= rs.getString("email");
                 registro[0]= rs.getString("password");
                 registro[0]= rs.getString("remember_toke");
                 registro[0]= rs.getString("created_at");
                 registro[0]= rs.getString("created_at");
                 totalregistros= totalregistros+1;
                 modelo.addRow(registro);
             }
             return modelo;
         }catch(Exception e){
             JOptionPane.showConfirmDialog(null, e);
             return null;
         }   
}
    
    public boolean insertar (users dts){
        sSQL="insert into users(name,email,password,remember_token,created_at,updated_at)"+
               "values (?,?,?,?,?,?)";
        
        try{
            PreparedStatement pst= cn.prepareStatement(sSQL);
            pst.setString(1,dts.getName());
            pst.setString(2,dts.getEmail());
            pst.setString(3,dts.getPassword());
             pst.setString(4,dts.getRemember_token());
            pst.setDate(5,dts.getCreated_at());
            pst.setDate(6,dts.getUpdate_at());
            
            int n=pst.executeUpdate();
            if(n!=0){
                return true;
            }else{
                return false;
            }
            
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
     public boolean editar (users dts){
     sSQL="update users set name=?,email=?,password=?,remember_token=?,created_at=?,updated_at=?"
             +"where id=?";
         
              try{
            PreparedStatement pst= cn.prepareStatement(sSQL);
            pst.setString(1,dts.getName());
            pst.setString(2,dts.getEmail());
            pst.setString(3,dts.getPassword());
             pst.setString(4,dts.getRemember_token());
            pst.setDate(5,dts.getCreated_at());
            pst.setDate(6,dts.getUpdate_at());
            pst.setInt(7,dts.getId());
            
            int n=pst.executeUpdate();
            if(n!=0){
                return true;
            }else{
                return false;
            }
            
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
     }
    
     
     public boolean eliminar (users dts){
         sSQL="delete from users where id=?";
         try{
          PreparedStatement pst= cn.prepareStatement(sSQL);

            pst.setInt(1,dts.getId());
            
            int n=pst.executeUpdate();
            if(n!=0){
                return true;
            }else{
                return false;
            }
         }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;  
         }
         
     }
}