/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.dao;

import espe.edu.ec.adm_user.model.SegOpcPerfil;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 * @author kevin
 */
public interface SegOpcPerfilRepository extends CrudRepository<SegOpcPerfil, Long> {

    @Query(value = "SELECT * FROM seg_opc_perfil order by opp_id", nativeQuery = true)
    List<SegOpcPerfil> findallOpcPerfil();
}
