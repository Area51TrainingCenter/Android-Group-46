package com.area51.claseserviciopost;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class UsuarioEntity extends RealmObject {
    @PrimaryKey
    private String id;
    private String codpersona;
    private String tipodoc;
    private String numdoc;
    private String pass;
    private String prinombre;
    private String segnombre;
    private String apepaterno;
    private String apematerno;
    private String flgsexo;
    private String fecnaci;
    private String telfijo;
    private String telcel;
    private String emailprin;
    private String desdire;
    private String flgpubli;
    private String maqip;
    private String opcion;
    private String origen;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodpersona() {
        return codpersona;
    }

    public void setCodpersona(String codpersona) {
        this.codpersona = codpersona;
    }

    public String getTipodoc() {
        return tipodoc;
    }

    public void setTipodoc(String tipodoc) {
        this.tipodoc = tipodoc;
    }

    public String getNumdoc() {
        return numdoc;
    }

    public void setNumdoc(String numdoc) {
        this.numdoc = numdoc;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPrinombre() {
        return prinombre;
    }

    public void setPrinombre(String prinombre) {
        this.prinombre = prinombre;
    }

    public String getSegnombre() {
        return segnombre;
    }

    public void setSegnombre(String segnombre) {
        this.segnombre = segnombre;
    }

    public String getApepaterno() {
        return apepaterno;
    }

    public void setApepaterno(String apepaterno) {
        this.apepaterno = apepaterno;
    }

    public String getApematerno() {
        return apematerno;
    }

    public void setApematerno(String apematerno) {
        this.apematerno = apematerno;
    }

    public String getFlgsexo() {
        return flgsexo;
    }

    public void setFlgsexo(String flgsexo) {
        this.flgsexo = flgsexo;
    }

    public String getFecnaci() {
        return fecnaci;
    }

    public void setFecnaci(String fecnaci) {
        this.fecnaci = fecnaci;
    }

    public String getTelfijo() {
        return telfijo;
    }

    public void setTelfijo(String telfijo) {
        this.telfijo = telfijo;
    }

    public String getTelcel() {
        return telcel;
    }

    public void setTelcel(String telcel) {
        this.telcel = telcel;
    }

    public String getEmailprin() {
        return emailprin;
    }

    public void setEmailprin(String emailprin) {
        this.emailprin = emailprin;
    }

    public String getDesdire() {
        return desdire;
    }

    public void setDesdire(String desdire) {
        this.desdire = desdire;
    }

    public String getFlgpubli() {
        return flgpubli;
    }

    public void setFlgpubli(String flgpubli) {
        this.flgpubli = flgpubli;
    }

    public String getMaqip() {
        return maqip;
    }

    public void setMaqip(String maqip) {
        this.maqip = maqip;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }
}
