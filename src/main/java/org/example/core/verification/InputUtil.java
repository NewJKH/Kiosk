package org.example.core.verification;

import org.example.core.excepiton.InputParseException;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class InputUtil {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Class<?> 클레스 타입의 객체
     *   Function<String, ?> 문자열 -> 타입으로 바꾸는 함수
     */
    private static final Map< Class<?>, Function<String, ?> > parsers = new HashMap<>();

    static {
//        parsers.put(Double.class, s -> Double.parseDouble(s));
        parsers.put(Integer.class, Integer::parseInt);
        parsers.put(Double.class, Double::parseDouble);
        parsers.put(Boolean.class, Boolean::parseBoolean);
        parsers.put(String.class, s -> s);
    }

    /*
        제네릭이라 타입소거 때문발생
        반환타입이 (T) 인데 이럴 경우 타입 안정성 보장이 안되기 때문에 경고를 띄움. 그거를 방지
     */
    @SuppressWarnings("unchecked")
    public static <T> T input(Class<T> type) {
        Function<String, ?> parser = parsers.get(type);

        if (parser == null) {
            throw new InputParseException("지원되지 않는 타입입니다. ");
        }

        while (true) {
            try {
                String value = scanner.next();
                return (T) parser.apply(value);
            } catch (NumberFormatException e) {
                System.out.println("입력에 오류가 발생했습니다.");
                scanner.nextLine();
            }
        }
    }
}
