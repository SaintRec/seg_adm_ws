/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.controller;

import espe.edu.ec.adm_user.dao.SegUsuPerfilRepository;
import espe.edu.ec.adm_user.dao.SegUsuPerfilRepositoryRel;
import espe.edu.ec.adm_user.dao.SegUsuarioRepository;
import espe.edu.ec.adm_user.model.SegUsuPerfil;
import espe.edu.ec.adm_user.model.SegUsuPerfilRel;
import espe.edu.ec.adm_user.model.SegUsuario;
import espe.edu.ec.adm_user.util.segMessage;
import espe.edu.ec.adm_user.vo.SegApiVo;
import espe.edu.ec.adm_user.vo.perfilVo;
import espe.edu.ec.adm_user.vo.usuarioDataVo;
import java.sql.SQLException;

import java.util.List;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author saintrec
 */
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/adm")
public class SegUsuPerfilRest {

 @Autowired
 private SegUsuPerfilRepository usuperfilRep;

 @Autowired
 private SegUsuPerfilRepositoryRel usuperfilRepRel;

 @Autowired
 private SegUsuarioRepository usuarioRep;

 @Autowired
 private SegApiVo usuarioOpc;

 private final segMessage msg = new segMessage();

//  //    Funcion Listar UsuarioPerfil
//  @RequestMapping(value = "/segup", method = RequestMethod.GET)
//  public ResponseEntity<SegUsuPerfil> listarUsuPer() {
//    List<SegUsuPerfil> usuarioperfil = usuperfilRep.findallUsuPerfil();
//    if (usuarioperfil.isEmpty()) {
////      logger.info("No se encontraron resultados");
//      return new ResponseEntity(msg.notfound(), HttpStatus.OK);
//    } else {
////      logger.info("Lista: UsuariosPerfil");
//      return new ResponseEntity(usuarioperfil, HttpStatus.OK);
//    }
//  }
 //    Funcion Busqueda de un Perfil y Usuario
//  @RequestMapping(value = "/segup/{usuId}/{perId}", method = RequestMethod.GET)
//  public ResponseEntity<SegUsuPerfil> userperfil(@PathVariable Long usuId, @PathVariable Long perId) {
////    logger.info("ELiminar UsuarioPerfil usuID {} y perfil {}", usuId, perId);
//    SegUsuPerfil usuarioperfil = usuperfilRep.findByPerIdAndUsuId(usuId, perId);
////    return new ResponseEntity(usuarioperfil, HttpStatus.OK);
//    if (usuarioperfil == null) {
////      logger.info("No se encontraron resultados");
//      return new ResponseEntity(msg.notfound(), HttpStatus.OK);
//    } else {
////      logger.info("Lista: UsuariosPerfil");
//      return new ResponseEntity(usuarioperfil, HttpStatus.OK);
//    }
//  }
 
 //    Funcion buscar usuarios de un sistema
 @RequestMapping(value = "/segus/{id}", method = RequestMethod.GET)
 public ResponseEntity usuariosBysisId(@PathVariable String id) throws SQLException {
  String slt = "select DISTINCT spriden_pidm as spridenPidm, u.usu_id as usuId ,usu_nombres as usuNombres, usu_apellidos as usuApellidos, usu_cc as usuCc, spriden_id as spridenId";
  String wr = " where s.sis_id=" + id;
  List<usuarioDataVo> userp = usuarioOpc.getUsuario(slt, wr);
  if (userp.isEmpty()) {
   return new ResponseEntity(msg.notfound(), HttpStatus.OK);
  } else {
   return new ResponseEntity(userp, HttpStatus.OK);
  }
 }

  //    Funcion buscar usuarios de un sistema por el Perfil
 @RequestMapping(value = "/segup/{id}", method = RequestMethod.GET)
 public ResponseEntity usuariosByperId(@PathVariable String id) throws SQLException {
  String slt = "select DISTINCT spriden_pidm as spridenPidm, u.usu_id as usuId ,usu_nombres as usuNombres, usu_apellidos as usuApellidos, usu_cc as usuCc, spriden_id as spridenId";
  String wr = " where p.per_id=" + id;
  List<usuarioDataVo> userp = usuarioOpc.getUsuario(slt, wr);
  if (userp.isEmpty()) {
   return new ResponseEntity(msg.notfound(), HttpStatus.OK);
  } else {
   return new ResponseEntity(userp, HttpStatus.OK);
  }
 }
 
 //    Funcion buscar perfiles de un usuario
 @RequestMapping(value = "/segpu/{id}", method = RequestMethod.GET)
 public ResponseEntity perfilesByusuarioId(@PathVariable long id) {
  SegUsuario usu = usuarioRep.findUserByusuId(id);
  List< SegUsuPerfilRel> perfilS = usuperfilRepRel.findByusuario(usu);
  if (perfilS.isEmpty()) {
   return new ResponseEntity(msg.notfound(), HttpStatus.OK);
  } else {
   return new ResponseEntity(perfilS, HttpStatus.OK);
  }
 }

 //    Funcion buscar perfiles de un usuario en un sistema
 @RequestMapping(value = "/segus/{usuId}/{sisId}", method = RequestMethod.GET)
 public ResponseEntity perfilesByusuIdandsisId(@PathVariable String usuId, @PathVariable String sisId) throws SQLException {
  String slt = "SELECT per_nombre as perfil, sis_nombre as sistema, sis_url_sistema url";
  String wr = " where s.sis_id=" + sisId + " and u.usu_Id=" + usuId;
  List<perfilVo> userp = usuarioOpc.getPerfil(slt, wr);
  if (userp.isEmpty()) {
   return new ResponseEntity(msg.notfound(), HttpStatus.OK);
  } else {
   return new ResponseEntity(userp, HttpStatus.OK);
  }
 }

 //    Funcion buscar sistemas de un usuario por cedula
 @RequestMapping(value = "/segsu/{usuCc}", method = RequestMethod.GET)
 public ResponseEntity sistemasByusuCc(@PathVariable String usuCc) throws SQLException {
  SegUsuario usuario = usuarioRep.findUserByusuCc(usuCc);
  if (usuario == null) {
   return new ResponseEntity(msg.notfound(), HttpStatus.OK);
  } else {
   String slt = "SELECT DISTINCT sis_nombre as sistema, sis_url_sistema url";
   String wr = " where u.usu_Id=" + usuario.getUsuId();
   List<perfilVo> userp = usuarioOpc.getPerfil(slt, wr);
   if (userp.isEmpty()) {
    return new ResponseEntity(msg.notfound(), HttpStatus.OK);
   } else {
    return new ResponseEntity(userp, HttpStatus.OK);
   }
  }
 }

 //    Funcion asignar un UsuarioPerfil
 @RequestMapping(value = "/segup", method = RequestMethod.POST)
 public ResponseEntity<SegUsuPerfil> crearUsuPer(@Valid @RequestBody List<SegUsuPerfil> usuper) {
  usuperfilRep.saveAll(usuper);
  return new ResponseEntity(msg.add(), HttpStatus.CREATED);
 }

 //    Funcion Actualizar un UsuarioPerfil
 @RequestMapping(value = "/segup", method = RequestMethod.PUT)
 public ResponseEntity<SegUsuPerfil> actualizarUsuPer(@Valid @RequestBody SegUsuPerfil usuperA) {
  usuperfilRep.save(usuperA);
  return new ResponseEntity(msg.update(), HttpStatus.OK);
 }

 //    Funcion Eliminar un UsuarioPerfil
 @RequestMapping(value = "/segup/{id}", method = RequestMethod.DELETE)
 public ResponseEntity<SegUsuPerfil> eliminarUsuPer(@PathVariable long id) {
  usuperfilRep.deleteById(id);
  return new ResponseEntity(msg.delete(), HttpStatus.OK);
 }

}
