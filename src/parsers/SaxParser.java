package parsers;

import bank.DType;
import bank.TypeBank;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParser extends DefaultHandler {
    TypeBank deposits = new TypeBank();
    TypeBank.Deposit deposit;
    int current=0;

    @Override
    public void startDocument(){
        System.out.println("start parsing...");
    }

    @Override
    public void endDocument(){
        System.out.println("end parsing");
    }

    public void startElement(String uri,String localName,String qName,
                             Attributes attr){
        switch(qName){
            case "bank":current=1;break;
            case "deposit":{
                deposit = new TypeBank.Deposit();
                deposit.setId(attr.getValue(0));
                current=2;
                break;
            }
            case "bankName":current=3;break;
            case "country":current=4;break;
            case "type":current=5;break;
            case "depositor":current=6;break;
            case "accountId":current=7;break;
            case "amount":current=8;break;
            case "profitability":current=9;break;
            case "timeConstraints":current=10;break;

        }
    }
    @Override
    public void characters(char[] buf,int start, int length){
        String text=new String(buf,start,length);
        switch(current){
            case 3:{
                deposit.setBankName(text);
                current=0;
                break;
            }
            case 4:{
                deposit.setCountry(text);
                current=0;
                break;
            }
            case 5:{
                deposit.setType(DType.fromValue(text));
                current=0;
                break;
            }
            case 6:{
                deposit.setDepositor(text);
                current=0;
                break;
            }
            case 7:{
                deposit.setAccountId(Integer.valueOf(text));
                current=0;
                break;
            }
            case 8:{
                deposit.setAmount(Double.valueOf(text));
                current=0;
                break;
            }
            case 9:{
                deposit.setProfitability(Byte.valueOf(text));
                current=0;
                break;
            }
            case 10:{
                deposit.setTimeConstraints(Short.valueOf(text));
                current=0;
                break;
            }

        }
    }
    @Override
    public void endElement(String uri,String localName,String qName){
        switch(qName){
            case "deposit":{
                deposits.depositList.add(deposit);
            }
        }
        current=0;
    }

    public TypeBank getList(){
        return deposits;
    }
}
