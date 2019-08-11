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

    @Query(value = "SELECT * FROM seg_sistemas where sis_estado = true order by sis_id", nativeQuery = true)
    List<SegSistemas> findallSystem();
}
