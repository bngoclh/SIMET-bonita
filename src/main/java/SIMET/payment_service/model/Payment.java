package SIMET.payment_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "payments")
public class Payment {
    @Id
    private String id;
    private String nom;
    private String date;
    private double montant;
    private String email;
    private String modePaiement;

    // Getters và Setters

    // Constructors (Có thể bao gồm constructor không tham số và constructor có tham số)
    public Payment() {}

    public Payment(String nom, String date, double montant, String email, String modePaiement) {
        this.nom = nom;
        this.date = date;
        this.montant = montant;
        this.email = email;
        this.modePaiement = modePaiement;
    }

    // Getters và Setters (tiếp tục)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;A
    }

    public String getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement(String modePaiement) {
        this.modePaiement = modePaiement;
    }
}
