/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.dao;

import espe.edu.ec.adm_user.model.SegUsuPerfilRel;
import espe.edu.ec.adm_user.model.SegUsuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author saintrec
 */
@Repository
public interface SegUsuPerfilRepositoryRel extends CrudRepository<SegUsuPerfilRel, Long> {

 List<SegUsuPerfilRel> findByusuario(SegUsuario Usuario);
}
