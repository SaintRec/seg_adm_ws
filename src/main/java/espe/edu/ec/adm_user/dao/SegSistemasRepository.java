/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.dao;

import espe.edu.ec.adm_user.model.SegSistemas;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author saintrec
 */
@Repository
public interface SegSistemasRepository extends CrudRepository<SegSistemas, Long> {

 @Query(value = "SELECT * FROM siseac.seg_sistemas where sis_estado = 1 order by sis_id DESC", nativeQuery = true)
 List<SegSistemas> findallSystemOn();

 @Query(value = "SELECT * FROM siseac.seg_sistemas where sis_estado = 0 order by sis_id DESC", nativeQuery = true)
 List<SegSistemas> findallSystemOff();

 SegSistemas findBysisId(Long sisId);
}
