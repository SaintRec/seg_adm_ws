/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.dao;

import espe.edu.ec.adm_user.model.SegOpcPerfilRel;
import espe.edu.ec.adm_user.model.SegPerfil;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 * @author kevin
 */
public interface SegOpcPerfilRepositoryRel extends CrudRepository<SegOpcPerfilRel, Long> {

 @Query(value = "SELECT * FROM siseac.seg_opc_perfil order by opp_id", nativeQuery = true)
 List<SegOpcPerfilRel> findallOpcPerfil();

//    SegOpcPerfil findByopcId(Long opcId);
 List<SegOpcPerfilRel> findByperfil(SegPerfil Perfil);

}
