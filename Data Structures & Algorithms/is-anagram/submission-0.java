class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> firstMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (!firstMap.containsKey(character)) {
                firstMap.put(character, 0);
            }

            firstMap.put(character, firstMap.get(character)+1);
        }

        Map<Character, Integer> secondMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char character = t.charAt(i);
            if (!secondMap.containsKey(character)) {
                secondMap.put(character, 0);
            }

            secondMap.put(character, secondMap.get(character)+1);
        }

        return firstMap.equals(secondMap);
    }
}
