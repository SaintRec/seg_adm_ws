/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.controller;

import espe.edu.ec.adm_user.model.SegSistemas;
import espe.edu.ec.adm_user.vo.SegSistemasVo;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author saintrec
 */
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/adm")
public class SegSistemasRest {

    public static final Logger logger = LoggerFactory.getLogger(SegSistemasRest.class);

    @Autowired
    private SegSistemasVo sistemaVo;

    
    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello to System Adm_User!";
    }

    @RequestMapping(value = "/systems", method = RequestMethod.GET)
    public ResponseEntity<SegSistemas> listdemo() {
        logger.info("Fetching all System");
        List<SegSistemas> system = sistemaVo.listSystem();
        return new ResponseEntity(system, HttpStatus.OK);
    }


    @RequestMapping(value = "/addsys", method = RequestMethod.POST)
    public ResponseEntity<SegSistemas> create(@Valid @RequestBody SegSistemas sistema) {
        logger.info("Add new Sistema");
        sistema.getSisNombre(); 
        sistema.getSisUrlSistema();
        SegSistemas systemCreated = sistemaVo.create(sistema);
        return new ResponseEntity(systemCreated, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/system/{id}", method = RequestMethod.GET)
    public ResponseEntity<SegSistemas> userById(@PathVariable long id) {
        logger.info("Fetching Sistema with id {}", id);
        Optional<SegSistemas> client = sistemaVo.getsys(id);
        return new ResponseEntity(client, HttpStatus.OK);
    }

    @RequestMapping(value = "/updsys", method = RequestMethod.PUT)
    public ResponseEntity<SegSistemas> updateArticle(@Valid @RequestBody SegSistemas sistema) {
        logger.info("Update Sistema with id {}");
        sistemaVo.updateSistema(sistema);
        return new ResponseEntity<SegSistemas>(sistema, HttpStatus.OK);
    }

    @RequestMapping(value = "/delsys/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<SegSistemas> deleterById(@PathVariable long id) {
        logger.info("Delete Sistema with id {}", id);
        sistemaVo.deleteSistema(id);
        return new ResponseEntity(id, HttpStatus.OK);
    }
}
