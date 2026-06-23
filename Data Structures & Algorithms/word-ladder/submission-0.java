class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        int depth = 0;
        Set<String> traversed = new HashSet<>();
        Set<String> words = new HashSet<>(wordList);
        queue.add(beginWord);
        traversed.add(beginWord);

        while (!queue.isEmpty()) {
            depth++;
            Queue<String> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                String polledWord = queue.poll();

                if (polledWord.equals(endWord)) {
                    return depth;
                }

                List<String> neighborWords = neighbors(polledWord);
                for (String n : neighborWords) {
                    if (words.contains(n) && !traversed.contains(n)) {
                        traversed.add(n);
                        temp.add(n);
                    }
                }
            }
            queue = temp;
        }

        return 0;
    }

    private List<String> neighbors(String polledWord) {
        char[] characters = polledWord.toCharArray();
        List<String> neighbors = new ArrayList<>();
        for (int i = 0; i < characters.length; i++) {
            char currentChar = characters[i];
            for (int j = (int)'a'; j <= (int)'z'; j++) {
                characters[i] = (char)j;
                neighbors.add(new String(characters));
            }
            characters[i] = currentChar;
        }

        return neighbors;
    }
}