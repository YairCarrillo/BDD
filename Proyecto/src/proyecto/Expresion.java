/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.ArrayList;

/**
 *
 * @author Familia Ruiz
 */
public class Expresion {
    private String Relacion;
    ArrayList <String> Atributos;
    private String Exp;
    public Expresion(ArrayList <String> Atributos, String Relacion){
        this.Relacion = Relacion;
        this.Atributos = Atributos;
    }
    public String toString(){
        Exp = Atributos.get(0).toString();
        for(int i = 1; i < Atributos.size();i++){
            Exp = Exp + "," + Atributos.get(i).toString();
        }
        return Exp + "-(" + Relacion + ")";
    }
    public ArrayList <String> getAtributos(){
        return Atributos;
    }
    public String getRelacion(){
        return Relacion;
    }
}
