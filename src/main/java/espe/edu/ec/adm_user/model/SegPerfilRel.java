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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author saintrec
 */
@Entity
@Table(name = "SEG_PERFIL")
public class SegPerfilRel implements Serializable {

 private static final long serialVersionUID = 1L;

 @SequenceGenerator(name = "SEQ_SEG_PERFIL", sequenceName = "SEQ_SEG_PERFIL", allocationSize = 1)
 @Id
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEG_PERFIL")
 @Basic(optional = false)
 @Column(name = "PER_ID")
 private Long perId;

 @Basic(optional = false)
 @NotNull
 @Size(min = 1, max = 60)
 @Column(name = "PER_NOMBRE")
 private String perNombre;

 @JoinColumn(name = "SIS_ID", referencedColumnName = "SIS_ID")
 @ManyToOne(optional = false)
 private SegSistemas segSistemas;

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

 public SegSistemas getSegSistemas() {
  return segSistemas;
 }

 public void setSegSistemas(SegSistemas segSistemas) {
  this.segSistemas = segSistemas;
 }

}
