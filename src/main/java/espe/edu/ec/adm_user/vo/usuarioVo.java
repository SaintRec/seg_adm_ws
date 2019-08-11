/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.adm_user.vo;

/**
 *
 * @author saintrec
 */
public class usuarioVo {

    private String nombres;

    private String apellidos;

    private String cod_cc;

    private String cod_id;

    private Long cod_pidm;

    private String email;

    public usuarioVo() {
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCod_cc() {
        return cod_cc;
    }

    public void setCod_cc(String cod_cc) {
        this.cod_cc = cod_cc;
    }

    public String getCod_id() {
        return cod_id;
    }

    public void setCod_id(String cod_id) {
        this.cod_id = cod_id;
    }

    public Long getCod_pidm() {
        return cod_pidm;
    }

    public void setCod_pidm(Long cod_pidm) {
        this.cod_pidm = cod_pidm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
