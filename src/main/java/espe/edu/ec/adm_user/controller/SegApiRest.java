/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.controller;

import espe.edu.ec.adm_user.dao.SegUsuarioRepository;
import espe.edu.ec.adm_user.model.SegApi;
import espe.edu.ec.adm_user.model.SegUsuario;
import espe.edu.ec.adm_user.util.segMessage;
import espe.edu.ec.adm_user.vo.SegApiVo;
import espe.edu.ec.adm_user.vo.opcionesVo;
import espe.edu.ec.adm_user.vo.perfilVo;
import espe.edu.ec.adm_user.vo.usuarioVo;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author saintrec
 */
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/adm")
public class SegApiRest {

 @Autowired
 private SegApiVo usuarioOpc;

 @Autowired
 private SegUsuarioRepository usuarioRep;

 private final segMessage msg = new segMessage();

 @RequestMapping(value = "/cc/{data}/{sisid}", method = RequestMethod.GET)
 public ResponseEntity userByCC(@PathVariable String data, @PathVariable String sisid) throws SQLException {
  String slt = "SELECT per_nombre as perfil, sis_nombre as sistema, sis_url_sistema url";
  String wo = " WHERE u.usu_cc=" + data + " and sis_id=" + sisid + " ORDER BY o.opc_orden ASC ";
  String wp = " WHERE u.usu_cc=" + data + " and s.sis_id=" + sisid + " ORDER BY p.per_id";
  SegApi api = new SegApi();
  usuarioVo usuarioData = new usuarioVo();
  List<opcionesVo> opcion = usuarioOpc.getOpcPerfil(wo);
  SegUsuario usuario = usuarioRep.findUserByusuCc(data);
  List<perfilVo> perfil = usuarioOpc.getPerfil(slt, wp);

  if (usuario == null || opcion.isEmpty() || perfil.isEmpty()) {
   return new ResponseEntity(msg.notfound(), HttpStatus.OK);
  } else {
   usuarioData.setNombres(usuario.getUsuNombres());
   usuarioData.setApellidos(usuario.getUsuApellidos());
   usuarioData.setEmail(usuario.getUsuEmail());
   usuarioData.setCod_cc(usuario.getUsuCc());
   usuarioData.setCod_id(usuario.getSpridenId());
   usuarioData.setCod_pidm(usuario.getSpridenPidm());
   api.setUsuario(usuarioData);
   api.setPerfil(perfil);
   api.setOpciones(opcion);
   return new ResponseEntity(api, HttpStatus.OK);
  }
 }

 @RequestMapping(value = "/id/{data}/{sisid}", method = RequestMethod.GET)
 public ResponseEntity userById(@PathVariable String data, @PathVariable String sisid) throws SQLException {
  String slt = "SELECT per_nombre as perfil, sis_nombre as sistema, sis_url_sistema url";
  String wo = " WHERE u.spriden_id='" + data + "' and sis_id=" + sisid + " ORDER BY o.opc_orden ASC ";
  String wp = " WHERE u.spriden_id='" + data + "' and s.sis_id=" + sisid + " ORDER BY p.per_id";
  SegApi api = new SegApi();
  usuarioVo usuarioData = new usuarioVo();
  List<opcionesVo> opcion = usuarioOpc.getOpcPerfil(wo);
  SegUsuario usuario = usuarioRep.findUserBySpridenId(data);
  List<perfilVo> perfil = usuarioOpc.getPerfil(slt, wp);
  if (usuario == null || opcion.isEmpty() || perfil.isEmpty()) {
   return new ResponseEntity(msg.notfound(), HttpStatus.OK);
  } else {
   usuarioData.setNombres(usuario.getUsuNombres());
   usuarioData.setApellidos(usuario.getUsuApellidos());
   usuarioData.setEmail(usuario.getUsuEmail());
   usuarioData.setCod_cc(usuario.getUsuCc());
   usuarioData.setCod_id(usuario.getSpridenId());
   usuarioData.setCod_pidm(usuario.getSpridenPidm());
   api.setUsuario(usuarioData);
   api.setPerfil(perfil);
   api.setOpciones(opcion);
   return new ResponseEntity(api, HttpStatus.OK);
  }
 }

 @RequestMapping(value = "/pidm/{data}/{sisid}", method = RequestMethod.GET)
 public ResponseEntity userByPidm(@PathVariable Long data, @PathVariable String sisid) throws SQLException {
  String slt = "SELECT per_nombre as perfil, sis_nombre as sistema, sis_url_sistema url";
  String wo = " WHERE u.spriden_pidm=" + data + " and sis_id=" + sisid + " ORDER BY o.opc_orden ASC ";
  String wp = " WHERE u.spriden_pidm=" + data + " and s.sis_id=" + sisid + " ORDER BY p.per_id";
  SegApi api = new SegApi();
  usuarioVo usuarioData = new usuarioVo();
  List<opcionesVo> opcion = usuarioOpc.getOpcPerfil(wo);
  SegUsuario usuario = usuarioRep.findByspridenPidm(data);
  List<perfilVo> perfil = usuarioOpc.getPerfil(slt, wp);

  if (usuario == null || opcion.isEmpty() || perfil.isEmpty()) {
   return new ResponseEntity(msg.notfound(), HttpStatus.OK);
  } else {
   usuarioData.setNombres(usuario.getUsuNombres());
   usuarioData.setApellidos(usuario.getUsuApellidos());
   usuarioData.setEmail(usuario.getUsuEmail());
   usuarioData.setCod_cc(usuario.getUsuCc());
   usuarioData.setCod_id(usuario.getSpridenId());
   usuarioData.setCod_pidm(usuario.getSpridenPidm());
   api.setUsuario(usuarioData);
   api.setPerfil(perfil);
   api.setOpciones(opcion);
   return new ResponseEntity(api, HttpStatus.OK);
  }
 }

//    Metodo de validacion de credenciales
 @RequestMapping(value = "/access/{data}/{sisid}", method = RequestMethod.GET)
 public ResponseEntity dataall(@PathVariable String data, @PathVariable String sisid) throws SQLException {
  SegUsuario usuariocc = usuarioRep.findUserByusuCc(data);
  SegApi api = new SegApi();
  String slt = "SELECT per_nombre as perfil, sis_nombre as sistema, sis_url_sistema url";
  if (usuariocc == null) {
   SegUsuario usuarioid = usuarioRep.findUserBySpridenId(data);
   if (usuarioid == null) {
    long pidm = Long.parseLong(data);
    SegUsuario usuariopidm = usuarioRep.findByspridenPidm(pidm);
    if (usuariopidm == null) {
     return new ResponseEntity(msg.notfound(), HttpStatus.OK);
    } else {
     String wo = " WHERE u.spriden_pidm=" + data + " and sis_id=" + sisid + " ORDER BY o.opc_orden ASC ";
     String wp = " WHERE u.spriden_pidm=" + data + " and s.sis_id=" + sisid + " ORDER BY p.per_id";
     usuarioVo usuarioData = new usuarioVo();
     List<opcionesVo> opcion = usuarioOpc.getOpcPerfil(wo);
     List<perfilVo> perfil = usuarioOpc.getPerfil(slt, wp);
     if (opcion.isEmpty() || perfil.isEmpty()) {
      return new ResponseEntity(msg.notfound(), HttpStatus.OK);
     } else {
      usuarioData.setNombres(usuariopidm.getUsuNombres());
      usuarioData.setApellidos(usuariopidm.getUsuApellidos());
      usuarioData.setEmail(usuariopidm.getUsuEmail());
      usuarioData.setCod_cc(usuariopidm.getUsuCc());
      usuarioData.setCod_id(usuariopidm.getSpridenId());
      usuarioData.setCod_pidm(usuariopidm.getSpridenPidm());
      api.setUsuario(usuarioData);
      api.setPerfil(perfil);
      api.setOpciones(opcion);
      return new ResponseEntity(api, HttpStatus.OK);
     }
    }
   } else {
    String wo = " WHERE u.spriden_id='" + data + "' and sis_id=" + sisid + " ORDER BY o.opc_orden ASC ";
    String wp = " WHERE u.spriden_id='" + data + "' and s.sis_id=" + sisid + " ORDER BY p.per_id";
    usuarioVo usuarioData = new usuarioVo();
    List<opcionesVo> opcion = usuarioOpc.getOpcPerfil(wo);
    List<perfilVo> perfil = usuarioOpc.getPerfil(slt, wp);
    if (opcion.isEmpty() || perfil.isEmpty()) {
     return new ResponseEntity(msg.notfound(), HttpStatus.OK);
    } else {
     usuarioData.setNombres(usuarioid.getUsuNombres());
     usuarioData.setApellidos(usuarioid.getUsuApellidos());
     usuarioData.setEmail(usuarioid.getUsuEmail());
     usuarioData.setCod_cc(usuarioid.getUsuCc());
     usuarioData.setCod_id(usuarioid.getSpridenId());
     usuarioData.setCod_pidm(usuarioid.getSpridenPidm());
     api.setUsuario(usuarioData);
     api.setPerfil(perfil);
     api.setOpciones(opcion);
     return new ResponseEntity(api, HttpStatus.OK);
    }
   }
  } else {
   String wo = " WHERE u.usu_cc=" + data + " and sis_id=" + sisid + " ORDER BY o.opc_orden ASC ";
   String wp = " WHERE u.usu_cc=" + data + " and s.sis_id=" + sisid + " ORDER BY p.per_id";
   usuarioVo usuarioData = new usuarioVo();
   List<opcionesVo> opcion = usuarioOpc.getOpcPerfil(wo);
   List<perfilVo> perfil = usuarioOpc.getPerfil(slt, wp);
   if (opcion.isEmpty() || perfil.isEmpty()) {
    return new ResponseEntity(msg.notfound(), HttpStatus.OK);
   } else {
    usuarioData.setNombres(usuariocc.getUsuNombres());
    usuarioData.setApellidos(usuariocc.getUsuApellidos());
    usuarioData.setEmail(usuariocc.getUsuEmail());
    usuarioData.setCod_cc(usuariocc.getUsuCc());
    usuarioData.setCod_id(usuariocc.getSpridenId());
    usuarioData.setCod_pidm(usuariocc.getSpridenPidm());
    api.setUsuario(usuarioData);
    api.setPerfil(perfil);
    api.setOpciones(opcion);
    return new ResponseEntity(api, HttpStatus.OK);
   }
  }
 }
}
