/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Labs-DCCO
 */
@Entity
@Table(name = "SEG_OPC_PERFIL")
public class SegOpcPerfil implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "OPP_ID")
    private Long oppId;

    @Basic(optional = false)
    @NotNull
    @Column(name = "OPP_ACT_INACT")
    private BigInteger oppActInact;

    @Column(name = "OPP_NUEVO")
    private BigInteger oppNuevo;

    @Column(name = "OPP_ELIMINAR")
    private BigInteger oppEliminar;

    @Column(name = "OPP_EDITAR")
    private BigInteger oppEditar;

    @Column(name = "OPP_IMPRIMIR")
    private BigInteger oppImprimir;

//    @JoinColumn(name = "PER_ID", referencedColumnName = "PER_ID")
//    @ManyToOne(optional = false)
//    private SegPerfil segPerfil;
//
//    @JoinColumn(name = "OPC_ID", referencedColumnName = "OPC_ID")
//    @ManyToOne(optional = false)
//    private SegOpcion segOpcion;

    public SegOpcPerfil() {
    }

    public Long getOppId() {
        return oppId;
    }

    public void setOppId(Long oppId) {
        this.oppId = oppId;
    }

    public BigInteger getOppActInact() {
        return oppActInact;
    }

    public void setOppActInact(BigInteger oppActInact) {
        this.oppActInact = oppActInact;
    }

    public BigInteger getOppNuevo() {
        return oppNuevo;
    }

    public void setOppNuevo(BigInteger oppNuevo) {
        this.oppNuevo = oppNuevo;
    }

    public BigInteger getOppEliminar() {
        return oppEliminar;
    }

    public void setOppEliminar(BigInteger oppEliminar) {
        this.oppEliminar = oppEliminar;
    }

    public BigInteger getOppEditar() {
        return oppEditar;
    }

    public void setOppEditar(BigInteger oppEditar) {
        this.oppEditar = oppEditar;
    }

    public BigInteger getOppImprimir() {
        return oppImprimir;
    }

    public void setOppImprimir(BigInteger oppImprimir) {
        this.oppImprimir = oppImprimir;
    }

}
