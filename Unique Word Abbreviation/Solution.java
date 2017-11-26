// 
// 
// An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:
// 
// a) it                      --> it    (no abbreviation)
// 
//      1
// b) d|o|g                   --> d1g
// 
//               1    1  1
//      1---5----0----5--8
// c) i|nternationalizatio|n  --> i18n
// 
//               1
//      1---5----0
// d) l|ocalizatio|n          --> l10n
// Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
// 
// Example: 
// Given dictionary = [ "deer", "door", "cake", "card" ]
// 
// isUnique("dear") -> 
// false
// 
// isUnique("cart") -> 
// true
// 
// isUnique("cane") -> 
// false
// 
// isUnique("make") -> 
// true
class ValidWordAbbr {

    private Map<String, String> abbreviations;

    public ValidWordAbbr(String[] dictionary) {
        abbreviations = new HashMap<>();
        for (String string : dictionary) {
            String key = getAbbreviation(string);
            String value = string;
            String temp = abbreviations.get(key);
            if (temp != null && !temp.equals(string)){
                value = "";
            }
            abbreviations.put(key, value);
        }
    }

    private String getAbbreviation(String string) {
        if (string.length() < 3) return string;
        return "" + string.charAt(0) + (string.length() - 2) + string.charAt(string.length() - 1);
    }

    public boolean isUnique(String word) {
        return !abbreviations.containsKey(getAbbreviation(word)) || abbreviations.get(getAbbreviation(word)).equals(word);
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
