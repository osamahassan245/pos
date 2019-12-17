package com.vodafone.domain;

import javax.persistence.*;

import java.io.Serializable;

/**
 * A WEBSERVICE.
 */
@Entity
@Table(name = "webservice")
public class WEBSERVICE implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "g_id")
    private Long gID;

    @Column(name = "c_pt")
    private String cPT;

    @Column(name = "w_snam")
    private String wSNAM;

    @Column(name = "d_escription")
    private String dESCRIPTION;

    @Column(name = "e_ndpoint")
    private String eNDPOINT;

    @Column(name = "w_sdl")
    private String wSDL;

    @Column(name = "u_sername")
    private String uSERNAME;

    @Column(name = "p_assword")
    private String pASSWORD;

    @Column(name = "t_imeout")
    private String tIMEOUT;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getgID() {
        return gID;
    }

    public WEBSERVICE gID(Long gID) {
        this.gID = gID;
        return this;
    }

    public void setgID(Long gID) {
        this.gID = gID;
    }

    public String getcPT() {
        return cPT;
    }

    public WEBSERVICE cPT(String cPT) {
        this.cPT = cPT;
        return this;
    }

    public void setcPT(String cPT) {
        this.cPT = cPT;
    }

    public String getwSNAM() {
        return wSNAM;
    }

    public WEBSERVICE wSNAM(String wSNAM) {
        this.wSNAM = wSNAM;
        return this;
    }

    public void setwSNAM(String wSNAM) {
        this.wSNAM = wSNAM;
    }

    public String getdESCRIPTION() {
        return dESCRIPTION;
    }

    public WEBSERVICE dESCRIPTION(String dESCRIPTION) {
        this.dESCRIPTION = dESCRIPTION;
        return this;
    }

    public void setdESCRIPTION(String dESCRIPTION) {
        this.dESCRIPTION = dESCRIPTION;
    }

    public String geteNDPOINT() {
        return eNDPOINT;
    }

    public WEBSERVICE eNDPOINT(String eNDPOINT) {
        this.eNDPOINT = eNDPOINT;
        return this;
    }

    public void seteNDPOINT(String eNDPOINT) {
        this.eNDPOINT = eNDPOINT;
    }

    public String getwSDL() {
        return wSDL;
    }

    public WEBSERVICE wSDL(String wSDL) {
        this.wSDL = wSDL;
        return this;
    }

    public void setwSDL(String wSDL) {
        this.wSDL = wSDL;
    }

    public String getuSERNAME() {
        return uSERNAME;
    }

    public WEBSERVICE uSERNAME(String uSERNAME) {
        this.uSERNAME = uSERNAME;
        return this;
    }

    public void setuSERNAME(String uSERNAME) {
        this.uSERNAME = uSERNAME;
    }

    public String getpASSWORD() {
        return pASSWORD;
    }

    public WEBSERVICE pASSWORD(String pASSWORD) {
        this.pASSWORD = pASSWORD;
        return this;
    }

    public void setpASSWORD(String pASSWORD) {
        this.pASSWORD = pASSWORD;
    }

    public String gettIMEOUT() {
        return tIMEOUT;
    }

    public WEBSERVICE tIMEOUT(String tIMEOUT) {
        this.tIMEOUT = tIMEOUT;
        return this;
    }

    public void settIMEOUT(String tIMEOUT) {
        this.tIMEOUT = tIMEOUT;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WEBSERVICE)) {
            return false;
        }
        return id != null && id.equals(((WEBSERVICE) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "WEBSERVICE{" +
            "id=" + getId() +
            ", gID=" + getgID() +
            ", cPT='" + getcPT() + "'" +
            ", wSNAM='" + getwSNAM() + "'" +
            ", dESCRIPTION='" + getdESCRIPTION() + "'" +
            ", eNDPOINT='" + geteNDPOINT() + "'" +
            ", wSDL='" + getwSDL() + "'" +
            ", uSERNAME='" + getuSERNAME() + "'" +
            ", pASSWORD='" + getpASSWORD() + "'" +
            ", tIMEOUT='" + gettIMEOUT() + "'" +
            "}";
    }
}
