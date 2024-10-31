package telran.interview;

import java.util.TreeSet;

public class AutoCompletion {
	TreeSet<String> strings = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

	public boolean addWord(String word) {
		return strings.add(word);
	}
	public String [] getVariants(String prefix) {
		return strings.subSet(prefix, prefix + Character.MAX_VALUE).toArray(String[]::new);
		
	}
}