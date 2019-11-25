//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.11.25 à 03:00:00 PM CET 
//


package fr.al34.tp.data2;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour Produit complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="Produit">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="label" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="prix" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="caracteristique" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Produit", namespace = "http://www.example.org/produit", propOrder = {

})
public class Produit {

    @XmlElement(required = true)
    protected String label;
    @XmlElement(required = true)
    protected BigDecimal prix;
    protected String caracteristique;
    @XmlAttribute(name = "ref", required = true)
    protected String ref;

    /**
     * Obtient la valeur de la propriété label.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabel() {
        return label;
    }

    /**
     * Définit la valeur de la propriété label.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * Obtient la valeur de la propriété prix.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrix() {
        return prix;
    }

    /**
     * Définit la valeur de la propriété prix.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrix(BigDecimal value) {
        this.prix = value;
    }

    /**
     * Obtient la valeur de la propriété caracteristique.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaracteristique() {
        return caracteristique;
    }

    /**
     * Définit la valeur de la propriété caracteristique.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaracteristique(String value) {
        this.caracteristique = value;
    }

    /**
     * Obtient la valeur de la propriété ref.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRef() {
        return ref;
    }

    /**
     * Définit la valeur de la propriété ref.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRef(String value) {
        this.ref = value;
    }

}
