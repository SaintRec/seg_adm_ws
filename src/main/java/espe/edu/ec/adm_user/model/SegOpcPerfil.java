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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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

 @SequenceGenerator(name = "SEQ_SEG_OPCION_PERFIL", sequenceName = "SEQ_SEG_OPCION_PERFIL", allocationSize = 1)
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEG_OPCION_PERFIL")
 @Id
 @Basic(optional = false)
 @Column(name = "OPP_ID")
 private Long oppId;

 @Basic(optional = false)
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

 @Column(name = "PER_ID")
 @NotNull
 private Long perId;

 @Column(name = "OPC_ID")
 @NotNull
 private Long opcId;

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

 public Long getPerId() {
  return perId;
 }

 public void setPerId(Long perId) {
  this.perId = perId;
 }

 public Long getOpcId() {
  return opcId;
 }

 public void setOpcId(Long opcId) {
  this.opcId = opcId;
 }

}
