/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.controller;

import espe.edu.ec.adm_user.dao.SegSistemasRepository;
import espe.edu.ec.adm_user.model.SegSistemas;
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
 * @author saintrec
 */
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/adm")
public class SegSistemasRest {

 @Autowired
 private SegSistemasRepository sistemaRep;

 private final segMessage msg = new segMessage();

 //    Funcion Listar los sistemas Activos
 @RequestMapping(value = "/segs", method = RequestMethod.GET)
 public ResponseEntity<SegSistemas> listaSistemasOn() {
  List<SegSistemas> sistemas = sistemaRep.findallSystemOn();
  if (sistemas.isEmpty()) {
   return new ResponseEntity(msg.notfound(), HttpStatus.OK);
  } else {
   return new ResponseEntity(sistemas, HttpStatus.OK);
  }
 }

 //    Funcion Listar los sistemas Inactivos
 @RequestMapping(value = "/segsi", method = RequestMethod.GET)
 public ResponseEntity<SegSistemas> listaSistemasOff() {
  List<SegSistemas> sistemas = sistemaRep.findallSystemOff();
  if (sistemas.isEmpty()) {
   return new ResponseEntity(msg.notfound(), HttpStatus.OK);
  } else {
   return new ResponseEntity(sistemas, HttpStatus.OK);
  }
 }

 //    Funcion crear un sistema
 @RequestMapping(value = "/segs", method = RequestMethod.POST)
 public ResponseEntity<SegSistemas> crearSistema(@Valid @RequestBody SegSistemas sistema) {
  sistema.setSisEstado(1);
  sistemaRep.save(sistema);
  return new ResponseEntity(msg.add(), HttpStatus.CREATED);
 }

 //    Funcion busqueda de un Sistema por su id
 @RequestMapping(value = "/segs/{id}", method = RequestMethod.GET)
 public ResponseEntity<SegSistemas> sistemaById(@PathVariable long id) {
  SegSistemas sistema = sistemaRep.findBysisId(id);
  if (sistema != null) {
   return new ResponseEntity(sistema, HttpStatus.OK);
  } else {
   return new ResponseEntity(msg.notfound(), HttpStatus.OK);
  }
 }

//    Funcion Actualizar un Sistema
 @RequestMapping(value = "/segs", method = RequestMethod.PUT)
 public ResponseEntity<SegSistemas> actualizarSistema(@Valid @RequestBody SegSistemas sistemaA) {
  sistemaRep.save(sistemaA);
  return new ResponseEntity(msg.update(), HttpStatus.OK);
 }

//    Funcion Eliminar actualmente sin uso
//    @RequestMapping(value = "/delsys/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<SegSistemas> deleterById(@PathVariable long id) {
//        logger.info("Delete Sistema with id {}", id);
//        sistemaRep.deleteById(id);
//        return new ResponseEntity(msg.delete(), HttpStatus.OK);
//    }
}
