/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.controller;

import espe.edu.ec.adm_user.model.SegUsuPerfil;
import espe.edu.ec.adm_user.vo.SegUsuPerfilVo;
import java.util.List;
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
public class SegUsuPerfilRest {

    public static final Logger logger = LoggerFactory.getLogger(SegUsuPerfilRest.class);

    @Autowired
    private SegUsuPerfilVo usuperfilVo;

    @RequestMapping(value = "/usuperfil", method = RequestMethod.GET)
    public ResponseEntity<SegUsuPerfil> listdemo() {
        logger.info("Fetching all UsuPerfil");
        List<SegUsuPerfil> usuperfil = usuperfilVo.listC();
        return new ResponseEntity(usuperfil, HttpStatus.OK);
    }

    @RequestMapping(value = "/updusup", method = RequestMethod.PUT)
    public ResponseEntity<SegUsuPerfil> updateArticle(@Valid @RequestBody SegUsuPerfil usuperfil) {
        logger.info("Update UsuPerfil with id {}");
        usuperfilVo.updateUsuPerfil(usuperfil);
        return new ResponseEntity<SegUsuPerfil>(usuperfil, HttpStatus.OK);
    }

    @RequestMapping(value = "/delusup/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<SegUsuPerfil> deleterById(@PathVariable long id) {
        logger.info("Delete UsuPerfil with id {}", id);
        usuperfilVo.deleteUsuPerfil(id);
        return new ResponseEntity(id, HttpStatus.OK);
    }

}
