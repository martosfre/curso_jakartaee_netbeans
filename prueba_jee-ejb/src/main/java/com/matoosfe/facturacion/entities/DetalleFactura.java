/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matoosfe.facturacion.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author martosfre
 */
@Entity
@Table(name = "detalle_factura")
@NamedQueries({
    @NamedQuery(name = "DetalleFactura.findAll", query = "SELECT d FROM DetalleFactura d"),
    @NamedQuery(name = "DetalleFactura.findByCodigoDetalle", query = "SELECT d FROM DetalleFactura d WHERE d.codigoDetalle = :codigoDetalle"),
    @NamedQuery(name = "DetalleFactura.findByCantidad", query = "SELECT d FROM DetalleFactura d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleFactura.findByValorUnitario", query = "SELECT d FROM DetalleFactura d WHERE d.valorUnitario = :valorUnitario"),
    @NamedQuery(name = "DetalleFactura.findByValorTotal", query = "SELECT d FROM DetalleFactura d WHERE d.valorTotal = :valorTotal")})
public class DetalleFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_detalle")
    private Integer codigoDetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_unitario")
    private BigDecimal valorUnitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_total")
    private BigDecimal valorTotal;
    @JoinColumn(name = "numero", referencedColumnName = "numero")
    @ManyToOne(optional = false)
    private Factura numero;
    @JoinColumn(name = "codigo_producto", referencedColumnName = "codigo_producto")
    @ManyToOne(optional = false)
    private Producto codigoProducto;

    public DetalleFactura() {
    }

    public DetalleFactura(Integer codigoDetalle) {
        this.codigoDetalle = codigoDetalle;
    }

    public DetalleFactura(Integer codigoDetalle, int cantidad, BigDecimal valorUnitario, BigDecimal valorTotal) {
        this.codigoDetalle = codigoDetalle;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
    }

    public Integer getCodigoDetalle() {
        return codigoDetalle;
    }

    public void setCodigoDetalle(Integer codigoDetalle) {
        this.codigoDetalle = codigoDetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Factura getNumero() {
        return numero;
    }

    public void setNumero(Factura numero) {
        this.numero = numero;
    }

    public Producto getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Producto codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoDetalle != null ? codigoDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFactura)) {
            return false;
        }
        DetalleFactura other = (DetalleFactura) object;
        if ((this.codigoDetalle == null && other.codigoDetalle != null) || (this.codigoDetalle != null && !this.codigoDetalle.equals(other.codigoDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.matoosfe.facturacion.entities.DetalleFactura[ codigoDetalle=" + codigoDetalle + " ]";
    }
    
}
