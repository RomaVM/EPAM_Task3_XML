package bank;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparating {

    /**Method for soritng list of deposits by amount
     * @param deposits - list of parsed deposits
     */
    public static void compareByAmount(List deposits){
        Comparator<TypeBank.Deposit> comp = new Comparator<TypeBank.Deposit>() {
            @Override
            public int compare(TypeBank.Deposit o1, TypeBank.Deposit o2) {
                return Double.compare(o1.getAmount(), o2.getAmount());
            }
        };
        Collections.sort(deposits, comp);
    }

    /**Method for sorting list of deposits by ID
     * @param deposits - list of parsed deposits
     */
    public static void compareById(List deposits){
        Comparator<TypeBank.Deposit> comp = new Comparator<TypeBank.Deposit>() {
            @Override
            public int compare(TypeBank.Deposit o1, TypeBank.Deposit o2) {
                return Integer.compare(o1.getAccountId(), o2.getAccountId());
            }
        };
        Collections.sort(deposits, comp);
    }
}
