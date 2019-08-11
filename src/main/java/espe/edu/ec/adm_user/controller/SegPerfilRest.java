/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.controller;

import espe.edu.ec.adm_user.dao.SegOpcPerfilRepository;
import espe.edu.ec.adm_user.dao.SegPerfilRepository;
import espe.edu.ec.adm_user.dao.SegPerfilRepositoryRel;
import espe.edu.ec.adm_user.dao.SegUsuPerfilRepository;
import espe.edu.ec.adm_user.model.SegOpcPerfil;
import espe.edu.ec.adm_user.model.SegPerfil;
import espe.edu.ec.adm_user.model.SegPerfilRel;
import espe.edu.ec.adm_user.model.SegUsuPerfil;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Labs-DCCO
 */
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/adm")
@Transactional
public class SegPerfilRest {

 @Autowired
 private SegPerfilRepository segPerfilRep;

 @Autowired
 private SegPerfilRepositoryRel segPerfilrelRep;

 @Autowired
 private SegUsuPerfilRepository usuperfilRep;

 @Autowired
 private SegOpcPerfilRepository segOpcPerfilRep;

 private final segMessage msg = new segMessage();

//    Funcion Listar los perfiles
 @RequestMapping(value = "/segp", method = RequestMethod.GET)
 public ResponseEntity<SegPerfilRel> listaPerfil() {
  List<SegPerfilRel> perfiles = segPerfilrelRep.findallprofile();
  if (perfiles.isEmpty()) {
   return new ResponseEntity(msg.notfound(), HttpStatus.OK);
  } else {
   return new ResponseEntity(perfiles, HttpStatus.OK);
  }
 }

// Funcion Busqueda de un perfil por su Id
 @RequestMapping(value = "/segp/{id}", method = RequestMethod.GET)
 public ResponseEntity<SegPerfilRel> perfilById(@PathVariable long id) {
  SegPerfilRel perfil = segPerfilrelRep.findByperId(id);
  if (perfil != null) {
   return new ResponseEntity(perfil, HttpStatus.OK);
  } else {
   return new ResponseEntity(msg.notfound(), HttpStatus.OK);
  }
 }

 //    Funcion buscar un perfil por el sisId
 @RequestMapping(value = "/segps/{id}", method = RequestMethod.GET)
 public ResponseEntity<SegPerfil> perfilesBySisId(@PathVariable long id) {

  List<SegPerfil> perfilS = segPerfilRep.findBySisId(id);
  if (perfilS.isEmpty()) {
   return new ResponseEntity(msg.notfound(), HttpStatus.OK);
  } else {
   return new ResponseEntity(perfilS, HttpStatus.OK);
  }
 }

//    Funcion Crear perfil
 @RequestMapping(value = "/segp", method = RequestMethod.POST)
 public ResponseEntity<SegPerfilRel> crearPerfil(@Valid @RequestBody SegPerfilRel perfil) {
  segPerfilrelRep.save(perfil);
  return new ResponseEntity(msg.add(), HttpStatus.CREATED);
 }

 //    Funcion Actualizar un perfil
 @RequestMapping(value = "/segp", method = RequestMethod.PUT)
 public ResponseEntity<SegPerfilRel> actualizarPerfil(@Valid @RequestBody SegPerfilRel perfilA) {
  segPerfilrelRep.save(perfilA);
  return new ResponseEntity(msg.update(), HttpStatus.OK);
 }

 //    Funcion Eliminar un perfil un Sistema
 @RequestMapping(value = "/segp/{id}", method = RequestMethod.DELETE)
 public ResponseEntity<SegPerfil> eliminarPerfil(@PathVariable long id) {
  List<SegOpcPerfil> opcionesperfil = segOpcPerfilRep.findAllByperId(id);
  List<SegUsuPerfil> usuarioperfil = usuperfilRep.findAllByperId(id);
//Verificacion de opciones asignadas al perfil
  if (opcionesperfil.isEmpty()) {
   //Verificacion de usuarios asignados al perfil
   if (usuarioperfil.isEmpty()) {
    segPerfilRep.deleteById(id);
   } else {
    segPerfilRep.deleteById(id);
    usuperfilRep.deleteByperId(id);
   }
  } else {
   if (usuarioperfil.isEmpty()) {
    segPerfilRep.deleteById(id);
    segOpcPerfilRep.deleteByperId(id);
   } else {
    segPerfilRep.deleteById(id);
    segOpcPerfilRep.deleteByperId(id);
    usuperfilRep.deleteByperId(id);
   }
  }
  return new ResponseEntity(msg.delete(), HttpStatus.OK);
 }

}
