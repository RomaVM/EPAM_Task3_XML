
package bank;

public enum DType {

    DEMAND("demand"),
    FIXED("fixed"),
    ESTIMATED("estimated"),
    ACCUMULATION("accumulation"),
    SAVING("saving"),
    METAL("metal");
    private final String value;

    DType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DType fromValue(String v) {
        for (DType c: DType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
