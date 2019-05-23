/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author Yirz
 */
public class PredicadoSimple {
    private String Atributo;
    private String Operador;
    private String valor;
    private String Relacion;
    public PredicadoSimple(String Atributo,String Operador,String valor,String Relacion){
        this.Atributo=Atributo;
        this.Operador=Operador;
        this.valor=valor;
        this.Relacion=Relacion;
    }
    public String toString(){
        return Atributo+""+Operador+""+valor+"("+Relacion+")";
    }

    public String getAtributo() {
        return Atributo;
    }

    public String getOperador() {
        return Operador;
    }

    public String getValor() {
        return valor;
    }

    public String getRelacion() {
        return Relacion;
    }

    public void setAtributo(String Atributo) {
        this.Atributo = Atributo;
    }

    public void setOperador(String Operador) {
        this.Operador = Operador;
        return;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setRelacion(String Relacion) {
        this.Relacion = Relacion;
    }
    public PredicadoSimple NotPredicado(){
        String Op ="";
        if(this.Operador.equals("=")){
            Op="<>";
        }
        else if(this.Operador.equals("<>")){
            Op="=";
        }
        else if(this.Operador.equals(">")){
            Op="<=";
        }
        else if(this.Operador.equals("<")){
            Op=">=";
        }
        else if(this.Operador.equals(">=")){
            Op="<";
        }
        else if(this.Operador.equals("<=")){
            Op=">";
        }
        return new PredicadoSimple(this.Atributo,Op,this.valor,this.Relacion);
        
    }
    
}
