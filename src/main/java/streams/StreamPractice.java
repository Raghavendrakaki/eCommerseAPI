package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice {

	public static void main(String[] args) {
		mapPractice();

	}

	public static void streamValidation() {
		Stream s = Stream.of("ABCD", "bcda", "Ram", "King", "Rahim");
		// List k = s.toList();
		// System.out.println(s);
		s.filter(l -> ((String) l).startsWith("R")).forEach(l -> System.out.println(l));

		List<String> m = Arrays.asList("ABCD", "bcda", "Ram", "ABCD", "bcda", "Ram", "King", "Rahim");
		m.stream().count();
		System.out.println(m.stream().count());
		m.stream().distinct().forEach(e -> System.out.println(e));
	}

	public static void lambdaExpression() {
		List<String> m = Arrays.asList("ABCD", "bcda", "Ram", "ABCD", "bcda", "Ram", "King", "Rahim");
		m.forEach(s -> System.out.println(s));
		List<Float> productsList = new ArrayList<Float>();
		// Adding Products
		productsList.add(25000f);
		productsList.add(31000f);
		productsList.add(28000f);
		productsList.add(28000f);
		productsList.add(90000f);
		System.out.println("==========");
		List k = productsList.stream().filter(s -> s > 30000).distinct().collect(Collectors.toList());
		k.forEach(s -> System.out.println(s));
	}
	public static void mapPractice() {
		List<Integer> m = Arrays.asList(1,2,3,4,56,7,12,8,9);
		System.out.println(m.parallelStream().map(s->s*s).distinct().sorted().collect(Collectors.toList()));		
		Collections.sort(m, new NumComparator());
		System.out.println(m);
		
	}

}
