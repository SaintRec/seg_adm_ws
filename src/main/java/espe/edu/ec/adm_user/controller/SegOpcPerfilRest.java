/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.controller;

import espe.edu.ec.adm_user.dao.SegOpcPerfilRepository;
import espe.edu.ec.adm_user.dao.SegOpcPerfilRepositoryRel;
import espe.edu.ec.adm_user.dao.SegPerfilRepository;
import espe.edu.ec.adm_user.model.SegOpcPerfil;
import espe.edu.ec.adm_user.model.SegOpcPerfilRel;
import espe.edu.ec.adm_user.model.SegPerfil;
import espe.edu.ec.adm_user.util.segMessage;

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
 * @author kevin
 */
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/adm")
public class SegOpcPerfilRest {

 @Autowired
 private SegOpcPerfilRepository segOpcPerfilRep;

 @Autowired
 private SegOpcPerfilRepositoryRel segOpcPerfilRepRel;

 @Autowired
 private SegPerfilRepository segPerfilRep;

 private final segMessage msg = new segMessage();

 //    Funcion Listar Opciones de Perfil
 @RequestMapping(value = "/segop", method = RequestMethod.GET)
 public ResponseEntity<SegOpcPerfilRel> listarOpcPer() {
  List<SegOpcPerfilRel> opcper = segOpcPerfilRepRel.findallOpcPerfil();
  if (opcper.isEmpty()) {
   return new ResponseEntity(msg.notfound(), HttpStatus.OK);
  } else {
   return new ResponseEntity(opcper, HttpStatus.OK);
  }
 }

 // Funcion Busqueda OpcionPerfil por Id
 @RequestMapping(value = "/segop/{id}", method = RequestMethod.GET)
 public ResponseEntity<SegOpcPerfil> OpcPerById(@PathVariable long id) {
  SegOpcPerfil opcper = segOpcPerfilRep.findByoppId(id);
  if (opcper != null) {
   return new ResponseEntity(opcper, HttpStatus.OK);
  } else {
   return new ResponseEntity(msg.notfound(), HttpStatus.OK);
  }
 }

 //    Funcion buscar un opciones de un perfil
 @RequestMapping(value = "/segpo/{id}", method = RequestMethod.GET)
 public ResponseEntity opcionesByPerId(@PathVariable long id) {
  SegPerfil seg = segPerfilRep.findByperId(id);
  List<SegOpcPerfilRel> perfilS = segOpcPerfilRepRel.findByperfil(seg);
  if (perfilS.isEmpty()) {
   return new ResponseEntity(msg.notfound(), HttpStatus.OK);
  } else {
   return new ResponseEntity(perfilS, HttpStatus.OK);
  }
 }

//    Funcion Asignar Opciones a un Perfil
 @RequestMapping(value = "/segaddop", method = RequestMethod.POST)
 public ResponseEntity<SegOpcPerfil> crearOpcPer(@Valid @RequestBody List<SegOpcPerfil> opcperC) {
  segOpcPerfilRep.saveAll(opcperC);
  return new ResponseEntity(msg.add(), HttpStatus.CREATED);
 }

 //    Funcion Actualizar OpcionPerfil
 @RequestMapping(value = "/segupdop", method = RequestMethod.PUT)
 public ResponseEntity<SegOpcPerfil> actualizarOpcPer(@Valid @RequestBody SegOpcPerfil opcperA) {
  segOpcPerfilRep.save(opcperA);
  return new ResponseEntity(msg.update(), HttpStatus.OK);
 }

//    Funcion Eliminar OpcionPerfil
 @RequestMapping(value = "/segdltop/{id}", method = RequestMethod.DELETE)
 public ResponseEntity<SegOpcPerfil> eliminarOpcPer(@PathVariable long id) {
  segOpcPerfilRep.deleteById(id);
  return new ResponseEntity(msg.delete(), HttpStatus.OK);
 }

}
