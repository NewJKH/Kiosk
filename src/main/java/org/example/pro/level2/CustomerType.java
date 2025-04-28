package org.example.pro.level2;

import java.util.Optional;

public enum CustomerType {
    NATIONAL_MERIT("국가유공자", 0.10),
    SOLDIER("군인", 0.05),
    STUDENT("학생", 0.03),
    GENERAL("일반", 0.0);

    private final String label;
    private final double discount;

    CustomerType(String label, double discount) {
        this.label = label;
        this.discount = discount;
    }

    public static Optional<CustomerType> findByIndex(int index) {
        if (index < 1 || index > values().length) return Optional.empty();
        return Optional.of(values()[index - 1]);
    }

    public String getLabel() {
        return label;
    }

    public double getDiscount() {
        return discount;
    }

}
