/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.dao;

import espe.edu.ec.adm_user.model.SegPerfilRel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 * @author kevin
 */
public interface SegPerfilRepositoryRel extends CrudRepository<SegPerfilRel, Long> {

 @Query(value = "SELECT * FROM siseac.seg_perfil order by per_id DESC", nativeQuery = true)
 List<SegPerfilRel> findallprofile();

 SegPerfilRel findByperId(Long perId);

}
