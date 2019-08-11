/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.controller;

import espe.edu.ec.adm_user.model.SegPerfil;
import espe.edu.ec.adm_user.model.SegPerfilRel;
import espe.edu.ec.adm_user.vo.SegPerfilVo;
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
public class SegPerfilRest {

    public static final Logger logger = LoggerFactory.getLogger(SegPerfilRest.class);

    @Autowired
    private SegPerfilVo segPerfilVo;

    @RequestMapping(value = "/SegProfiles", method = RequestMethod.GET)
    public ResponseEntity<SegPerfil> listdemo() {
        logger.info("Fetching all Profiles");
        List<SegPerfil> SegPerfil = segPerfilVo.listPerfil();
        return new ResponseEntity(SegPerfil, HttpStatus.OK);
    }

    @RequestMapping(value = "/Segprof", method = RequestMethod.GET)
    public ResponseEntity<SegPerfilRel> listrel() {
        logger.info("Fetching all Profiles Rel");
        List<SegPerfilRel> perfil = segPerfilVo.listPerfilrel();
        return new ResponseEntity(perfil, HttpStatus.OK);
    }

    @RequestMapping(value = "/addpero", method = RequestMethod.POST)
    public ResponseEntity<SegPerfilRel> create(@Valid @RequestBody SegPerfilRel perfil) {
        SegPerfilRel profileCreated = segPerfilVo.createrel(perfil);
        return new ResponseEntity(profileCreated, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/opprofile/{id}", method = RequestMethod.GET)
    public ResponseEntity<SegPerfil> userById(@PathVariable long id) {
        logger.info("Fetching Client with id {}", id);
        Optional<SegPerfil> client = segPerfilVo.getsys(id);
        return new ResponseEntity(client, HttpStatus.OK);
    }

    @RequestMapping(value = "/updper", method = RequestMethod.PUT)
    public ResponseEntity<SegPerfil> updateArticle(@Valid @RequestBody SegPerfil perfil) {
        logger.info("Update Perfil with id {}");
        segPerfilVo.updatePerfil(perfil);
        return new ResponseEntity<SegPerfil>(perfil, HttpStatus.OK);
    }

    @RequestMapping(value = "/delper/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<SegPerfil> deleterById(@PathVariable long id) {
        logger.info("Delete Perfil with id {}", id);
        segPerfilVo.deletePerfil(id);
        return new ResponseEntity(id, HttpStatus.OK);
    }
}
