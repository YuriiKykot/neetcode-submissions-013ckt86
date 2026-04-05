class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String s : strs){
            sb.append(s.length()).append('#').append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        System.out.println(str);

        int i = 0;
        while(i < str.length()){
            int j = i;
            while(str.charAt(j) != '#') j++;
            int b = Integer.parseInt(str.substring(i, j));

            StringBuilder sb = new StringBuilder();
            sb.append(str.substring(j + 1, j + 1 + b));
            strs.add(sb.toString());
            i = j + 1 + b;
        }

        return strs;
    }
}
