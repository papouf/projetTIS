package princetonPlainsboro;

public class Medecin {

    private String nom;
    private String prenom;
    private Enum specialite;
    private String tel;
    private String motDePasse;

    public Medecin(String nom, String prenom, Specialite specialite) {
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
    }

    public Medecin(String nom, String prenom, Specialite specialite, String tel, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.tel = tel;
        this.motDePasse = motDePasse;
    }

    public Enum getSpecialite() {
        return specialite;
    }

    public String toString() {
        return "Dr " + prenom + " " + nom + ", " + specialite;
        
    }

    public String ficheMedecin(){
        String f= "Dr " + prenom + " " + nom + ", " + specialite;
        f+="\n"+"Téléphone: "+tel;
        return f;
    }
        
    public boolean equals(Object o) {
        if (o instanceof Medecin) {
            Medecin p = (Medecin) o;
            return nom.equals(p.nom) && prenom.equals(p.prenom);
        } else {
            return false;
        }
    }

    public enum Specialite {

        anesthegiologie,
        cardiologie,
        dermatologie,
        gerontologie,
        gynecologie,
        hematologie,
        neurologie,
        pediatrie,
        radiologie,
        urologie,
        ORL,
        oncologie;
    }
}
