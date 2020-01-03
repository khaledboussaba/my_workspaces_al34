
package fr.afcepf.al34.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour resCalculTva complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="resCalculTva">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ttc" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="tva" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resCalculTva", propOrder = {
    "ttc",
    "tva"
})
public class ResCalculTva {

    protected double ttc;
    protected double tva;

    /**
     * Obtient la valeur de la propri�t� ttc.
     * 
     */
    public double getTtc() {
        return ttc;
    }

    /**
     * D�finit la valeur de la propri�t� ttc.
     * 
     */
    public void setTtc(double value) {
        this.ttc = value;
    }

    /**
     * Obtient la valeur de la propri�t� tva.
     * 
     */
    public double getTva() {
        return tva;
    }

    /**
     * D�finit la valeur de la propri�t� tva.
     * 
     */
    public void setTva(double value) {
        this.tva = value;
    }

}
