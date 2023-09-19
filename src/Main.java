import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        Supplier<Integer> randomSupplier = () -> (int) (Math.random() * 100);
        int randomNumber = randomSupplier.get();
        System.out.println("Случайное число: " + randomNumber);
        System.out.println("--------------------------------------------");

        Supplier<LocalTime> vremya = LocalTime::now;
        LocalTime localTime = vremya.get();
        System.out.println(localTime);

        System.out.println("--------------------------------------------");
        Function<String,Integer> qwe = Integer::parseInt;
        int abc = qwe.apply("237774");
        System.out.println(abc);
        System.out.println("--------------------------------------------");

        List<String> spis = new ArrayList<>(List.of("Jandar","krasavchik","vashe","pushkaaaaaaaaaaa"));
        for (int i = 0; i < spis.size(); i++) {

            int finalI = i;
            Function<String, Integer> qwer = new Function<String, Integer>() {
                @Override
                public Integer apply(String s) {
                    return spis.get(finalI).length();

                }
            };
            System.out.println(qwer.apply(spis.toString()));
        }
        System.out.println("--------------------------------------------");


        Predicate<Integer> prost = n -> {
            if (n <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        };

        int numberToCheck = 19;
        if (prost.test(numberToCheck)) {
            System.out.println(numberToCheck + " является простым числом.");
        } else {
            System.out.println(numberToCheck + " не является простым числом.");
        }
        System.out.println("--------------------------------------------");

        List<Integer> m = new ArrayList<>(List.of(1,3,4,5,6,7,8));
        Predicate<Integer>  arr = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                for (int i = 0; i < m.size(); i++) {
                    if (m.get(i).equals(integer)) {
                        return true;
                    }
                }
                return false;
            }
        };
        System.out.println(arr.test(5));
        System.out.println("--------------------------------------------");

        BiPredicate<Integer,Integer> srav = (a, b) -> {
            if(a>b){
            return true;}{
                return false;
            }
        };

        boolean result = srav.test(10, 5);//10 bolshe 5?
        System.out.println("10 bolshe 5?");
        System.out.println(result);
        System.out.println("--------------------------------------------");

        List<Integer> per = new ArrayList<>(List.of(1,2,3,4,5,6,7));
        List<Integer> vtor = new ArrayList<>(List.of(6,7,8,9));
        BiPredicate<ArrayList<Integer>, ArrayList<Integer>> da = new BiPredicate<ArrayList<Integer>, ArrayList<Integer>>() {
            @Override
            public boolean test(ArrayList<Integer> a, ArrayList<Integer> b) {
                for (int i = 0; i < a.size(); i++) {
                    for (int j = 0; j < b.size(); j++) {
                        if (a.get(i).equals(b.get(j))) {
                            return true;
                        }
                    }
                }
                return false;
            }
        };
        System.out.println(da.test((ArrayList<Integer>) per, (ArrayList<Integer>) vtor));
        System.out.println("--------------------------------------------");

        BiFunction<Integer,Integer,Integer> sum = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer+integer2;
            }
        };
        System.out.println(sum.apply(5, 45));
        System.out.println("--------------------------------------------");

        BiFunction<Integer,Integer,Double> sel = new BiFunction<Integer, Integer, Double>() {
            @Override
            public Double apply(Integer integer, Integer integer2) {
                double f = ((integer*((double) 9 /5))+32);
                return f;
            }
        };
        System.out.println(sel.apply(23, 0));

    }
}

