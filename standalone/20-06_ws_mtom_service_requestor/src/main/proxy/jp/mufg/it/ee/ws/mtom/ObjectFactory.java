
package jp.mufg.it.ee.ws.mtom;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jp.mufg.it.ee.ws.mtom package. 
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

    private final static QName _DataTransfer_QNAME = new QName("http://mtom.ws.ee.it.mufg.jp/", "dataTransfer");
    private final static QName _DataTransferResponse_QNAME = new QName("http://mtom.ws.ee.it.mufg.jp/", "dataTransferResponse");
    private final static QName _ByteTransfer_QNAME = new QName("http://mtom.ws.ee.it.mufg.jp/", "byteTransfer");
    private final static QName _ByteTransferResponse_QNAME = new QName("http://mtom.ws.ee.it.mufg.jp/", "byteTransferResponse");
    private final static QName _ByteTransferArg0_QNAME = new QName("", "arg0");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jp.mufg.it.ee.ws.mtom
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ByteTransfer }
     * 
     */
    public ByteTransfer createByteTransfer() {
        return new ByteTransfer();
    }

    /**
     * Create an instance of {@link ByteTransferResponse }
     * 
     */
    public ByteTransferResponse createByteTransferResponse() {
        return new ByteTransferResponse();
    }

    /**
     * Create an instance of {@link DataTransfer }
     * 
     */
    public DataTransfer createDataTransfer() {
        return new DataTransfer();
    }

    /**
     * Create an instance of {@link DataTransferResponse }
     * 
     */
    public DataTransferResponse createDataTransferResponse() {
        return new DataTransferResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DataTransfer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mtom.ws.ee.it.mufg.jp/", name = "dataTransfer")
    public JAXBElement<DataTransfer> createDataTransfer(DataTransfer value) {
        return new JAXBElement<DataTransfer>(_DataTransfer_QNAME, DataTransfer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DataTransferResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mtom.ws.ee.it.mufg.jp/", name = "dataTransferResponse")
    public JAXBElement<DataTransferResponse> createDataTransferResponse(DataTransferResponse value) {
        return new JAXBElement<DataTransferResponse>(_DataTransferResponse_QNAME, DataTransferResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ByteTransfer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mtom.ws.ee.it.mufg.jp/", name = "byteTransfer")
    public JAXBElement<ByteTransfer> createByteTransfer(ByteTransfer value) {
        return new JAXBElement<ByteTransfer>(_ByteTransfer_QNAME, ByteTransfer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ByteTransferResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mtom.ws.ee.it.mufg.jp/", name = "byteTransferResponse")
    public JAXBElement<ByteTransferResponse> createByteTransferResponse(ByteTransferResponse value) {
        return new JAXBElement<ByteTransferResponse>(_ByteTransferResponse_QNAME, ByteTransferResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "arg0", scope = ByteTransfer.class)
    public JAXBElement<byte[]> createByteTransferArg0(byte[] value) {
        return new JAXBElement<byte[]>(_ByteTransferArg0_QNAME, byte[].class, ByteTransfer.class, ((byte[]) value));
    }

}
