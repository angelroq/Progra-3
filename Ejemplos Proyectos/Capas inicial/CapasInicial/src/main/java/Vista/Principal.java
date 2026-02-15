/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Empresa;
import Modelo.EmpresaDAO;
import java.util.List;

/**
 *
 * @author Soporte
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       //*INSERT*
       Empresa empresa = new Empresa("Universidad Mariano Gálvez");
       System.out.println(empresa.toString());
       EmpresaDAO empresadao = new EmpresaDAO();
       empresadao.insert(empresa);
        
       //*QUERY*
       Empresa empresa1= new Empresa();
       EmpresaDAO empresadao1 = new EmpresaDAO();
       empresadao1.query(empresa1);
       empresa1.setCodigoEmpresa(3);
       empresa1=empresadao1.query(empresa1);
       System.out.println(empresa1.toString());
       
       //*UPDATE*
       Empresa empresa2 = new Empresa(1,"granjero");
       EmpresaDAO empresadao2 = new EmpresaDAO();
       empresadao2.update(empresa2);
       System.out.println(empresa2.toString());
       
       //*DELETE*
       Empresa empresa3= new Empresa(1);
       EmpresaDAO empresadao3= new EmpresaDAO();
       empresadao3.delete(empresa3);
       System.out.println(empresa3.toString());
        
       //*SELECT*
       Empresa empresa4 = new Empresa();
       EmpresaDAO empresadao4 = new EmpresaDAO();
       List<Empresa> empresas = empresadao4.select();
       for (Empresa lista : empresas) {
       System.out.println(lista.toString());
}
       
        
    }
    
}
