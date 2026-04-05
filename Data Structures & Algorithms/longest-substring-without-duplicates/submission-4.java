// class Solution {
//     public int lengthOfLongestSubstring(String s) {

//         Queue<Character> list = new ArrayDeque<>();
//         int max = 0;

//         for(int i = 0; i < s.length(); i++){
//             System.out.println(list);
//             if(list.contains(s.charAt(i))){
//                 max = Math.max(max,list.size());
//                 while(list.contains(s.charAt(i))) list.poll();
//             }
//             list.offer(s.charAt(i));
//         }

//         max = Math.max(max,list.size());

//         return max;
//     }
// }

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
		int start = 0;
		//String maxString = "";
		Map<Character, Integer> charIndex = new HashMap<>();

		for(int end = 0; end < s.length(); end++){
			char current = s.charAt(end);
			if(charIndex.containsKey(current)){
				start = Math.max(start, charIndex.get(current) + 1);
			}

			charIndex.put(current,end);

			int currentLength = end - start + 1;
			if(currentLength > maxLength){
				maxLength = currentLength;
				//maxString = s.substring(start, end + 1);
			}
		}

        return maxLength;
    }
}
