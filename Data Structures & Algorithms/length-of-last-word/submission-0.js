class Solution {
    /**
     * @param {string} s
     * @return {number}
     */
    lengthOfLastWord(s) {
        let res = 0;
        for(let i = s.length - 1; i >= 0; i--){
            if(s.at(i) === " " && res === 0){
                continue;
            }else if(s.at(i) === " " && res != 0){
                break;
            }else{
                res++;
            }
        }
        return res;
    }
}
