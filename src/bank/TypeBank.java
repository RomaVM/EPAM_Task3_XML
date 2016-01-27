
package bank;

import java.util.ArrayList;
import java.util.List;

public class TypeBank {

    public List<TypeBank.Deposit> depositList = new ArrayList<TypeBank.Deposit>();


    public List<TypeBank.Deposit> getDeposit() {
        if (depositList == null) {
            depositList = new ArrayList<TypeBank.Deposit>();
        }
        return this.depositList;
    }

    public static class Deposit {

        protected String bankName;
        protected String country;
        protected DType type;
        protected String depositor;
        protected int accountId;
        protected double amount;
        protected byte profitability;
        protected short timeConstraints;
        protected String id;

        /**
         * Gets the value of the bankName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBankName() {
            return bankName;
        }

        @Override
        public String toString() {
            return "Deposit{" +
                    "bankName='" + bankName + '\'' +
                    ", country='" + country + '\'' +
                    ", type=" + type +
                    ", depositor='" + depositor + '\'' +
                    ", accountId=" + accountId +
                    ", amount=" + amount +
                    ", profitability=" + profitability +
                    ", timeConstraints=" + timeConstraints +
                    ", id='" + id + '\'' +
                    '}';
        }

        /**
         * Sets the value of the bankName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBankName(String value) {
            this.bankName = value;
        }

        /**
         * Gets the value of the country property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCountry() {
            return country;
        }

        /**
         * Sets the value of the country property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCountry(String value) {
            this.country = value;
        }

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link DType }
         *     
         */
        public DType getType() {
            return type;
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link DType }
         *     
         */
        public void setType(DType value) {
            this.type = value;
        }

        /**
         * Gets the value of the depositor property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDepositor() {
            return depositor;
        }

        /**
         * Sets the value of the depositor property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDepositor(String value) {
            this.depositor = value;
        }

        /**
         * Gets the value of the accountId property.
         * 
         */
        public int getAccountId() {
            return accountId;
        }

        /**
         * Sets the value of the accountId property.
         * 
         */
        public void setAccountId(int value) {
            this.accountId = value;
        }

        /**
         * Gets the value of the amount property.
         * 
         */
        public double getAmount() {
            return amount;
        }

        /**
         * Sets the value of the amount property.
         * 
         */
        public void setAmount(double value) {
            this.amount = value;
        }

        /**
         * Gets the value of the profitability property.
         * 
         */
        public byte getProfitability() {
            return profitability;
        }

        /**
         * Sets the value of the profitability property.
         * 
         */
        public void setProfitability(byte value) {
            this.profitability = value;
        }

        /**
         * Gets the value of the timeConstraints property.
         * 
         */
        public short getTimeConstraints() {
            return timeConstraints;
        }

        /**
         * Sets the value of the timeConstraints property.
         * 
         */
        public void setTimeConstraints(short value) {
            this.timeConstraints = value;
        }

        /**
         * Gets the value of the id property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setId(String value) {
            this.id = value;
        }

    }

}
