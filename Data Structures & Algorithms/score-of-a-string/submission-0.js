class Solution {
    /**
     * @param {string} s
     * @return {number}
     */
    scoreOfString(s) {
        let res = 0;

        for(let i = 0; i < s.length - 1; i++){
            res += Math.abs(s.charCodeAt(i + 1) - s.charCodeAt(i));
        }

        return res;
    }
}
