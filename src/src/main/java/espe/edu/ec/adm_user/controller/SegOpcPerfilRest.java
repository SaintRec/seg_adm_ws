/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.controller;

import espe.edu.ec.adm_user.model.SegOpcPerfil;
import espe.edu.ec.adm_user.vo.SegOpcPerfilVo;
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
 * @author kevin
 */
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/adm")
public class SegOpcPerfilRest {

    public static final Logger logger = LoggerFactory.getLogger(SegOpcPerfilRest.class);

    @Autowired
    private SegOpcPerfilVo segOpcPerfilVo;

    @RequestMapping(value = "/SegOpcProfiles", method = RequestMethod.GET)
    public ResponseEntity<SegOpcPerfil> listdemo() {
        logger.info("Fetching all Profiles");
        List<SegOpcPerfil> SegOpcProfile = segOpcPerfilVo.listOpcPerfil();
        return new ResponseEntity(SegOpcProfile, HttpStatus.OK);
    }

    @RequestMapping(value = "/addpro", method = RequestMethod.POST)
    public ResponseEntity<SegOpcPerfil> create(@Valid @RequestBody SegOpcPerfil opcperfil) {
        SegOpcPerfil opcprofileCreated = segOpcPerfilVo.create(opcperfil);
        return new ResponseEntity(opcprofileCreated, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/opcprofile/{id}", method = RequestMethod.GET)
    public ResponseEntity<SegOpcPerfil> userById(@PathVariable long id) {
        logger.info("Fetching Client with id {}", id);
        Optional<SegOpcPerfil> client = segOpcPerfilVo.getsys(id);
        return new ResponseEntity(client, HttpStatus.OK);
    }
    @RequestMapping(value = "/updopcper", method = RequestMethod.PUT)
    public ResponseEntity<SegOpcPerfil> updateArticle(@Valid @RequestBody SegOpcPerfil opcper) {
        logger.info("Update OpcPerfil with id {}");
        segOpcPerfilVo.updateOpcper(opcper);
        return new ResponseEntity<SegOpcPerfil>(opcper, HttpStatus.OK);
    }

    @RequestMapping(value = "/delopcper/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<SegOpcPerfil> deleterById(@PathVariable long id) {
        logger.info("Delete OpcPerfil with id {}", id);
        segOpcPerfilVo.deleteOpcper(id);
        return new ResponseEntity(id, HttpStatus.OK);
    }
}
