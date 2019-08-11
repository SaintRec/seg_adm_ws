/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.controller;

import espe.edu.ec.adm_user.model.SegUsuario;
import espe.edu.ec.adm_user.dao.SegUsuarioRepository;
import espe.edu.ec.adm_user.util.segMessage;

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
public class SegUsuarioRest {

 @Autowired
 private SegUsuarioRepository usuarioRep;

 private final segMessage msg = new segMessage();

//    Funcion Listar Usuario
 @RequestMapping(value = "/segu", method = RequestMethod.GET, produces = {"application/json"})
 public ResponseEntity<SegUsuario> listarUsuario() throws SQLException {
  List<SegUsuario> usuarios = usuarioRep.findallUser();
  if (usuarios.isEmpty()) {
   return new ResponseEntity(msg.notfound(), HttpStatus.OK);
  } else {
   return new ResponseEntity(usuarios, HttpStatus.OK);
  }
 }

 //    Funcion busqueda de un usuario por su id
 @RequestMapping(value = "/segu/{id}", method = RequestMethod.GET)
 public ResponseEntity<SegUsuario> UsuarioById(@PathVariable Long id) throws SQLException {
  SegUsuario usuario = usuarioRep.findUserByusuId(id);
  if (usuario != null) {
   return new ResponseEntity(usuario, HttpStatus.OK);
  } else {
   return new ResponseEntity(msg.notfound(), HttpStatus.OK);
  }
 }

//    Funcion Actualizar un usuario
 @RequestMapping(value = "/segu", method = RequestMethod.PUT)
 public ResponseEntity<SegUsuario> actualizarUsuario(@Valid @RequestBody SegUsuario usuario) throws SQLException {
  usuarioRep.save(usuario);
  return new ResponseEntity(msg.update(), HttpStatus.OK);
 }

//    Funcion Eliminar un usuario
 @RequestMapping(value = "/segu/{id}", method = RequestMethod.DELETE)
 public ResponseEntity<SegUsuario> eliminarUsuario(@PathVariable long id) throws SQLException {
  usuarioRep.deleteById(id);
  return new ResponseEntity(msg.delete(), HttpStatus.OK);
 }
}
