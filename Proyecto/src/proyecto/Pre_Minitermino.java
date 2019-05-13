/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author Emm
 */
class Pre_Minitermino {
    private String Parte1;
    private String Parte2;
    private String Relacion;
    public Pre_Minitermino(String Parte1,String Parte2){
        this.Parte1= Parte1;
        this.Parte2= Parte2;
        this.Relacion=Relacion;
    }
    public String toString(){
        return "("+Parte1+")"+" ^ "+ "("+Parte2+")";
    }

    public String getPredicado1() {
        return Parte1;
    }

    public String getPredicado2() {
        return Parte2;
    }

    public void setPredicado1(String Predicado1) {
        this.Parte1 = Parte1;
    }

    public void setPredicado2(String Predicado2) {
        this.Parte2 = Parte2;
    }

}
