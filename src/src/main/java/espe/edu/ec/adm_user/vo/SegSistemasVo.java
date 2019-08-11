/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.vo;

import espe.edu.ec.adm_user.model.SegSistemas;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import espe.edu.ec.adm_user.dao.SegSistemasRepository;

/**
 *
 * @author saintrec
 */
@Service
public class SegSistemasVo {

    @Autowired
    private SegSistemasRepository sistemasrep;

    public List<SegSistemas> listSystem() {
        Iterable<SegSistemas> sistemas = sistemasrep.findallSystem();
        List<SegSistemas> list = new ArrayList<SegSistemas>();
        sistemas.forEach(list::add);
        return list;
    }

    public SegSistemas create(SegSistemas sistema) {
        return sistemasrep.save(sistema);
    }

    public Optional<SegSistemas> getsys(long sysId) {
        return sistemasrep.findById(sysId);
    }

    public void updateSistema(SegSistemas sistema) {
        sistemasrep.save(sistema);
    }

    public void deleteSistema(long sysId) {

        sistemasrep.deleteById(sysId);
    }
}
