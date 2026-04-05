class Solution {
    public int openLock(String[] deadends, String target) {
        Set<Integer> deadEnds = Arrays.stream(deadends).map(Integer::parseInt).collect(Collectors.toSet());
        Set<Integer> visited = new HashSet<>();
        if(deadEnds.contains(0000)) return -1;
        if(target.contains("0000")) return 1;
        visited.add(0000);

        int end = Integer.parseInt(target);             
        int count = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,0,0});

        while(!q.isEmpty()){
            int size = q.size();
            count++;

            for(int j = 0; j < size; j++){
                int[] cur = q.poll();
                for(int i = 0; i < cur.length; i++){
                    int[] curDown = cur.clone();
                    int[] curUp = cur.clone();

                    curDown[i] = downNumber(curDown[i]);
                    curUp[i] = upNumber(curUp[i]);

                    int code = Arrays.stream(curDown).reduce(0, (acc, x) -> acc * 10 + x);
                    if(end == code) return count;
                    if(!deadEnds.contains(code) && !visited.contains(code)){
                        q.add(curDown);
                        visited.add(code);
                    }

                    code = Arrays.stream(curUp).reduce(0, (acc, x) -> acc * 10 + x);
                    if(end == code) return count;
                    if(!deadEnds.contains(code) && !visited.contains(code)){
                        q.add(curUp);
                        visited.add(code);
                    }
                }
            }
        }

        return -1;
    }

    private int upNumber(int i){
        if(i == 9) return 0;
        else i++;
        return i;
    }

    private int downNumber(int i){
        if(i == 0) return 9;
        else i--;
        return i;
    }
}