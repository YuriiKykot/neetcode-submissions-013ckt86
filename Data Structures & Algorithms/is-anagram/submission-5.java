class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character,Integer> first = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            first.put(s.charAt(i), first.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if(!first.containsKey(c)) return false;
            first.put(c, first.get(c) - 1);
            if(first.get(c) == 0) first.remove(c);
        }

        return !(first.size() != 0);
    }
}
