package princetonPlainsboro;

import java.util.Vector;

public class FicheDeSoins {
    private Patient patient;
    private Medecin medecin;
    private Date date;
    private Vector<Acte> actes;       // contient des objets de classe 'Acte'
    
    public FicheDeSoins(Patient patient, Medecin medecin, Date date) {
        this.patient = patient;
        this.medecin = medecin;
        this.date = date;
        actes = new Vector<Acte>();
        // liste vide
        }
    
    public Patient getPatient() { return patient; }
    public Medecin getMedecin() { return medecin; }
    public Date    getDate()    { return date; }
    public Vector<Acte> getActes(){
        return actes;
    }
    
    public void ajouterActe(Acte acte) {
        actes.add(acte);
        }
    
    public void ajouterActe(Code code, int coefficient) {
        Acte acte = new Acte(code, coefficient);
        actes.add(acte);
        }
    
    public String toString() {
        String rep="";
        rep ="\nFiche de soins du " + date.toString();
        rep+="\n- medecin : " + medecin.toString();
        rep+="\n- patient : " + patient.toString();
        rep+="\n- actes medicaux :";
        for (int i=0; i<actes.size(); i++) {
            Acte a = actes.get(i);
            rep+="\n    > " + a.toString();
            }
        return rep;
        }
    
    public double coutTotal() {
        double total = 0;
        for (int i=0; i<actes.size(); i++) {
            Acte a = actes.get(i);
            total += a.cout();
            }
        return total;
        }
    
        public String afficherString() {

        String s = "Fiche de soins du " + date.toString();
        s += "\n" + "- medecin : " + medecin.toString();
        s += "\n" + "- patient : " + patient.fichePatient();
        if (!actes.isEmpty()) {
            s += "\n" + "- actes medicaux :";
            for (int i = 0; i < actes.size(); i++) {
                Acte a = actes.get(i);
                s += "\n" + "    > " + a.toString();
            }
            s += "\n" + "- Cout total: " + this.coutTotal() + " €";
        } else {
            s += "\n" + "- Cout total: 0 €";
        }
        return s;
    }
    }

