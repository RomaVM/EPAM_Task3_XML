package view;

import bank.Comparating;
import bank.TypeBank;
import org.xml.sax.SAXException;
import parsers.DomParser;
import parsers.SaxParser;
import parsers.StAXParser;
import parsers.Validator;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XMLStreamException, TransformerException {

        SAXParser parser = SAXParserFactory.newInstance()
                .newSAXParser();
        SaxParser parSax=new SaxParser();
        System.out.println("SAX parser is working...");
        parser.parse("deposits.xml", parSax);
        TypeBank list=parSax.getList();
        for(TypeBank.Deposit temp:list.getDeposit()){
            System.out.println(temp);
        }
        System.out.println("SAX parser has stopped");
        System.out.println("");
        System.out.println("---------------------------------------------------------------------");


        DomParser parDom=new DomParser();
        TypeBank listDeposits = parDom.parsing("deposits.xml");
        System.out.println("DOM parser is working....");

        for(TypeBank.Deposit temp:listDeposits.depositList){
            System.out.println(temp);
        }
        System.out.println("DOM parser has stopped");
        System.out.println("");
        System.out.println("---------------------------------------------------------------------");


        StAXParser stAXParser = new StAXParser();
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader =
        factory.createXMLStreamReader(new FileInputStream(new File("deposits.xml")));
        System.out.println("StAX parser is working");
        stAXParser.pars(reader);

        List<TypeBank.Deposit> listDepos = stAXParser.getList();

        for ( TypeBank.Deposit dep : listDepos){
            System.out.println(dep);
        }
        System.out.println("StAX parser is stopped");

        Comparating.compareByAmount(listDepos);
        System.out.println(listDepos);
        Comparating.compareById(listDepos);
        System.out.println(listDepos);

        System.out.println(Validator.validation("deposits.xml", "deposits.xsd"));

        TransformToHtml.transormationToHtml();
    }

}
