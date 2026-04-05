class Solution {
    public int reverse(int x) {
        String numStr = Integer.toString(x);
        StringBuilder sb;

        long res;
        if(x < 0){
            sb = new StringBuilder(numStr.substring(1));
            sb.reverse();
            sb.insert(0,'-');
        }else{
            sb = new StringBuilder(numStr);
            sb.reverse();
        }

        try{
            return Integer.parseInt(sb.toString());
        }catch(Exception e){
            return 0;
        }
    }
}
