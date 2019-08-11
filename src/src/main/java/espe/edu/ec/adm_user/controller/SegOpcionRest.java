/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.controller;

import espe.edu.ec.adm_user.model.SegOpcion;
import espe.edu.ec.adm_user.vo.SegOpcionVo;

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
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Labs-DCCO
 */
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/adm")
public class SegOpcionRest {

    public static final Logger logger = LoggerFactory.getLogger(SegOpcionRest.class);

    @Autowired
    private SegOpcionVo segOpcionVo;

    @RequestMapping(value = "/segppccion", method = RequestMethod.GET)
    public ResponseEntity<SegOpcion> listdemo() {
        logger.info("Fetching all Opcion");
        List<SegOpcion> SegOpcion = segOpcionVo.listOpccion();
        return new ResponseEntity(SegOpcion, HttpStatus.OK);
    }

    @RequestMapping(value = "/addopt", method = RequestMethod.POST)
    public ResponseEntity<SegOpcion> create(@Valid @RequestBody SegOpcion sopcion) {
        SegOpcion opcionCreated = segOpcionVo.create(sopcion);
        return new ResponseEntity(opcionCreated, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/oppcion/{id}", method = RequestMethod.GET)
    public ResponseEntity<SegOpcion> userById(@PathVariable long id) {
        logger.info("Fetching Client with id {}", id);
        Optional<SegOpcion> client = segOpcionVo.getsys(id);
        return new ResponseEntity(client, HttpStatus.OK);
    }
    @RequestMapping(value = "/updopc", method = RequestMethod.PUT)
    public ResponseEntity<SegOpcion> updateArticle(@Valid @RequestBody SegOpcion opcion) {
        logger.info("Update Opcion with id {}");
        segOpcionVo.updateOpcion(opcion);
        return new ResponseEntity<SegOpcion>(opcion, HttpStatus.OK);
    }

    @RequestMapping(value = "/delopc/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<SegOpcion> deleterById(@PathVariable long id) {
        logger.info("Delete Opcion with id {}", id);
        segOpcionVo.deleteOpcion(id);
        return new ResponseEntity(id, HttpStatus.OK);
    }
}
