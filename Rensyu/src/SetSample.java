//import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetSample {

	public static void main(String[]args){
		Set<String> set;
		set = new HashSet<String>();

		set.add("value3");
		set.add("value2");
		set.add("value5");
		set.add("value4");
		set.add("value1");

		set.add("value2");
		System.out.println(set);

		for(String s : set){
			System.out.println(s);
		}
//		String[] strArray = { "あ", "い", "m", "u", "r", "a", "i" };
//		Arrays.stream(strArray).forEach(str -> System.out.print(str));

	}
}
