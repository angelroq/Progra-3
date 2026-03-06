/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author Angel R
 */
public class Jornadas {
    int JOR_Código;
    String JOR_Nombre;

    @Override
    public String toString() {
        return "Jornadas{" + "JOR_C\u00f3digo=" + JOR_Código + ", JOR_Nombre=" + JOR_Nombre + '}';
    }

    public int getJOR_Código() {
        return JOR_Código;
    }
    
    public void setJOR_Código(int JOR_Código) {
        this.JOR_Código = JOR_Código;
    }

    public String getJOR_Nombre() {
        return JOR_Nombre;
    }

    public void setJOR_Nombre(String JOR_Nombre) {
        this.JOR_Nombre = JOR_Nombre;
    }
    
    public Jornadas(){
        
    }
    public Jornadas(int JOR_Código, String JOR_Nombre){
        this.JOR_Código = JOR_Código;
        this.JOR_Nombre = JOR_Nombre;
    }
    public Jornadas(int JOR_Código){
        this.JOR_Código = JOR_Código;
    }
}
