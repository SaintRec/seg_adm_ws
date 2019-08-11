/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Labs-DCCO
 */
@Entity
@Table(name = "SEG_OPCION")
public class SegOpcion implements Serializable {

    private static final long serialVersionUID = 1L;

//    @SequenceGenerator(name = "SEQ_SEG_OPCION", sequenceName = "SEQ_SEG_OPCION", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEG_OPCION")
    @Basic(optional = false)
//    @NotNull
    @Id
    @Column(name = "OPC_ID")
    private Long opcId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "OPC_NOMBRE")
    private String opcNombre;

    @Basic(optional = false)
    @NotNull
    @Column(name = "OPC_NIVEL")
    private BigInteger opcNivel;

    @Basic(optional = false)
    @NotNull
    @Column(name = "OPC_ORDEN")
    private BigInteger opcOrden;

    @Size(max = 60)
    @Column(name = "OPC_IMAGEN")
    private String opcImagen;

    @Size(max = 128)
    @Column(name = "OPC_URL")
    private String opcUrl;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segOpcion")
//    private List<SegOpcPerfil> segOpcPerfilList;
//
//    @OneToMany(mappedBy = "segOpcion")
//    private List<SegOpcion> segOpcionList;

    @JoinColumn(name = "SIS_ID", referencedColumnName = "SIS_ID")
    @ManyToOne(optional = false)
    private SegSistemas segSistemas;

//    @JoinColumn(name = "SEG_OPC_ID", referencedColumnName = "OPC_ID")
//    @ManyToOne(optional = false)
//    private SegOpcion segOpcion;

    public SegOpcion() {
    }

    public Long getOpcId() {
        return opcId;
    }

    public void setOpcId(Long opcId) {
        this.opcId = opcId;
    }

    public String getOpcNombre() {
        return opcNombre;
    }

    public void setOpcNombre(String opcNombre) {
        this.opcNombre = opcNombre;
    }

    public BigInteger getOpcNivel() {
        return opcNivel;
    }

    public void setOpcNivel(BigInteger opcNivel) {
        this.opcNivel = opcNivel;
    }

    public BigInteger getOpcOrden() {
        return opcOrden;
    }

    public void setOpcOrden(BigInteger opcOrden) {
        this.opcOrden = opcOrden;
    }

    public String getOpcImagen() {
        return opcImagen;
    }

    public void setOpcImagen(String opcImagen) {
        this.opcImagen = opcImagen;
    }

    public String getOpcUrl() {
        return opcUrl;
    }

    public void setOpcUrl(String opcUrl) {
        this.opcUrl = opcUrl;
    }

    public SegSistemas getSegSistemas() {
        return segSistemas;
    }

    public void setSegSistemas(SegSistemas segSistemas) {
        this.segSistemas = segSistemas;
    }
//
//    public SegOpcion getSegOpcion() {
//        return segOpcion;
//    }
//
//    public void setSegOpcion(SegOpcion segOpcion) {
//        this.segOpcion = segOpcion;
//    }

}
