package parsers;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.xml.sax.*;

import java.io.IOException;

public class Validator{

    /** Method for validation xml file with xsd
     * @param xmlFile - location of xml file
     * @param xsdFile - location of xsd file
     * @return - boolean type of validation(true or false)
     * @throws SAXNotSupportedException
     * @throws SAXException
     * @throws IOException
     */
    public static boolean validation(String xmlFile,String xsdFile) throws SAXNotSupportedException, SAXException, IOException {
        DOMParser parser = new DOMParser();
        MyErrorHandler handler=new MyErrorHandler();
        try {

            parser.setErrorHandler(handler);
            parser.setFeature(
                    "http://xml.org/sax/features/validation", true);
            parser.setFeature(
                    "http://apache.org/xml/features/validation/schema",true);
            parser.setFeature(
                    "http://apache.org/xml/features/validation/schema-full-checking",
                    true);
            parser.setProperty(
                    "http://apache.org/xml/properties/schema/external-schemaLocation", xsdFile);

            parser.parse(xmlFile);

        } catch (SAXNotRecognizedException e) {
            e.printStackTrace();

        }
        return handler.flag;
    }

    static class MyErrorHandler implements ErrorHandler {
        boolean flag=true;
        public void warning(SAXParseException e) {
            System.err.println("warning: "+getLineAddress(e) +
                    "-" + e.getMessage());
        }
        public void error(SAXParseException e) {
            flag=false;
            System.err.println((getLineAddress(e) +
                    " - " + e.getMessage()));
        }
        public void fatalError(SAXParseException e) {
            flag=false;
            System.err.println(getLineAddress(e) +
                    " - " + e.getMessage());
        }
        private String getLineAddress(SAXParseException e) {
            return e.getLineNumber() + " : " + e.getColumnNumber();
        }
    }
}
