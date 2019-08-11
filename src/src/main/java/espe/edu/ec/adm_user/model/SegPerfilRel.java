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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Labs-DCCO
 */
@Entity
@Table(name = "SEG_PERFIL")
public class SegPerfilRel implements Serializable {

    private static final long serialVersionUID = 1L;

//    @SequenceGenerator(name = "SEQ_SEG_PERFIL", sequenceName = "SEQ_SEG_PERFIL", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEG_PERFIL")
    @Basic(optional = false)
    @NotNull
    @Column(name = "PER_ID")
    private Long perId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "PER_NOMBRE")
    private String perNombre;

    @Column(name = "SIS_ID")
    private Long sisId;

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "segPerfil")
//    @OneToMany(mappedBy = "segPerfil", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<SegOpcPerfil> segOpcPerfilList;
    //@OneToMany(mappedBy = "SegPerfil")
//    @OneToMany(mappedBy = "segPerfil", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<SegUsuPerfil> segUsuPerfilList;
//    public final static String PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION = "ADMINISTRADOR DE VINCULACION";
//    public final static String PERFIL_VINCULACION_COORDINADOR_VINCULACION = "COORDINADOR DE VINCULACION";
//    public final static String PERFIL_VINCULACION_DIRECTOR_PROGRAMA = "DIRECTOR DE PROGRAMA";
//    public final static String PERFIL_VINCULACION_DIRECTOR_PROYECTO = "DIRECTOR DE PROYECTO";
//    public final static String PERFIL_VINCULACION_DIRECTOR_DEPARTAMENTO = "DIRECTOR DE DEPARTAMENTO";
//    public final static String PERFIL_VINCULACION_EVALUADOR_UNIDAD_VINCULACION = "EVALUADOR UNIDAD VINCULACION";
//    public final static String PERFIL_VINCULACION_EVALUADOR_VICERRECTORADO = "VICERRECTOR IITT";
//    public final static String PERFIL_VINCULACION_EVALUADOR_FINAL_PROYECTO = "EVALUADOR FINAL DE PROYECTO";
//    public final static String PERFIL_VINCULACION_EVALUADOR_FINAL_PROGRAMA = "EVALUADOR FINAL DE PROGRAMA";
    public SegPerfilRel() {
    }

    public Long getPerId() {
        return perId;
    }

    public void setPerId(Long perId) {
        this.perId = perId;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    public Long getSisId() {
        return sisId;
    }

    public void setSisId(Long sisId) {
        this.sisId = sisId;
    }

}
