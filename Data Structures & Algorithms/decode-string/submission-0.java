class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();

        Stack<String> strings = new Stack();
        Stack<Integer> numbers = new Stack();

        StringBuilder toAdd = new StringBuilder();
        StringBuilder numberToAdd = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                numberToAdd.append(c); 
            }else if(c == '['){
                strings.add(toAdd.toString());

                if(numberToAdd.isEmpty()) numbers.add(0);
                else numbers.add(Integer.valueOf(numberToAdd.toString()));

                toAdd = new StringBuilder();
                numberToAdd = new StringBuilder();
            }else if(c == ']'){
                String last = strings.pop();
                int power = numbers.pop();

                String add = toAdd.toString();

                if(power == 0){
                    last += add;
                }else{
                    String buf = add + "";
                    for(int g = 0; g < power - 1; g++){
                        add += buf;
                    }
                    last += add;
                }

                toAdd = new StringBuilder();
                toAdd.append(last);
            }else{
                toAdd.append(c);
            }
        }

        return toAdd.toString();
    }
}