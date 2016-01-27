package parsers;

import bank.DType;
import bank.TypeBank;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jdom2.input.DOMBuilder;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class DomParser {

    TypeBank deposits = new TypeBank();

    public DomParser(){};

    /** Method for parsing deposits.xml using jdom parser
     * @param fileName - directory where xml file is located
     * @return list of deposits
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    public TypeBank parsing(String fileName) throws ParserConfigurationException, SAXException, IOException{
        DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();

        factory.setNamespaceAware(true);

        DocumentBuilder dombuilder =
                factory.newDocumentBuilder();

        org.w3c.dom.Document w3cDocument =
                dombuilder.parse(fileName);

        DOMBuilder jdomBuilder = new DOMBuilder();

        Document jdomDocument = jdomBuilder.build(w3cDocument);

        Element root=jdomDocument.getRootElement();

        List<Element> listDeposits = root.getChildren("deposit", Namespace.getNamespace("http://ccc.com/Purchase"));

        for (Element deposit:listDeposits){

            TypeBank.Deposit newBank = new TypeBank.Deposit();
            newBank.setId(deposit.getAttributeValue("id"));
            newBank.setBankName(deposit.getChildText("bankName", Namespace.getNamespace("http://ccc.com/Purchase")));
            newBank.setCountry(deposit.getChildText("country", Namespace.getNamespace("http://ccc.com/Purchase")));
            newBank.setType(DType.fromValue(deposit.getChildText("type", Namespace.getNamespace("http://ccc.com/Purchase"))));
            newBank.setDepositor(deposit.getChildText("depositor", Namespace.getNamespace("http://ccc.com/Purchase")));
            newBank.setAccountId(Integer.valueOf(deposit.getChildText("accountId", Namespace.getNamespace("http://ccc.com/Purchase"))));
            newBank.setAmount(Double.valueOf(deposit.getChildText("amount", Namespace.getNamespace("http://ccc.com/Purchase"))));
            newBank.setProfitability(Byte.valueOf(deposit.getChildText("profitability", Namespace.getNamespace("http://ccc.com/Purchase"))));
            newBank.setTimeConstraints(Short.valueOf(deposit.getChildText("timeConstraints", Namespace.getNamespace("http://ccc.com/Purchase"))));

            deposits.depositList.add(newBank);
        }
        return deposits;
    }
}
