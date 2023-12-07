package org.example.ICICI.enums;

public enum TypesOfLoan{
    HOME(1,0.05f,"Home"),
    EDUCATION(2,0.03f,"Education"),
    PERSONAL(3,0.06f,"Personal"),
    CAR(4,0.08f,"Car");

    private final int order;
    private final float ROI;
    private final String name;

   TypesOfLoan(int order, float ROI,String name) {
        this.order = order;
        this.ROI = ROI;
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public float getROI() {
        return ROI;
    }

    public String getName() {
        return name;
    }

    public static TypesOfLoan getByOrder(int order) {
        for (TypesOfLoan type : values()) {
            if (type.getOrder() == order) {
                return type;
            }
        }
        return null;
    }
}
