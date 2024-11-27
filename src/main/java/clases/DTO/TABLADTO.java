/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.DTO;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class TABLADTO {
    private String nombre;
    private ArrayList<CampoDTO> campos;

    public TABLADTO(String nombre, ArrayList<CampoDTO> campos) {
        this.nombre = nombre;
        this.campos = campos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<CampoDTO> getCampos() {
        return campos;
    }

    public void setCampos(ArrayList<CampoDTO> campos) {
        this.campos = campos;
    }
}
