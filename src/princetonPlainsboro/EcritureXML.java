/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


/**
 *
 * @author Nathanaël
 */

public class EcritureXML {
    
    private String nomFichier;
    private final static String classeur = "src/donnees/";

    // 'nomFichier' est le nom d'un fichier XML se trouvant dans le repertoire 'classeur' a écrire :
    public EcritureXML(String nomFichier) {
        this.nomFichier = nomFichier;
    }
    

    public void saveDossier(DossierMedical dossier){
        
        FileOutputStream out = null;
            // créé le document jDOM contnenant le dossier médical
            Document jdomDoc = createJDOM(dossier);
            
            // de jDOM vers xml
            XMLOutputter xml = new XMLOutputter();
            Format format = Format.getPrettyFormat();
            format.setEncoding("UTF-8"); // pour gerer les accents
            xml.setFormat(format);
            
        try {
            xml.output(jdomDoc, new FileOutputStream(classeur));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EcritureXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EcritureXML.class.getName()).log(Level.SEVERE, null, ex);
        }
            

    }

    private Document createJDOM(DossierMedical dossier) {
        Document jdomDoc = new Document();
        
        // racine
        Element rootElement = new Element("dossiers");
        jdomDoc.setRootElement(rootElement);
        
        //ajoute les fiches de soin
        for (FicheDeSoins fiche : dossier.getFiches()) {

            Element DOMfiche = new Element("ficheDeSoins");
            
            //Date:
            DOMfiche.addContent(convertDate(fiche.getDate()));
            
            //Medecin
            DOMfiche.addContent(convertMedecin(fiche.getMedecin()));
            
            //Patient
            DOMfiche.addContent(convertPatient(fiche.getPatient()));
         
            //Actes
            for (Acte acte : fiche.getActes()) {
                DOMfiche.addContent(convertActe(acte));
            }
            
            // ajoute la nouvelle fiche de soin au document
            rootElement.addContent(DOMfiche);
            
        }
        
        return jdomDoc;
    }
    
    private Element convertDate(Date date)
    {
        Element DOMdate = new Element("date");
        DOMdate.addContent(date.toStringXML());
        return DOMdate;
    }

    private Element convertMedecin(Medecin medecin) {
        Element DOMmedecin = new Element("medecin");
        
        // nom
        Element nom = new Element("nom");
        nom.addContent(medecin.getNom());
        DOMmedecin.addContent(nom);
        
        // prenom
        Element prenom = new Element("prenom");
        prenom.addContent(medecin.getPrenom());
        DOMmedecin.addContent(prenom);
        
        // specialité
        Element spe = new Element("specialite");
        spe.addContent(medecin.getSpecialite().toString());
        DOMmedecin.addContent(spe);
        
        // numéro
        Element num = new Element("numeroTelephone");
        num.addContent(medecin.getNumTel());
        DOMmedecin.addContent(num);
 
        // mot de passe
        Element pass = new Element("motDePasse");
        pass.addContent(medecin.getMotDePasse());
        DOMmedecin.addContent(pass);
        
        return DOMmedecin;
    }

    private Element convertPatient(Patient patient) {
        Element DOMpatient = new Element("patient");

        // nom
        Element nom = new Element("nom");
        nom.addContent(patient.getNom());
        DOMpatient.addContent(nom);
        
        // prenom
        Element prenom = new Element("prenom");
        prenom.addContent(patient.getPrenom());
        DOMpatient.addContent(prenom);
        
        // numéro de Secu
        Long num = patient.getNumSecu();
        // si elle est invalide, on remplace par 0.
        if(num == null)
            num = new Long(0);
        Element numSecu = new Element("numSecu");
        numSecu.addContent(num.toString());
        DOMpatient.addContent(numSecu);
        
        // clé de Secu
        Element cle = new Element("cle");
        cle.addContent(Integer.toString(patient.getCle()));
        DOMpatient.addContent(cle);
        
        // date de naissance
        Element date = new Element("date");
        date.addContent(patient.getDateNa().toStringXML());
        DOMpatient.addContent(date);
        
        //adresse
        Element adresse = new Element("adresse");
        adresse.addContent(patient.getAdresse());
        DOMpatient.addContent(adresse);
        
        return DOMpatient;
    }

    private Element convertActe(Acte acte) {
        Element DOMacte = new Element("acte");
        
        //code
        Element code = new Element("code");
        code.addContent(acte.getCode().toStringSansDetail());
        DOMacte.addContent(code);
                
        //coef
        Element coef = new Element("coef");
        coef.addContent(Integer.toString(acte.getCoef()));
        DOMacte.addContent(coef);
        
        return DOMacte;
    }
    
}
