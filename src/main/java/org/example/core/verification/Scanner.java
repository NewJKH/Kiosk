package org.example.core.verification;

import org.example.core.excepiton.NotMatchedClass;

public class Scanner {
    private static final java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static <T> T input(Class<T> type) {
        while (true) {
            try {
                String value = scanner.next();
                if (type == Integer.class) {
                    return type.cast(Integer.parseInt(value));
                } else if (type == Double.class) {
                    return type.cast(Double.parseDouble(value));
                } else if (type == Boolean.class) {
                    return type.cast(Boolean.parseBoolean(value));
                } else if (type == String.class) {
                    return type.cast(value);
                }
                throw new NotMatchedClass("지원되지 않는 클레스 입니다. ");
            } catch (Exception e) {
                scanner.nextLine();
            }
        }
    }
}
