/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.controller;

import espe.edu.ec.adm_user.model.SegUsuario;
import espe.edu.ec.adm_user.vo.SegUsuarioVo;

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
 * @author saintrec
 */
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/adm")
public class SegUsuarioRest {

    public static final Logger logger = LoggerFactory.getLogger(SegUsuarioRest.class);

    @Autowired
    private SegUsuarioVo usuarioVo;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<SegUsuario> listdemo() {
        logger.info("Fetching all users");
        List<SegUsuario> users = usuarioVo.listC();
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/addusu", method = RequestMethod.POST)
    public ResponseEntity<SegUsuario> create(@Valid @RequestBody SegUsuario usuario) {
        logger.info("Add new Usuario");
        SegUsuario userCreated = usuarioVo.create(usuario);
        return new ResponseEntity(userCreated, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<SegUsuario> userById(@PathVariable Long id) {
        logger.info("Fetching Usuario with id {}", id);
        Optional<SegUsuario> client = usuarioVo.getusu(id);
        return new ResponseEntity(client, HttpStatus.OK);
    }

    @RequestMapping(value = "/updusu", method = RequestMethod.PUT)
    public ResponseEntity<SegUsuario> updateArticle(@Valid @RequestBody SegUsuario usuario) {
        logger.info("Update Usuario with id {}");
        usuarioVo.updateUsuario(usuario);
        return new ResponseEntity<SegUsuario>(usuario, HttpStatus.OK);
    }

    @RequestMapping(value = "/delusu/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<SegUsuario> deleterById(@PathVariable long id) {
        logger.info("Delete Usuario with id {}", id);
        usuarioVo.deleteUsuario(id);
        return new ResponseEntity(id, HttpStatus.OK);
    }
}
