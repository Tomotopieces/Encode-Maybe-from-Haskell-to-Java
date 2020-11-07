package hello;

import java.util.List;

/**
 * hello.Maybe test
 * @author Tomoto
 * @date 2020/10/24 16:09
 */
public class MaybeTest {
    public static void main(String[] args) {
        Maybe<?> maybe1 = Maybe.just(1);
        Maybe<?> maybe2 = Maybe.nothing();
        Maybe<?> maybe3 = Maybe.just(List.of(9032, "peach"));
        System.out.println(maybeToString(maybe1));
        System.out.println(maybeToString(maybe2));
        System.out.println(maybeToString(maybe3));
    }

    public static String maybeToString(Maybe<?> maybe) {
        return maybe.match(
                a -> "Just " + a.toString(),
                () -> "Nothing"
        );
    }
}
