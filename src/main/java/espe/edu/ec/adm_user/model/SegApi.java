/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.model;

import espe.edu.ec.adm_user.vo.opcionesVo;
import espe.edu.ec.adm_user.vo.perfilVo;
import espe.edu.ec.adm_user.vo.usuarioVo;
import java.util.List;

/**
 *
 * @author saintrec
 */
public class SegApi {

 private usuarioVo Usuario;

 private List<perfilVo> Perfil;

 private List<opcionesVo> Opciones;

 public SegApi() {
 }

 public usuarioVo getUsuario() {
  return Usuario;
 }

 public void setUsuario(usuarioVo Usuario) {
  this.Usuario = Usuario;
 }

 public List<perfilVo> getPerfil() {
  return Perfil;
 }

 public void setPerfil(List<perfilVo> Perfil) {
  this.Perfil = Perfil;
 }

 public List<opcionesVo> getOpciones() {
  return Opciones;
 }

 public void setOpciones(List<opcionesVo> Opciones) {
  this.Opciones = Opciones;
 }

}
