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
@Table(name = "SEG_OPCION")
public class SegOpcionRel implements Serializable {

 private static final long serialVersionUID = 1L;

 @SequenceGenerator(name = "SEQ_SEG_OPCION", sequenceName = "SEQ_SEG_OPCION", allocationSize = 1)
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEG_OPCION")
 @Basic(optional = false)
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

 @Size(max = 128)
 @Column(name = "OPC_URL")
 @NotNull
 private String opcUrl;

 @Column(name = "OPC_IMAGEN")
 private String opcImagen;

 @Column(name = "OPC_ICONO")
 private String opcIcono;

 @Column(name = "OPC_CLASE")
 private String opcClase;

 @JoinColumn(name = "SIS_ID", referencedColumnName = "SIS_ID")
 @ManyToOne(optional = false)
 private SegSistemas segSistemas;

 public SegOpcionRel() {
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

 public String getOpcUrl() {
  return opcUrl;
 }

 public void setOpcUrl(String opcUrl) {
  this.opcUrl = opcUrl;
 }

 public String getOpcImagen() {
  return opcImagen;
 }

 public void setOpcImagen(String opcImagen) {
  this.opcImagen = opcImagen;
 }

 public String getOpcIcono() {
  return opcIcono;
 }

 public void setOpcIcono(String opcIcono) {
  this.opcIcono = opcIcono;
 }

 public String getOpcClase() {
  return opcClase;
 }

 public void setOpcClase(String opcClase) {
  this.opcClase = opcClase;
 }

 public SegSistemas getSegSistemas() {
  return segSistemas;
 }

 public void setSegSistemas(SegSistemas segSistemas) {
  this.segSistemas = segSistemas;
 }

}
