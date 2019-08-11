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
public class usuarioDataVo implements Serializable {

 private static final long serialVersionUID = 1L;

 private String usuNombres;

 private String usuApellidos;

 private Long spridenPidm;

 private String spridenId;

 private String usuCc;

 private String usuEmail;

 public usuarioDataVo() {
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

 public String getUsuCc() {
  return usuCc;
 }

 public void setUsuCc(String usuCc) {
  this.usuCc = usuCc;
 }

 public String getUsuEmail() {
  return usuEmail;
 }

 public void setUsuEmail(String usuEmail) {
  this.usuEmail = usuEmail;
 }

}
