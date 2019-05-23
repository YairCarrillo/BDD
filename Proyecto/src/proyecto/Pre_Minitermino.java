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
    private PredicadoSimple p1;
    private PredicadoSimple p2;
    public Pre_Minitermino(PredicadoSimple p1,PredicadoSimple p2){
        this.p1= p1;
        this.p2= p2;
    }
    public String toString(){
        return "("+p1.toString()+")"+" ^ "+ "("+p2.toString()+")";
    }

    public PredicadoSimple getPredicado1() {
        return p1;
    }

    public PredicadoSimple getPredicado2() {
        return p2;
    }

    public void setPredicado1(PredicadoSimple p1) {
        this.p1 = p1;
    }

    public void setPredicado2(PredicadoSimple p2) {
        this.p2 = p2;
    }

}
