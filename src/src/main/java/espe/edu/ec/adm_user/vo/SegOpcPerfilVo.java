/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.vo;

import espe.edu.ec.adm_user.dao.SegOpcPerfilRepository;
import espe.edu.ec.adm_user.model.SegOpcPerfil;
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
public class SegOpcPerfilVo {

    @Autowired
    private SegOpcPerfilRepository opcPerfilrep;

    public List<SegOpcPerfil> listOpcPerfil() {
        Iterable<SegOpcPerfil> SegOpcPerfil = opcPerfilrep.findallOpcPerfil();
        List<SegOpcPerfil> list = new ArrayList<SegOpcPerfil>();
        SegOpcPerfil.forEach(list::add);
        return list;
    }

    public SegOpcPerfil create(SegOpcPerfil segOpcPerfil) {
        return opcPerfilrep.save(segOpcPerfil);
    }

    public Optional<SegOpcPerfil> getsys(long oppId) {
        return opcPerfilrep.findById(oppId);
    }

    public void updateOpcper(SegOpcPerfil segOpcPerfil) {
        opcPerfilrep.save(segOpcPerfil);
    }

    public void deleteOpcper(long oppId) {

        opcPerfilrep.deleteById(oppId);
    }
}
