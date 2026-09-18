class Solution {
    /**
     * @param {string[]} details
     * @return {number}
     */
    countSeniors(details) {
        let res = 0;

        for(let i = 0; i < details.length; i++){
            let num = details[i][11] + details[i][12];
            console.log(num);
            if(Number(num) > 60) res++;
        }

        return res;
    }
}
