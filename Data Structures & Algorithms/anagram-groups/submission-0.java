class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (String str : strs) {
            int[] arr = new int[26];
            for (int i = 0; i < str.length(); i++) {
                arr[str.charAt(i)-'a']++;
            }

            String arrStr = Arrays.toString(arr);

            if (!result.containsKey(arrStr)) {
                result.put(arrStr, new ArrayList<>());
            }

            List list = result.get(arrStr);
            list.add(str);
            result.put(arrStr, list);
        }

        return new ArrayList<>(result.values());
    }
}
