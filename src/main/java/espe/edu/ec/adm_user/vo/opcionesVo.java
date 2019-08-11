/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.vo;

import java.io.Serializable;

/**
 *
 * @author saintrec
 */
public class opcionesVo implements Serializable {

 private static final long serialVersionUID = 1L;
 private String opcion;
 private String url;
 private String icono;
 private String clase;
 private Integer crear;
 private Integer modificar;
 private Integer eliminar;

 public opcionesVo() {
 }

 public opcionesVo(String opcion, String url, String icono, String clase, Integer crear, Integer modificar, Integer eliminar) {
  this.opcion = opcion;
  this.url = url;
  this.icono = icono;
  this.clase = clase;
  this.crear = crear;
  this.modificar = modificar;
  this.eliminar = eliminar;
 }

 public String getOpcion() {
  return opcion;
 }

 public void setOpcion(String opcion) {
  this.opcion = opcion;
 }

 public String getIcono() {
  return icono;
 }

 public void setIcono(String icono) {
  this.icono = icono;
 }

 public String getUrl() {
  return url;
 }

 public void setUrl(String url) {
  this.url = url;
 }

 public String getClase() {
  return clase;
 }

 public void setClase(String clase) {
  this.clase = clase;
 }

 public Integer getCrear() {
  return crear;
 }

 public void setCrear(Integer crear) {
  this.crear = crear;
 }

 public Integer getModificar() {
  return modificar;
 }

 public void setModificar(Integer modificar) {
  this.modificar = modificar;
 }

 public Integer getEliminar() {
  return eliminar;
 }

 public void setEliminar(Integer eliminar) {
  this.eliminar = eliminar;
 }

}
