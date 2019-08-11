/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.vo;

import espe.edu.ec.adm_user.dao.SegUsuPerfilRepository;
import espe.edu.ec.adm_user.model.SegUsuPerfil;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author saintrec
 */
@Service
public class SegUsuPerfilVo {

    @Autowired
    private SegUsuPerfilRepository usuperfilrep;

    public List<SegUsuPerfil> listC() {
        Iterable<SegUsuPerfil> usu = usuperfilrep.findallUsuPerfil();
        List<SegUsuPerfil> list = new ArrayList<SegUsuPerfil>();
        usu.forEach(list::add);
        return list;
    }

    public SegUsuPerfil create(SegUsuPerfil usuperfil) {
        return usuperfilrep.save(usuperfil);
    }

    public Optional<SegUsuPerfil> getusu(long usuId) {
        return usuperfilrep.findById(usuId);
    }

    public void updateUsuPerfil(SegUsuPerfil usuperfil) {
        usuperfilrep.save(usuperfil);
    }

    public void deleteUsuPerfil(long usuId) {

        usuperfilrep.deleteById(usuId);
    }
}
