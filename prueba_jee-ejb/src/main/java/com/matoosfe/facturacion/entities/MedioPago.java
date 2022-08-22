/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matoosfe.facturacion.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author martosfre
 */
@Entity
@Table(name = "medio_pago")
@NamedQueries({
    @NamedQuery(name = "MedioPago.findAll", query = "SELECT m FROM MedioPago m"),
    @NamedQuery(name = "MedioPago.findByCodigoMedioPago", query = "SELECT m FROM MedioPago m WHERE m.codigoMedioPago = :codigoMedioPago"),
    @NamedQuery(name = "MedioPago.findByTipo", query = "SELECT m FROM MedioPago m WHERE m.tipo = :tipo"),
    @NamedQuery(name = "MedioPago.findByNombre", query = "SELECT m FROM MedioPago m WHERE m.nombre = :nombre")})
public class MedioPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_medio_pago")
    private Integer codigoMedioPago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "codigoMedioPago")
    private List<Factura> facturaList;

    public MedioPago() {
    }

    public MedioPago(Integer codigoMedioPago) {
        this.codigoMedioPago = codigoMedioPago;
    }

    public MedioPago(Integer codigoMedioPago, String tipo, String nombre) {
        this.codigoMedioPago = codigoMedioPago;
        this.tipo = tipo;
        this.nombre = nombre;
    }

    public Integer getCodigoMedioPago() {
        return codigoMedioPago;
    }

    public void setCodigoMedioPago(Integer codigoMedioPago) {
        this.codigoMedioPago = codigoMedioPago;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoMedioPago != null ? codigoMedioPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedioPago)) {
            return false;
        }
        MedioPago other = (MedioPago) object;
        if ((this.codigoMedioPago == null && other.codigoMedioPago != null) || (this.codigoMedioPago != null && !this.codigoMedioPago.equals(other.codigoMedioPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.matoosfe.facturacion.entities.MedioPago[ codigoMedioPago=" + codigoMedioPago + " ]";
    }
    
}
