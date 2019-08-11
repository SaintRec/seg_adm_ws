/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author saintrec
 */
@Entity
@Table(name = "seg_sistemas")
public class SegSistemas implements Serializable {

    private static final long serialVersionUID = 0L;

    @SequenceGenerator(name = "SEQ_SEG_SISTEMAS", sequenceName = "SEQ_SEG_SISTEMAS", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEG_SISTEMAS")
    @Basic(optional = false)
//    @NotNull
    @Column(name = "SIS_ID")
    private Long sisId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "SIS_NOMBRE")
    private String sisNombre;

    @Size(max = 255)
    @NotNull
    @Column(name = "SIS_URL_SISTEMA")
    private String sisUrlSistema;

    @Column(name = "sis_estado")
    private Boolean sisEstado;
    
    public SegSistemas() {
    	sisEstado=true;
    }

    public SegSistemas(Long sisId, String sisNombre, String sisUrlSistema, Boolean sisEstado) {
        this.sisId = sisId;
        this.sisNombre = sisNombre;
        this.sisUrlSistema = sisUrlSistema;
        this.sisEstado = sisEstado;
    }

    public Long getSisId() {
        return sisId;
    }

    public void setSisId(Long sisId) {
        this.sisId = sisId;
    }

    public String getSisNombre() {
        return sisNombre;
    }

    public void setSisNombre(String sisNombre) {
        this.sisNombre = sisNombre;
    }

    public String getSisUrlSistema() {
        return sisUrlSistema;
    }

    public void setSisUrlSistema(String sisUrlSistema) {
        this.sisUrlSistema = sisUrlSistema;
    }

    public Boolean getSisEstado() {
        return sisEstado;
    }

    public void setSisEstado(Boolean sisEstado) {
        this.sisEstado = sisEstado;
    }
}
