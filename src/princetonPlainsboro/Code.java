package princetonPlainsboro;

// Cette enumeration fait intervenir des valeurs qui possedent des
// attributs ('libelle' et 'cout') qui sont initialises par un appel du
// constructeur (arguments entre parentheses apres le nom de chaque valeur).
// Par exemple, la valeur Code.FP a un attribut 'libelle' contenant la chaine
// de caracteres "forfait pediatrique" et un attribut 'cout' ayant la valeur 5.0

enum Code {
    // valeurs de l'ï¿½num :
    C("consultation au cabinet", 23.0),
    CDE("consultation de dépistage du mélanome ", 47.00),
    CNPSY("consultation pour les psychiatres, neuro-psychiatres, neurologues", 37.00),
    CS("consultation au cabinet par un spécialiste", 23.0),
    CSC("consultation cardiologie", 45.73),
    FP("forfait pediatrique", 5.0),
    K("autres actes de specialite", 1.92),
    KC("actes de chirurgie et de specialite", 2.09),
    KE("actes d'echographie, de doppler", 1.89),
    KFA("forfait A", 30.49),
    KFB("forfait B", 60.98),
    KMB("prélèvement par ponction veineuse directe", 2.52),
    ORT("orthodontie", 2.15),
    PRO("prothese dentaire", 2.15);
                             
                             
    // attributs de l'ï¿½num :
    private String libelle;
    private double cout;
    
    // constructeur :
    private Code(String libelle, double cout) {
        this.libelle = libelle;
        this.cout = cout;
        }
    
    // mï¿½thodes :
    public String toString() {
        return super.toString() + " : " + libelle + ", cout=" + cout + " euros";
        }
    
    // calcule le prix pour un coefficient donne :
    public double calculerCout(int coefficient) {
        return coefficient * cout;
        }
    }
