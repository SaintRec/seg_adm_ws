/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.dao;

import espe.edu.ec.adm_user.model.SegOpcionRel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 * @author kevin
 */
public interface SegOpcionRepositoryRel extends CrudRepository<SegOpcionRel, Long> {

 @Query(value = "SELECT * FROM siseac.SEG_OPCION order by OPC_ID DESC", nativeQuery = true)
 List<SegOpcionRel> findallOption();

 SegOpcionRel findByopcId(Long opcId);
}
