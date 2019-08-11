/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.dao;

import espe.edu.ec.adm_user.model.SegPerfil;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 * @author kevin
 */
public interface SegPerfilRepository extends CrudRepository<SegPerfil, Long>{
    @Query(value = "SELECT * FROM seg_perfil order by per_id", nativeQuery = true)
    List<SegPerfil> findallprofile();
}
