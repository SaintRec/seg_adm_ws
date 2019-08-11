/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author saintrec
 */
@RestController
public class homeRest {

 public static final Logger logger = LoggerFactory.getLogger(homeRest.class);

 @RequestMapping("")
 @ResponseBody
 public String home() {
  return "!!!!  Hello to SystemWS Gestion de Usuarios !!!!";

 }
}
