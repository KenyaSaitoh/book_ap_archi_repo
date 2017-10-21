
package jp.mufg.it.ee.ws.mtom.jaxws;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "dataTransfer", namespace = "http://mtom.ws.ee.it.mufg.jp/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataTransfer", namespace = "http://mtom.ws.ee.it.mufg.jp/")
public class DataTransfer {

    @XmlMimeType("application/octet-stream")
    @XmlElement(name = "arg0", namespace = "")
    private DataHandler arg0;

    /**
     * 
     * @return
     *     returns DataHandler
     */
    public DataHandler getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(DataHandler arg0) {
        this.arg0 = arg0;
    }

}
