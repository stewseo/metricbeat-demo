package metricbeat;

import org.junit.jupiter.api.*;

import java.io.*;
import java.util.*;

public class MetricbeatTest {

    @Test
    void encodingTest() throws IOException {
        List<String> args = new ArrayList<String>();
        args.add("C:\\Users\\seost\\repositories\\ESJavaApiClient\\beat\\metricbeat\\metricbeat.exe");
        ProcessBuilder pb = println(new ProcessBuilder(args));
        println(pb.start());

    }
    @Test
    void otherTest() throws IOException {
        List<String> args = new ArrayList<String>();
        args.add("C:\\Users\\seost\\repositories\\ESJavaApiClient\\beat\\metricbeat\\metricbeat.exe");
        ProcessBuilder pb = println(new ProcessBuilder(args));
        println(pb.start());
    }

    public static void title(Object title) {
        final String RESET = "\033[0m";
        final String GREEN = "\u001B[32m";
        println("");
        println(GREEN + title + RESET);
        println("-".repeat(("" + title).length()));
    }

    public static <T> T println(T t) {
        System.out.println(t);
        return t;
    }
}
