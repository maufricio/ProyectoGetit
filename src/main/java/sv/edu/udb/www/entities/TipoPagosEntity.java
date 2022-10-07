package sv.edu.udb.www.entities;

import jakarta.persistence.*;

import java.util.Collection;

//Tabla trabajada!
@Entity
@Table(name = "tipo_pagos", schema = "getit")
public class TipoPagosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_tipoPago", nullable = false)
    private int idTipoPago;
    @Basic
    @Column(name = "tipo_pago", nullable = false, length = 30)
    private String tipoPago;

    //Para los pagos que han sido realizados con uno de estos tipos de pagos
    @OneToMany(mappedBy = "tipoPagosEntity")
    private Collection<PagosEntity> pagosByIdTipoPago;

    public int getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(int idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoPagosEntity that = (TipoPagosEntity) o;

        if (idTipoPago != that.idTipoPago) return false;
        if (tipoPago != null ? !tipoPago.equals(that.tipoPago) : that.tipoPago != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTipoPago;
        result = 31 * result + (tipoPago != null ? tipoPago.hashCode() : 0);
        return result;
    }

    public Collection<PagosEntity> getPagosByIdTipoPago() {
        return pagosByIdTipoPago;
    }

    public void setPagosByIdTipoPago(Collection<PagosEntity> pagosByIdTipoPago) {
        this.pagosByIdTipoPago = pagosByIdTipoPago;
    }
}
