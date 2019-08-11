/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author saintrec
 */
@Entity
//@Table(name = "SEG_OPCION", schema = "siseac")
@Table(name = "SEG_OPCION")
public class SegOpcion implements Serializable {

 private static final long serialVersionUID = 1L;

 @Id
 @Column(name = "OPC_ID")
 private Long opcId;

 @Column(name = "OPC_NOMBRE")
 private String opcNombre;

 @Column(name = "OPC_NIVEL")
 private BigInteger opcNivel;

 @Column(name = "OPC_ORDEN")
 private BigInteger opcOrden;

 @Column(name = "OPC_URL")
 private String opcUrl;

 @Column(name = "SIS_ID")
 private Long sisId;

 @Column(name = "OPC_IMAGEN")
 private String opcImagen;

 @Column(name = "OPC_ICONO")
 private String opcIcono;

 @Column(name = "OPC_CLASE")
 private String opcClase;

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

 public String getOpcUrl() {
  return opcUrl;
 }

 public void setOpcUrl(String opcUrl) {
  this.opcUrl = opcUrl;
 }

 public Long getSisId() {
  return sisId;
 }

 public void setSisId(Long sisId) {
  this.sisId = sisId;
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

}
