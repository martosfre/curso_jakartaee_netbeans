/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matoosfe.facturacion.controllers;

import com.matoosfe.facturacion.entities.Producto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author martosfre
 */
@Stateless
public class ProductoFacade extends AbstractFacade<Producto> {
    
    @PersistenceContext(unitName = "curso_jakartaee_pu")
    private EntityManager em;

    public ProductoFacade() {
        super(Producto.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
       return em;
    }
    
}
