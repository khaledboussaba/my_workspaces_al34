
package fr.afcepf.al34.itf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import fr.afcepf.al34.dto.ResCalculTva;


/**
 * <p>Classe Java pour tvaEtTtcResponse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="tvaEtTtcResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://dto.al34.afcepf.fr/}resCalculTva" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tvaEtTtcResponse", propOrder = {
    "_return"
})
public class TvaEtTtcResponse {

    @XmlElement(name = "return")
    protected ResCalculTva _return;

    /**
     * Obtient la valeur de la propriété return.
     * 
     * @return
     *     possible object is
     *     {@link ResCalculTva }
     *     
     */
    public ResCalculTva getReturn() {
        return _return;
    }

    /**
     * Définit la valeur de la propriété return.
     * 
     * @param value
     *     allowed object is
     *     {@link ResCalculTva }
     *     
     */
    public void setReturn(ResCalculTva value) {
        this._return = value;
    }

}
