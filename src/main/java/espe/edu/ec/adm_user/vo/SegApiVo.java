/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.vo;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author saintrec
 */
@Service
public class SegApiVo {

 private static String opciones = " FROM siseac.seg_opc_perfil op "
         + " INNER JOIN siseac.seg_opcion o on o.opc_id=op.opc_id "
         + " INNER JOIN siseac.seg_usu_perfil pu on op.per_id=pu.per_id "
         + " INNER JOIN siseac.seg_usuario u on u.usu_id = pu.usu_id ";

 private static String usuarioperfil = " from siseac.seg_usuario u"
         + " join siseac.seg_usu_perfil up on up.usu_id=u.usu_id"
         + " join siseac.seg_perfil p on p.per_id=up.per_id"
         + " join siseac.seg_sistemas s on s.sis_id=p.sis_id";

 @Autowired
 private JdbcTemplate jdbcTemplate;

//NOTA:  
//  slt= Select del script 
//  wr= where del script
 public List<opcionesVo> getOpcPerfil(String q) throws SQLException {
  String opcion = "SELECT o.opc_nombre as opcion,o.opc_url as url,o.opc_icono as icono, o.opc_clase as clase"
          + " ,op.opp_nuevo as crear,op.opp_editar as modificar,op.opp_eliminar as eliminar";
  return jdbcTemplate.query(opcion + opciones + q, new BeanPropertyRowMapper<>(opcionesVo.class));
 }

 public List<usuarioDataVo> getUsuario(String slt, String wr) throws SQLException {
  return jdbcTemplate.query(slt + usuarioperfil + wr, new BeanPropertyRowMapper<>(usuarioDataVo.class));
 }

 public List<perfilVo> getPerfil(String slt, String wr) throws SQLException {
  return jdbcTemplate.query(slt + usuarioperfil + wr, new BeanPropertyRowMapper<>(perfilVo.class));
 }

}
