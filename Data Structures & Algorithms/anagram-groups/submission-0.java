class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        char[] compare = null;
        List<List<String>> groups = new ArrayList<>();
        List<String> words = new ArrayList<>(Arrays.asList(strs));

        while(true){
            if(words.isEmpty()) break;
            List<String> l = new ArrayList<>();
            String x = words.get(0);
            l.add(x);
            
            for(int i = 1; i < words.size(); i++){
                String y = words.get(i);
                compare = new char[26];
                if(y.length() == x.length()){
                    for(int j = 0; j < x.length(); j++){
                        compare[x.charAt(j) - 'a']++;
                        compare[y.charAt(j) - 'a']--;
                    }
                    int count = 0; 
                    for (int c : compare) {
                        if (c != 0) count++;
                    }
                    if(count == 0) l.add(y);
                }
            }

            words.removeAll(l);
            groups.add(l);
        }

        return groups;
    }
}
