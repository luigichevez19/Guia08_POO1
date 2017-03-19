/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

/**
 *
 * @author Luis
 */
public class Equipos {
    private int CodiEqui;
    private String nombEqui;
    private String descEqui;
public Equipos(int CodiEqui, String nombEqui, String descEqui) {
        this.CodiEqui = CodiEqui;
        this.nombEqui = nombEqui;
        this.descEqui = descEqui;
    }

    public Equipos() {
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
