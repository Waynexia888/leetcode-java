public class ValidWordAbbr {
    public Map<String, Integer> dict; // 记录每个单词出现的次数
    public Map<String, Integer> abbr; // 记录每个单词缩写出现的次数
    /*
    * @param dictionary: a list of words
    */public ValidWordAbbr(String[] dictionary) {
        // do intialization if necessary
        dict = new HashMap<>();
        abbr = new HashMap<>();
        for (String s : dictionary) {
            dict.put(s, dict.getOrDefault(s, 0) + 1);
            String ss = getAbbreviation(s);
            abbr.put(ss, abbr.getOrDefault(ss, 0) + 1);
        }
    }

    /*
     * @param word: a string
     * @return: true if its abbreviation is unique or false
     */
    public boolean isUnique(String word) {
        // 1. if dictionary contains the given word, then check if the frequent of word abbreviation in the map == 1
        // 2. if dictionary doesn't contain the given word, just check if the map contains the word abbreviation
        String s = getAbbreviation(word);
        if (dict.containsKey(word)) {
            return abbr.getOrDefault(s, 0) == 1;
        }
        if (!abbr.containsKey(s)) {
            return true;
        }
        return false;
    }

    private String getAbbreviation(String word) {
        if (word.length() < 3) {
            return word;
        }
        String abbrWord = word.charAt(0) + Integer.toString(word.length() - 2) + word.charAt(word.length() - 1);
        return abbrWord;
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param = obj.isUnique(word);
 */