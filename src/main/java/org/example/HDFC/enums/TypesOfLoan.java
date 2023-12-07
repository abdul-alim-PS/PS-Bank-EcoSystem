package org.example.HDFC.enums;

public enum TypesOfLoan{
    HOME(1,0.034f,"Home"),
    EDUCATION(2,0.024f,"Education"),
    PERSONAL(3,0.056f,"Personal"),
    CAR(4,0.067f,"Car");

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
