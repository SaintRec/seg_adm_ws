/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.model;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.validation.constraints.Size;

/**
 *
 * @author saintrec
 */
@Entity
@Table(name = "SEG_USUARIO")
public class SegUsuario implements Serializable {

 private static final long serialVersionUID = 1L;

 @SequenceGenerator(name = "SEQ_SEG_USUARIO", sequenceName = "SEQ_SEG_USUARIO", allocationSize = 1)
 @Id
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEG_USUARIO")
 @Basic(optional = false)
 @Column(name = "USU_ID")
 private Long usuId;

 @Basic(optional = false)
 @Size(min = 1, max = 20)
 @NotNull
 @Column(name = "USU_CC")
 private String usuCc;

 @Basic(optional = false)
 @Size(min = 1, max = 100)
 @NotNull
 @Column(name = "USU_CLAVE")
 private String usuClave;

 @Basic(optional = false)
 @Size(min = 1, max = 60)
 @NotNull
 @Column(name = "USU_NOMBRES")
 private String usuNombres;

 @Basic(optional = false)
 @Size(min = 1, max = 60)
 @NotNull
 @Column(name = "USU_APELLIDOS")
 private String usuApellidos;

 @Size(max = 100)
 @Column(name = "USU_EMAIL")
 @NotNull
 private String usuEmail;

 @Column(name = "USU_FECHAREGISTRO")
 @NotNull
 @Temporal(TemporalType.TIMESTAMP)
 private Date usuFecharegistro;

 @Size(max = 1)
 @Column(name = "USU_ESTADO")
 private String usuEstado;

 @Column(name = "USU_MAIL_SINFORMUL")
 private BigInteger usuMailSinformul;

 @Column(name = "USU_MAIL_INCOMPLETOS")
 private BigInteger usuMailIncompletos;

 @Column(name = "SPRIDEN_PIDM")
 @NotNull
 private Long spridenPidm;

 @Column(name = "SPRIDEN_ID")
 @NotNull
 private String spridenId;

 public SegUsuario() {
 }

 public Long getUsuId() {
  return usuId;
 }

 public void setUsuId(Long usuId) {
  this.usuId = usuId;
 }

 public String getUsuCc() {
  return usuCc;
 }

 public void setUsuCc(String usuCc) {
  this.usuCc = usuCc;
 }

 public String getUsuClave() {
  return usuClave;
 }

 public void setUsuClave(String usuClave) {
  this.usuClave = usuClave;
 }

 public String getUsuNombres() {
  return usuNombres;
 }

 public void setUsuNombres(String usuNombres) {
  this.usuNombres = usuNombres;
 }

 public String getUsuApellidos() {
  return usuApellidos;
 }

 public void setUsuApellidos(String usuApellidos) {
  this.usuApellidos = usuApellidos;
 }

 public String getUsuEmail() {
  return usuEmail;
 }

 public void setUsuEmail(String usuEmail) {
  this.usuEmail = usuEmail;
 }

 public Date getUsuFecharegistro() {
  return usuFecharegistro;
 }

 public void setUsuFecharegistro(Date usuFecharegistro) {
  this.usuFecharegistro = usuFecharegistro;
 }

 public String getUsuEstado() {
  return usuEstado;
 }

 public void setUsuEstado(String usuEstado) {
  this.usuEstado = usuEstado;
 }

 public BigInteger getUsuMailSinformul() {
  return usuMailSinformul;
 }

 public void setUsuMailSinformul(BigInteger usuMailSinformul) {
  this.usuMailSinformul = usuMailSinformul;
 }

 public BigInteger getUsuMailIncompletos() {
  return usuMailIncompletos;
 }

 public void setUsuMailIncompletos(BigInteger usuMailIncompletos) {
  this.usuMailIncompletos = usuMailIncompletos;
 }

 public Long getSpridenPidm() {
  return spridenPidm;
 }

 public void setSpridenPidm(Long spridenPidm) {
  this.spridenPidm = spridenPidm;
 }

 public String getSpridenId() {
  return spridenId;
 }

 public void setSpridenId(String spridenId) {
  this.spridenId = spridenId;
 }

}
