class Solution {
    private static Map<Character, Character[]> numberToCharactersList = new HashMap<>();

    static {        
        numberToCharactersList.put('2', new Character[] {'a','b','c'});
        numberToCharactersList.put('3', new Character[] {'d','e','f'});
        numberToCharactersList.put('4', new Character[] {'g','h','i'});
        numberToCharactersList.put('5', new Character[] {'j','k','l'});
        numberToCharactersList.put('6', new Character[] {'m','n','o'});
        numberToCharactersList.put('7', new Character[] {'p','q','r', 's'});
        numberToCharactersList.put('8', new Character[] {'t','u','v'});
        numberToCharactersList.put('9', new Character[] {'w','x','y', 'z'});
        
    }

    public List<String> letterCombinations(String digits) {
        List<String> resultList = new ArrayList<>();
        generateCombination(digits, 0, new StringBuilder(), resultList);
        
        return resultList;
    }
    
    private void generateCombination(String digits, int startForNumbers, StringBuilder builder, List<String> results) {
        for (int i = startForNumbers; i < digits.length(); i++) {
            Character[] characters = numberToCharactersList.get(digits.charAt(i));
            for (int j = 0; j < characters.length; j++) {
                builder.append(characters[j]);                
                
                if (digits.length() == builder.length()) {
                    results.add(builder.toString());
                }
                
                if (j < characters.length) {
                    generateCombination(digits, i + 1, builder, results);
                }
                
                builder.setLength(builder.length() - 1);

            }            
        }
    }
}
