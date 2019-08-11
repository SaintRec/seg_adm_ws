/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.controller;

import espe.edu.ec.adm_user.dao.SegOpcPerfilRepository;
import espe.edu.ec.adm_user.dao.SegOpcionRepository;
import espe.edu.ec.adm_user.dao.SegOpcionRepositoryRel;
import espe.edu.ec.adm_user.model.SegOpcPerfil;
import espe.edu.ec.adm_user.model.SegOpcion;
import espe.edu.ec.adm_user.model.SegOpcionRel;
import espe.edu.ec.adm_user.util.segMessage;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Labs-DCCO
 */
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/adm")
@Transactional
public class SegOpcionRest {

 @Autowired
 private SegOpcionRepository segOpcionRep;

 @Autowired
 private SegOpcionRepositoryRel segOpcionRepRel;

 @Autowired
 private SegOpcPerfilRepository segOpcPerfilRep;

 private final segMessage msg = new segMessage();

//    Funcion Listar las opciones
 @RequestMapping(value = "/sego", method = RequestMethod.GET)
 public ResponseEntity<SegOpcionRel> listaOpciones() {
  List<SegOpcionRel> SegOpcion = segOpcionRepRel.findallOption();
  if (SegOpcion.isEmpty()) {
   return new ResponseEntity(msg.notfound(), HttpStatus.OK);
  } else {
   return new ResponseEntity(SegOpcion, HttpStatus.OK);
  }
 }

 //    Funcion Buscar una opcion por su Id
 @RequestMapping(value = "/sego/{id}", method = RequestMethod.GET)
 public ResponseEntity<SegOpcionRel> opcionById(@PathVariable long id) {
  SegOpcionRel opcion = segOpcionRepRel.findByopcId(id);
  if (opcion != null) {
   return new ResponseEntity(opcion, HttpStatus.OK);
  } else {
   return new ResponseEntity(msg.notfound(), HttpStatus.OK);
  }
 }

 //    Funcion Fuscar una opcion por el sisId
 @RequestMapping(value = "/segos/{id}", method = RequestMethod.GET)
 public ResponseEntity<SegOpcion> opcionesBySisId(@PathVariable long id) {
  List<SegOpcion> opcionS = segOpcionRep.findBySisId(id);
  if (opcionS.isEmpty()) {
   return new ResponseEntity(msg.notfound(), HttpStatus.OK);
  } else {
   return new ResponseEntity(opcionS, HttpStatus.OK);
  }
 }

//    Funcion crear una Opcion
 @RequestMapping(value = "/sego", method = RequestMethod.POST)
 public ResponseEntity<SegOpcionRel> crearOpcion(@Valid @RequestBody SegOpcionRel opcion) {
  segOpcionRepRel.save(opcion);
  return new ResponseEntity(msg.add(), HttpStatus.CREATED);
 }

//    Funcion Actualizar una opcion
 @RequestMapping(value = "/sego", method = RequestMethod.PUT)
 public ResponseEntity<SegOpcionRel> actualizarOpcion(@Valid @RequestBody SegOpcionRel opcionA) {
  segOpcionRepRel.save(opcionA);
  return new ResponseEntity(msg.update(), HttpStatus.OK);
 }

//    Funcion Eliminar una opcion
 @RequestMapping(value = "/sego/{id}", method = RequestMethod.DELETE)
 public ResponseEntity eliminarOpcion(@PathVariable long id) {
  List<SegOpcPerfil> opcionesp = segOpcPerfilRep.findAllByopcId(id);
  if (opcionesp.isEmpty()) {
   segOpcionRep.deleteById(id);
  } else {
   segOpcionRep.deleteById(id);
   segOpcPerfilRep.deleteByopcId(id);
  }
  return new ResponseEntity(msg.delete(), HttpStatus.OK);
 }

}
