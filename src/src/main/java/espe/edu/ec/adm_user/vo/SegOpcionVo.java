/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.vo;

import espe.edu.ec.adm_user.dao.SegOpcionRepository;
import espe.edu.ec.adm_user.model.SegOpcion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Labs-DCCO
 */
@Service
public class SegOpcionVo {

    @Autowired
    private SegOpcionRepository opcionrep;

    public List<SegOpcion> listOpccion() {
        Iterable<SegOpcion> SegOpcion = opcionrep.findallOption();
        List<SegOpcion> list = new ArrayList<SegOpcion>();
        SegOpcion.forEach(list::add);
        return list;
    }

    public SegOpcion create(SegOpcion segOpcion) {
        return opcionrep.save(segOpcion);
    }

    public Optional<SegOpcion> getsys(long opcId) {
        return opcionrep.findById(opcId);
    }

    public void updateOpcion(SegOpcion segOpcion) {
        opcionrep.save(segOpcion);
    }

    public void deleteOpcion(long opcId) {

        opcionrep.deleteById(opcId);
    }
}
