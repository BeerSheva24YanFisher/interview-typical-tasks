package telran.interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AutoCompletion {
	HashSet<String> words;

	public AutoCompletion() {
        this.words = new HashSet<>();
    }

	public boolean addWord(String word) {
		return word != null && !word.isEmpty() ? words.add(word) : false;
	}

	public String[] getVariants(String prefix) {
		List<String> res = new ArrayList<>();
		if (prefix != null) {
			for (String word : words) {
				if (word.toLowerCase().startsWith(prefix.toLowerCase())) {
					res.add(word);
				}
			}
			res.sort(String.CASE_INSENSITIVE_ORDER);
		}
		return res.toArray(String[]::new);
	}
}