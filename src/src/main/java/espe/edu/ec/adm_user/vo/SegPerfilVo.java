/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.vo;

import espe.edu.ec.adm_user.dao.SegPerfilRepository;
import espe.edu.ec.adm_user.dao.SegPerfilRepositoryRel;
import espe.edu.ec.adm_user.model.SegPerfil;
import espe.edu.ec.adm_user.model.SegPerfilRel;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kevin
 */
@Service
public class SegPerfilVo {

    @Autowired
    private SegPerfilRepository segPerfilrep;

    @Autowired
    private SegPerfilRepositoryRel segPerfilrel;

    public List<SegPerfil> listPerfil() {
        Iterable<SegPerfil> SegPerfil = segPerfilrep.findallprofile();
        List<SegPerfil> list = new ArrayList<SegPerfil>();
        SegPerfil.forEach(list::add);
        return list;
    }

    public List<SegPerfilRel> listPerfilrel() {
        Iterable<SegPerfilRel> SegPerfil = segPerfilrel.findallprofile();
        List<SegPerfilRel> list = new ArrayList<SegPerfilRel>();
        SegPerfil.forEach(list::add);
        return list;
    }

    public SegPerfil create(SegPerfil segPerfil) {
        return segPerfilrep.save(segPerfil);
    }

    public SegPerfilRel createrel(SegPerfilRel segPerfil) {
        return segPerfilrel.save(segPerfil);
    }

    public Optional<SegPerfil> getsys(long perId) {
        return segPerfilrep.findById(perId);
    }

    public void updatePerfil(SegPerfil segPerfil) {
        segPerfilrep.save(segPerfil);
    }

    public void deletePerfil(long perId) {
        segPerfilrep.deleteById(perId);
    }
}
