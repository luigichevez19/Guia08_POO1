/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

import java.io.FileInputStream;

/**
 *
 * @author Luis
 */
public class Equipos {
    private int CodiEqui;
    private String nombEqui;
    private String descEqui;
    private byte[] foto;

public Equipos(int CodiEqui, String nombEqui, String descEqui,byte[] foto) {
        this.CodiEqui = CodiEqui;
        this.nombEqui = nombEqui;
        this.descEqui = descEqui;
        this.foto = foto;
    }

    public Equipos() {
    }
     public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    public int getCodiEqui() {
        return CodiEqui;
    }

    public void setCodiEqui(int CodiEqui) {
        this.CodiEqui = CodiEqui;
    }

    public String getNombEqui() {
        return nombEqui;
    }

    public void setNombEqui(String nombEqui) {
        this.nombEqui = nombEqui;
    }

    public String getDescEqui() {
        return descEqui;
    }

    public void setDescEqui(String descEqui) {
        this.descEqui = descEqui;
    }

    @Override
    public String toString() {
       return this.nombEqui;
    }

    
   
}
