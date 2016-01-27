package view;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class TransformToHtml {

    /**Method for transformating xsl and xml files to hrml
     * @throws TransformerException
     */
    public static void transormationToHtml() throws TransformerException {
        try {
            TransformerFactory tFactory=TransformerFactory.newInstance();

            Source xslDoc=new StreamSource("deposits.xsl");
            Source xmlDoc=new StreamSource("deposits.xml");

            String outputFileName="deposits_tables.html";

            OutputStream htmlFile=new FileOutputStream(outputFileName);
            Transformer trasform=tFactory.newTransformer(xslDoc);
            trasform.transform(xmlDoc, new StreamResult(htmlFile));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (TransformerConfigurationException e)
        {
            e.printStackTrace();
        }
        catch (TransformerFactoryConfigurationError e)
        {
            e.printStackTrace();
        }
        catch (TransformerException e)
        {
            e.printStackTrace();
        }


        /*try {

            TransformerFactory tFactory = TransformerFactory.newInstance();

            Transformer transformer =
                    tFactory.newTransformer
                            (new javax.xml.transform.stream.StreamSource
                                    ("deposits1.xsl"));

            transformer.transform
                    (new javax.xml.transform.stream.StreamSource
                                    ("deposits.xml"),
                            new javax.xml.transform.stream.StreamResult
                                    ( new FileOutputStream("gg.html")));
        }
        catch (Exception e) {
            e.printStackTrace( );
        }*/
    }
}
