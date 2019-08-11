/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.dao;

import espe.edu.ec.adm_user.model.SegOpcion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
/**
 *
 * @author kevin
 */
public interface SegOpcionRepository extends CrudRepository<SegOpcion, Long>  {
        @Query(value = "SELECT * FROM SEG_OPCION order by OPC_ID", nativeQuery = true)
    List<SegOpcion> findallOption();
}