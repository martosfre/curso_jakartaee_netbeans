/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matoosfe.sysfac.beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author martosfre
 */
@Named
@SessionScoped
public class LoginBean implements Serializable {

    private String nombreUsu;
    private String claveUsu;

    public LoginBean() {
    }

    public String getNombreUsu() {
        return nombreUsu;
    }

    public void setNombreUsu(String nombreUsu) {
        this.nombreUsu = nombreUsu;
    }

    public String getClaveUsu() {
        return claveUsu;
    }

    public void setClaveUsu(String claveUsu) {
        this.claveUsu = claveUsu;
    }

    /**
     * Método para validar las credenciales del usuario
     * @throws Exception 
     */
    public void validarUsuario() throws Exception {
        try {
            if (nombreUsu.equals("mtoscano") && claveUsu.equals("1234")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("./pages/principal.mat");
            } else {
                FacesContext.getCurrentInstance().getExternalContext().redirect("./403.mat");
            }
        } catch (Exception e) {
           throw new Exception("Error del Servidor:" + e.getMessage());
        }
    }
}
