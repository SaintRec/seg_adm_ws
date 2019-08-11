/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author saintrec
 */
@Entity
@Table(name = "SEG_USU_PERFIL")
public class SegUsuPerfil implements Serializable {

 private static final long serialVersionUID = 1L;

 @SequenceGenerator(name = "SEQ_SEG_USU_PERFIL", sequenceName = "SEQ_SEG_USU_PERFIL", allocationSize = 1)
 @Id
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEG_USU_PERFIL")
 @Basic(optional = false)
 @Column(name = "USP_ID")
 private Long uspId;

 @Column(name = "PER_ID")
 @NotNull
 private Long perId;

 @Column(name = "USU_ID")
 @NotNull
 private Long usuId;

 @Column(name = "USP_FECHA_INI")
 @Temporal(TemporalType.TIMESTAMP)
 private Date uspFechaIni;

 @Column(name = "USP_FECHA_FIN")
 @Temporal(TemporalType.TIMESTAMP)
 private Date uspFechaFin;

 public SegUsuPerfil() {
 }

 public Long getUspId() {
  return uspId;
 }

 public void setUspId(Long uspId) {
  this.uspId = uspId;
 }

 public Long getPerId() {
  return perId;
 }

 public void setPerId(Long perId) {
  this.perId = perId;
 }

 public Long getUsuId() {
  return usuId;
 }

 public void setUsuId(Long usuId) {
  this.usuId = usuId;
 }

 public Date getUspFechaIni() {
  return uspFechaIni;
 }

 public void setUspFechaIni(Date uspFechaIni) {
  this.uspFechaIni = uspFechaIni;
 }

 public Date getUspFechaFin() {
  return uspFechaFin;
 }

 public void setUspFechaFin(Date uspFechaFin) {
  this.uspFechaFin = uspFechaFin;
 }

}
