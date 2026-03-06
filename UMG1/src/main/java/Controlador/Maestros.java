/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author Angel R
 */
public class Maestros {

    // Atributos de la clase
    @Override
    public String toString() {
        return "Maestros{" + "MAE_C\u00f3digo=" + MAE_Código + ", MAE_Nombre=" + MAE_Nombre + ", MAE_Direcci\u00f3n=" + MAE_Dirección + ", MAE_Status=" + MAE_Status + '}';
    }
    int MAE_Código;
    String MAE_Nombre;
    String MAE_Dirección;
    String MAE_Status;

    public Maestros(int MAE_Código) {
        this.MAE_Código = MAE_Código;
    }

    public Maestros(int MAE_Código, String MAE_Nombre, String MAE_Dirección, String MAE_Status) {
        this.MAE_Código = MAE_Código;
        this.MAE_Nombre = MAE_Nombre;
        this.MAE_Dirección = MAE_Dirección;
        this.MAE_Status = MAE_Status;
    }

    public String getMAE_Nombre() {
        return MAE_Nombre;
    }

    public void setMAE_Nombre(String MAE_Nombre) {
        this.MAE_Nombre = MAE_Nombre;
    }

    public String getMAE_Dirección() {
        return MAE_Dirección;
    }

    public void setMAE_Dirección(String MAE_Dirección) {
        this.MAE_Dirección = MAE_Dirección;
    }

    public String getMAE_Status() {
        return MAE_Status;
    }

    public void setMAE_Status(String MAE_Status) {
        this.MAE_Status = MAE_Status;
    }

    public int getMAE_Código() {
        return MAE_Código;
    }

    public void setMAE_Código(int MAE_Código) {
        this.MAE_Código = MAE_Código;
    }
    
    public Maestros(){
        
    }

    //Devuelve una representación en cadena del objeto Maestros.

    
}

