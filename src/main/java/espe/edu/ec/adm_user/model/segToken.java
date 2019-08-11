/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.model;

import java.io.Serializable;

/**
 *
 * @author saintrec
 *
 *
 */
public class segToken implements Serializable {

 private static final long serialVersionUID = 1L;

 private String segToken;

 public segToken() {
 }

 public segToken(String segToken) {
  this.segToken = segToken;
 }

 public String getSegToken() {
  return segToken;
 }

 public void setSegToken(String segToken) {
  this.segToken = segToken;
 }

}
