class Solution {
    /**
     * @param {number} numRows
     * @return {number[][]}
     */
    generate(numRows) {
        const res = [[1]];

        for(let i = 1; i < numRows; i++){
            res[i] = [];
            res[i].push(1); 
            for(let j = 1; j < i; j++){
                res[i].push(res[i-1][j] + res[i-1][j-1]);
            }
            res[i].push(1);
        }

        return res;
    }
}
