/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.controller;

import espe.edu.ec.adm_user.dao.SegUsuarioRepository;
import espe.edu.ec.adm_user.model.SegUsuario;
import espe.edu.ec.adm_user.model.segToken;
import espe.edu.ec.adm_user.util.cryptPassword;
import espe.edu.ec.adm_user.util.passToken;
import espe.edu.ec.adm_user.util.segMessage;

import java.sql.SQLException;
import java.util.Calendar;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
public class SegAutorizacion {

 @Autowired
 private SegUsuarioRepository usuarioRep;

 private final cryptPassword api = new cryptPassword();
 private final String defaultpass = "espeseguridades";
 private final segMessage msg = new segMessage();
 private final passToken jwt = new passToken();
 private final segToken token = new segToken();

//    Metodo para la verificacion de la encriptacion md5
 @RequestMapping(value = "/pass/{id}", method = RequestMethod.GET)
 public String passMD5(@PathVariable String id) throws SQLException {
  String passs = api.md5(id);
  return " " + passs + " ";
 }

//Metodo de creacion de un nuevo usuario con clave encriptada predeterminada
 @RequestMapping(value = "/addusu", method = RequestMethod.POST)
 public ResponseEntity<SegUsuario> registerusu(@RequestBody SegUsuario usuario) throws SQLException {
  SegUsuario userexist = new SegUsuario();
  userexist = usuarioRep.findUserByusuCc(usuario.getUsuCc());
  if (userexist != null) {
   return new ResponseEntity(msg.ifexist(), HttpStatus.CREATED);
  } else {
   SegUsuario user = new SegUsuario();
   Calendar now = Calendar.getInstance();
   user.setUsuNombres(usuario.getUsuNombres());
   user.setUsuApellidos(usuario.getUsuApellidos());
   user.setUsuCc(usuario.getUsuCc());
   user.setUsuEmail(usuario.getUsuEmail());
   user.setUsuClave(api.md5(defaultpass));
   user.setUsuFecharegistro(now.getTime());
   user.setSpridenId(usuario.getSpridenId());
   user.setSpridenPidm(usuario.getSpridenPidm());
   user = usuarioRep.save(user);
   return new ResponseEntity(user, HttpStatus.CREATED);
  }
 }

//Metodo de validacion de credenciales
 @RequestMapping(value = "/login", method = RequestMethod.POST)
 public ResponseEntity login(@RequestBody SegUsuario usuario) throws ServletException {
  SegUsuario user = new SegUsuario();
  user = usuarioRep.findUserBySpridenId(usuario.getSpridenId());
  if (user != null && user.getUsuClave().equals(api.md5(usuario.getUsuClave()))) {
   token.setSegToken(jwt.passSegToken(user.getSpridenId()));
   return new ResponseEntity(token, HttpStatus.OK);
  } else {
   return new ResponseEntity(msg.errorl(), HttpStatus.OK);
  }
 }

//    Metodo para la actualizacion de la clave de seguridad
 @RequestMapping(value = "/updusu", method = RequestMethod.PUT)
 public ResponseEntity<SegUsuario> changepass(@RequestBody SegUsuario usuario) throws SQLException {
  SegUsuario user = new SegUsuario();
  user = usuarioRep.findUserBySpridenId(usuario.getSpridenId());
  user.setUsuClave(api.md5(usuario.getUsuClave()));
  usuarioRep.save(user);
  return new ResponseEntity(msg.update(), HttpStatus.OK);
 }

//Metodo de validacion de credenciales
 @RequestMapping(value = "/passOld", method = RequestMethod.POST)
 public ResponseEntity passOld(@RequestBody SegUsuario usuario) throws ServletException {
  SegUsuario user = new SegUsuario();
  user = usuarioRep.findUserBySpridenId(usuario.getSpridenId());
  if (user != null && user.getUsuClave().equals(api.md5(usuario.getUsuClave()))) {
   return new ResponseEntity(true, HttpStatus.OK);
  } else {
   return new ResponseEntity(false, HttpStatus.OK);
  }
 }
}
