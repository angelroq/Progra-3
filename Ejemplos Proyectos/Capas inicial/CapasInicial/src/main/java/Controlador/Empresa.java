/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author Soporte
 */
public class Empresa {
    private int CodigoEmpresa;
    private String NombreEmpresa;

    public Empresa(int CodigoEmpresa, String NombreEmpresa) {
        this.CodigoEmpresa = CodigoEmpresa;
        this.NombreEmpresa = NombreEmpresa;
    }

    public Empresa() {        
    }
    public Empresa(String NombreEmpresa) {
        this.NombreEmpresa = NombreEmpresa;
    }
    public Empresa(int CodigoEmpresa) {
        this.CodigoEmpresa = CodigoEmpresa;
    }

    public int getCodigoEmpresa() {
        return CodigoEmpresa;
    }

    public void setCodigoEmpresa(int CodigoEmpresa) {
        this.CodigoEmpresa = CodigoEmpresa;
    }

    public String getNombreEmpresa() {
        return NombreEmpresa;
    }

    public void setNombreEmpresa(String NombreEmpresa) {
        this.NombreEmpresa = NombreEmpresa;
    }

    @Override
    public String toString() {
        return "Empresa{" + "CodigoEmpresa=" + CodigoEmpresa + ", NombreEmpresa=" + NombreEmpresa + '}';
    }
    
}
