/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.dao;

import espe.edu.ec.adm_user.model.SegUsuPerfil;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author saintrec
 */
@Repository
public interface SegUsuPerfilRepository extends CrudRepository<SegUsuPerfil, Long> {

 @Query(value = "SELECT * FROM siseac.seg_usu_perfil order by usu_id", nativeQuery = true)
 List<SegUsuPerfil> findallUsuPerfil();

 SegUsuPerfil findByPerIdAndUsuId(Long perId, Long usuId);

 List<SegUsuPerfil> findAllByusuId(Long usuId);

 List<SegUsuPerfil> findAllByperId(Long perId);

 void deleteByusuId(Long usuId);

 void deleteByperId(Long perId);
}
