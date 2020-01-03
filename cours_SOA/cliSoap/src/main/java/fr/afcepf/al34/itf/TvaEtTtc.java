
package fr.afcepf.al34.itf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour tvaEtTtc complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="tvaEtTtc">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ht" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="tauxTva" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tvaEtTtc", propOrder = {
    "ht",
    "tauxTva"
})
public class TvaEtTtc {

    protected double ht;
    protected double tauxTva;

    /**
     * Obtient la valeur de la propri�t� ht.
     * 
     */
    public double getHt() {
        return ht;
    }

    /**
     * D�finit la valeur de la propri�t� ht.
     * 
     */
    public void setHt(double value) {
        this.ht = value;
    }

    /**
     * Obtient la valeur de la propri�t� tauxTva.
     * 
     */
    public double getTauxTva() {
        return tauxTva;
    }

    /**
     * D�finit la valeur de la propri�t� tauxTva.
     * 
     */
    public void setTauxTva(double value) {
        this.tauxTva = value;
    }

}
