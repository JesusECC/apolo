package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ANCAJIMA
 */
public class conexion {
    

    public String url="jdbc:mysql://cpwolves.com:3306/tuxczegz_concytec?useTimezone=true&serverTimezone=UTC";
    public String user="tuxczegz_alexis";
    public String pass="codiexp2018";

    public conexion() {
    }

public Connection conectar(){
    Connection link=null;
    try{
        Class.forName("org.gjt.mm.mysql.Driver");
        link=DriverManager.getConnection(this.url, this.user, this.pass);
    }catch(ClassNotFoundException | SQLException e){
        JOptionPane.showConfirmDialog(null, e);
    }
    return link;
}

}
