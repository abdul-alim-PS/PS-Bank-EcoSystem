package org.example.IDFC.enums;

public enum TypesOfLoan{
    HOME(1,0.057f,"Home"),
    EDUCATION(2,0.013f,"Education"),
    PERSONAL(3,0.062f,"Personal"),
    CAR(4,0.087f,"Car");

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
