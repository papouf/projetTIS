package princetonPlainsboro;

public class Acte {
    private Code code;
    private int coef;
    private String comm;
    
    
    public Acte(Code code){
        this.code =code;
        this.coef=1;
        this.comm=null;
    }
    
    public Acte(Code code, int coef) {
        this.code = code;
        this.coef = coef;
        this.comm=null;
    }
    
    public Acte(Code code, String comm){
        this.code=code;
        this.coef=1;
        this.comm=comm;
    }
    
    public Acte(Code code, int coef, String comm){
        this.code =code;
        this.coef=coef;
        this.comm=comm;
    }
    
    public Code getCode(){
        return code;
    }
    
    public int getCoeff(){
        return coef;
    }
    
    public String getComm(){
        return comm;
    }
    
    public void setCode(Code code) {
        this.code = code;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }
    
    public void setComm(String comm){
        this.comm=comm;
    }
    
    public String ficheActe() {
        String s = "\n"  + "Fiche d'acte " +  "\n" + " - code: " + code.toString() + ", coefficient: " + coef;
        if (comm != null) {
            s += "\n" + " - commentaire: " + comm;
        }
        s += "\n" + "----------------------" + "\n";
        return s;
    }
    
    public String toString() {
        return code.toString() + ", coefficient : " + coef;
        }
    
    public double cout() {
        return code.calculerCout(coef);
        }
    }
