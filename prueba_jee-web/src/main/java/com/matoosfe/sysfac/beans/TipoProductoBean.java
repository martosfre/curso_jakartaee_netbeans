/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matoosfe.sysfac.beans;

import com.matoosfe.facturacion.controllers.TipoProductoFacade;
import com.matoosfe.facturacion.entities.TipoProducto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author martosfre
 */
@Named
@ViewScoped
public class TipoProductoBean implements Serializable{
    private List<TipoProducto> listaTipoProductos;
    
    @Inject
    private TipoProductoFacade adminTipoProducto;

    public TipoProductoBean() {
        this.listaTipoProductos = new ArrayList<>();
    }

    public List<TipoProducto> getListaTipoProductos() {
        return listaTipoProductos;
    }

    public void setListaTipoProductos(List<TipoProducto> listaTipoProductos) {
        this.listaTipoProductos = listaTipoProductos;
    }
    
    /**
     * Método para cargar los tipos de productos
     */
    private void cargarTipoProductos(){
        this.listaTipoProductos = adminTipoProducto.findAll();
    }
    
    @PostConstruct
    public void inicializar(){
        cargarTipoProductos();
    }
}
