/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.vo;

import espe.edu.ec.adm_user.model.SegUsuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import espe.edu.ec.adm_user.dao.SegUsuarioRepository;

/**
 *
 * @author saintrec
 */
@Service
public class SegUsuarioVo {

    @Autowired
    private SegUsuarioRepository usuariorep;

    public List<SegUsuario> listC() {
        Iterable<SegUsuario> usu = usuariorep.findallUser();
        List<SegUsuario> list = new ArrayList<SegUsuario>();
        usu.forEach(list::add);
        return list;
    }

    public SegUsuario create(SegUsuario usuario) {
        return usuariorep.save(usuario);
    }

    public Optional<SegUsuario> getusu(long usuId) {
        return usuariorep.findById(usuId);
    }

    public void updateUsuario(SegUsuario usuario) {
        usuariorep.save(usuario);
    }

    public void deleteUsuario(long usuId) {
        usuariorep.deleteById(usuId);
    }
}
