package hello;

/**
 * hello.Maybe
 * @author Tomoto
 * @date 2020/10/24 15:59
 */
public abstract class Maybe<A> {

    public static <A> Maybe<A> just(A a) {
        return new Just<>(a);
    }

    public static <A> Maybe<A> nothing() {
        return new Nothing<>();
    }

    public abstract <R> R match(Just.Case<A, R> caseJust, Nothing.Case<A, R> caseNothing);

    public static final class Just<A> extends Maybe<A> {
        private final A a;

        public Just(A a) {
            this.a = a;
        }

        @Override
        public <R> R match(Case<A, R> caseJust, Nothing.Case<A, R> caseNothing) {
            return caseJust.caseJust(a);
        }

        public interface Case<A, R> {
            R caseJust(A a);
        }
    }

    public static final class Nothing<A> extends Maybe<A> {

        @Override
        public <R> R match(Just.Case<A, R> caseJust, Case<A, R> caseNothing) {
            return caseNothing.caseNothing();
        }

        public interface Case<A, R> {
            R caseNothing();
        }
    }
}
