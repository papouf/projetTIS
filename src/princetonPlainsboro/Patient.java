package princetonPlainsboro;

import static java.lang.String.valueOf;

public class Patient {
    private String nom;
    private String prenom;
    private String adresse;
    private Long ss;
    private Date dateNa;
    private long tel;
    private int cle;
    
    public Patient(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        }
    
    public String toString() {
        return prenom + " " + nom;
        }
    
    public boolean equals(Object o) {
        if (o instanceof Patient) {
            Patient p = (Patient)o;
            return nom.equals(p.nom) && prenom.equals(p.prenom);
            }
        else
            return false;
        }    
    public String getPrenom() {
        return prenom;
    }

    public long getNumSecu() {
        return ss;
    }
    public long getTel() {
        return tel;
    }
    public Date getDateNa() {
        return dateNa;
    }
    
        public String fichePatient() {
        String s = prenom + " " + nom;
        s += "\n" + "numéro de sécurité sociale: " + valueOf(ss);
        s += "\n" + "date de naissance: " + dateNa;
        s += "\n" + "adresse: " + adresse;
        return s;
    }
    }

