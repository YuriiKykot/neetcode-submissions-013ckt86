class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> res = new ArrayList<>();

        for(String str : folder){
            if(!res.isEmpty() && str.length() >= res.get(res.size()-1).length()){
                if(str.startsWith(res.get(res.size()-1) + "/")) continue;
            }
            res.add(str);
        }

        return res;
    }
}