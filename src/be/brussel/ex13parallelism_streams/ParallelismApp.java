package be.brussel.ex13parallelism_streams;

import java.util.OptionalDouble;
import java.util.stream.LongStream;

public class ParallelismApp {

    public static void main(String[] args) {

        // without parallel streams
        long startTime1 = System.nanoTime();

        OptionalDouble sum1 = LongStream.rangeClosed(1, 1000000000L)
                .mapToDouble(Math::sqrt)
                .map(Math::log)
                .average();

        long endTime1 = System.nanoTime();
        long timeDifference1 = endTime1 - startTime1;
        System.out.println("Result without parallel streams: " + sum1.getAsDouble());
        System.out.println("Run time in nanoseconds: " + timeDifference1);


        // with parallel streams
        long startTime2 = System.nanoTime();

        OptionalDouble sum2 = LongStream.rangeClosed(1, 1000000000L)
                .parallel()
                .mapToDouble(Math::sqrt)
                .map(Math::log)
                .average();

        long endTime2 = System.nanoTime();
        long timeDifference2 = endTime2 - startTime2;
        System.out.println("Result with parallel streams: " + sum2.getAsDouble());
        System.out.println("Run time in nanoseconds: " + timeDifference2);
    }
}
