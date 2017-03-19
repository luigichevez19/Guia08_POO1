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
public class Jugadores {

    
    private int CodiEqui, Edad,CodiJ;
    private double Peso,Altura;
    private String NombreJ,NombreE;
    public Jugadores(int CodiJ,String NombreE,String NombreJ, int Edad, double Altura, double Peso ) 
    {
        this.CodiJ = CodiJ;
        this.NombreE = NombreE;
        this.Edad = Edad;
        this.Peso = Peso;
        this.Altura = Altura;
        this.NombreJ = NombreJ;
    }


    public Jugadores()
    {
    
    }
    public int getCodiJ() {
        return CodiJ;
    }

    public void setCodiJ(int CodiJ) {
        this.CodiJ = CodiJ;
    }

    public String getNombreE() {
        return NombreE;
    }

    public void setNombreE(String NombreE) {
        this.NombreE = NombreE;
    }
    public String getNombreJ() {
        return NombreJ;
    }

    public void setNombreJ(String NombreJ) {
        this.NombreJ = NombreJ;
    }

    @Override
    public String toString() {
        return this.NombreJ;
    }

    public int getCodiEqui() {
        return CodiEqui;
    }

    public void setCodiEqui(int CodiEqui) {
        this.CodiEqui = CodiEqui;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public double getPeso() {
        return Peso;
    }

    public void setPeso(double Peso) {
        this.Peso = Peso;
    }

    public double getAltura() {
        return Altura;
    }

    public void setAltura(double Altura) {
        this.Altura = Altura;
    }

    
}
