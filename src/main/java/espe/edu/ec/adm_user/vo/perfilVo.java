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
public class perfilVo implements Serializable {

 private static final long serialVersionUID = 1L;

 private String perfil;

 private String sistema;

 private String url;

 public perfilVo(String perfil, String sistema, String url) {
  this.perfil = perfil;
  this.sistema = sistema;
  this.url = url;
 }

 public perfilVo() {
 }

 public String getPerfil() {
  return perfil;
 }

 public void setPerfil(String perfil) {
  this.perfil = perfil;
 }

 public String getSistema() {
  return sistema;
 }

 public void setSistema(String sistema) {
  this.sistema = sistema;
 }

 public String getUrl() {
  return url;
 }

 public void setUrl(String url) {
  this.url = url;
 }

}
