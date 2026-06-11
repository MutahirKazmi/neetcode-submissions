class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int windowLength = s1.length();
        Map<Character, Integer> slidingFreq = new HashMap<>();
        Map<Character, Integer> s1Freq = new HashMap<>();
        

        for (int i = 0; i < s1.length(); i++) {
            s1Freq.put(s1.charAt(i), s1Freq.getOrDefault(s1.charAt(i), 0)+1);
        }

        int l = 0;
        for (int r = 0; r < s2.length(); r++) {
            Character curr = s2.charAt(r);
            slidingFreq.put(curr, slidingFreq.getOrDefault(curr, 0)+1);
           if (r-l+1 > windowLength) {
               slidingFreq.put(s2.charAt(l), slidingFreq.getOrDefault(s2.charAt(l), 0)-1);
               if (slidingFreq.get(s2.charAt(l)) == 0) {
                slidingFreq.remove(s2.charAt(l));
               }
               l++;
           }

             if (s1Freq.equals(slidingFreq)) {
                return true;
             }               
        }
        
        return false;
    }

}
