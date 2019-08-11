/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author saintrec
 */
@Entity
@Table(name = "SEG_PERFIL")
public class SegPerfil implements Serializable {

 private static final long serialVersionUID = 1L;

 @Id
 @Column(name = "PER_ID")
 private Long perId;

 @Column(name = "PER_NOMBRE")
 private String perNombre;

 @Column(name = "SIS_ID")
 private Long sisId;

 public SegPerfil() {
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
