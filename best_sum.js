// return array containing shortest sum

// brute force
// m = targetSum, n = numbers.length
// O(n^m * m) time
// O(m^2) space 
// const bestSum = (targetSum, numbers) => {

//     if (targetSum === 0) return [];
//     if(targetSum < 0) return null;

//     let shortestCombo = null;

//     for (let num of numbers) {
//         const remainder = targetSum - num;
//         const remainderCombo = bestSum(remainder, numbers);
        
//         if (remainderCombo !== null) {
//             const combo = [ ...remainderCombo, num];
//             // if combo is shorter than current shortest, update it (shortestCombo || replaces null instantiantion automatically)
//             if (shortestCombo === null || combo.length < shortestCombo.length) {
//                 shortestCombo = combo;
//             }
//         }
//     }

//     return shortestCombo;
// }


const bestSum = (targetSum, numbers, memo = {}) => {

    if (targetSum in memo) return memo[targetSum];
    if (targetSum === 0) return [];
    if(targetSum < 0) return null;

    let shortestCombo = null;

    for (let num of numbers) {
        const remainder = targetSum - num;
        const remainderCombo = bestSum(remainder, numbers, memo);
        
        if (remainderCombo !== null) {
            const combo = [ ...remainderCombo, num];
            // if combo is shorter than current shortest, update it (shortestCombo || replaces null instantiantion automatically)
            if (shortestCombo === null || combo.length < shortestCombo.length) {
                shortestCombo = combo;
            }
        }
    }

    memo[targetSum] = shortestCombo;
    return shortestCombo;
}


console.log(bestSum(7, [5, 3, 4, 7])); // [7]
console.log(bestSum(8, [2, 3, 5])); // [3, 5]
console.log(bestSum(8, [1, 4, 5])); // [4, 4]
console.log(bestSum(100, [1, 2, 5, 25])); // [25, 25, 25, 25]