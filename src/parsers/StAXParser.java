package parsers;

import bank.DType;
import bank.TypeBank;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;


public class StAXParser {

    public List<TypeBank.Deposit> depositsList = null;
    public TypeBank.Deposit currDeposit = null;
    String tagContent = null;

    public List<TypeBank.Deposit> getList(){
        return depositsList;
    }

    /** Method for parsing xml doument using StaX parser
     * @param reader - object of a XMLStreamReader that has a locating of a xml file
     * @throws XMLStreamException
     */
    public void pars(XMLStreamReader reader) throws XMLStreamException {
        while (reader.hasNext()){
            int event = reader.next();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    if("deposit".equals(reader.getLocalName())){
                        currDeposit = new TypeBank.Deposit();
                        currDeposit.setId(reader.getAttributeValue(0));
                    }
                    if("bank".equals(reader.getLocalName())){
                        depositsList = new ArrayList<>();
                    }
                    break;

                case XMLStreamConstants.CHARACTERS:
                    tagContent = reader.getText().trim();
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    switch (reader.getLocalName()){
                        case "deposit":
                            depositsList.add(currDeposit);
                            break;
                        case "bankName":
                            currDeposit.setBankName(tagContent);
                            break;
                        case "country":
                            currDeposit.setCountry(tagContent);
                            break;
                        case "type":
                            currDeposit.setType(DType.fromValue(tagContent));
                            break;
                        case "depositor":
                            currDeposit.setDepositor(tagContent);
                            break;
                        case "accountId":
                            currDeposit.setAccountId(Integer.parseInt(tagContent));
                            break;
                        case "amount":
                            currDeposit.setAmount(Double.parseDouble(tagContent));
                            break;
                        case "profitability":
                            currDeposit.setProfitability(Byte.parseByte(tagContent));
                            break;
                        case "timeConstraints":
                            currDeposit.setTimeConstraints(Short.parseShort(tagContent));
                            break;
                    }
                    break;
                case XMLStreamConstants.START_DOCUMENT:
                    depositsList = new ArrayList<>();
                    break;
            }
        }
    }

}
