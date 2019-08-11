/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author saintrec
 */
public class cryptPassword {

 public String md5(String input) {

  String md5 = null;

  try {
   MessageDigest digest = MessageDigest.getInstance("MD5");
   digest.update(input.getBytes(), 0, input.length());
   md5 = new BigInteger(1, digest.digest()).toString(16);

  } catch (NoSuchAlgorithmException e) {
   e.printStackTrace();
  }
  return md5;
 }

}
