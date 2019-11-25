//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.11.25 à 03:00:00 PM CET 
//


package fr.al34.tp.data2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.al34.tp.data2 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Commande_QNAME = new QName("http://www.example.org/commande", "commande");
    private final static QName _Produit_QNAME = new QName("http://www.example.org/produit", "produit");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.al34.tp.data2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Commande }
     * 
     */
    public Commande createCommande() {
        return new Commande();
    }

    /**
     * Create an instance of {@link Produit }
     * 
     */
    public Produit createProduit() {
        return new Produit();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Commande }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/commande", name = "commande")
    public JAXBElement<Commande> createCommande(Commande value) {
        return new JAXBElement<Commande>(_Commande_QNAME, Commande.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Produit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/produit", name = "produit")
    public JAXBElement<Produit> createProduit(Produit value) {
        return new JAXBElement<Produit>(_Produit_QNAME, Produit.class, null, value);
    }

}
