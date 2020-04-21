
package jp.mufg.it.ee.ws.mtom.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "byteTransfer", namespace = "http://mtom.ws.ee.it.mufg.jp/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "byteTransfer", namespace = "http://mtom.ws.ee.it.mufg.jp/")
public class ByteTransfer {

    @XmlElement(name = "arg0", namespace = "", nillable = true)
    private byte[] arg0;

    /**
     * 
     * @return
     *     returns byte[]
     */
    public byte[] getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(byte[] arg0) {
        this.arg0 = arg0;
    }

}
