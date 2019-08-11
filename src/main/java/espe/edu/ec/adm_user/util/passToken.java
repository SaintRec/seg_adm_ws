/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 *
 * @author saintrec
 */
public class passToken {

 private final String secretKey = "AuthSegUser";
 public String jwToken;

 public String passSegToken(String userpass) {
  Instant time = Instant.now();
  jwToken = Jwts.builder()
          .setId("SegGestionUsuarios")
          .setSubject(userpass)
          .setIssuedAt(Date.from(time))
          .setExpiration(Date.from(time.plus(2, ChronoUnit.HOURS)))
          .signWith(SignatureAlgorithm.HS256, TextCodec.BASE64.encode(secretKey))
          .compact();
  return jwToken;
 }

 //                    .setIssuer("segToken")
 //                    .claim("usuario", user)
 //                    .setAudience(secretKey)
 //                    .setHeaderParam("data", user)   
}
