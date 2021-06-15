// howSum brute force
// m = targetSum, n = numbers.length
//  O(n^m * m) time
//  O(m) space because returning just 1 array result

// const howSum = (targetSum, numbers) => {

//     if (targetSum === 0) return [];
//     if (targetSum < 0) return null;

//     for (let num of numbers) {
//         const remainder = targetSum - num;
//         const remainderResult = howSum(remainder, numbers);

//         if (remainderResult !== null) {
//             return [ ...remainderResult, num ];
//         }
//     }

//     return null;
// };


// memoization
// O(n * m^2) time ((n * m) * m)
// O(m^2) space
const howSum = (targetSum, numbers, memo = {}) => {

    if (targetSum in memo) return memo[targetSum];
    if (targetSum === 0) return [];
    if (targetSum < 0) return null;

    for (let num of numbers) {
        const remainder = targetSum - num;
        const remainderResult = howSum(remainder, numbers, memo);

        if (remainderResult !== null) {
            memo[targetSum] = [ ...remainderResult, num ];
            return memo[targetSum];
        }
    }

    memo[targetSum] = null;
    return null;
};

console.log(howSum(7, [2, 3]));  // [3, 2, 2]
console.log(howSum(7, [5, 3, 4, 7]));  // [4, 3]
console.log(howSum(7, [2, 4]));  //  null
console.log(howSum(8, [2, 3, 5])); // [2, 2, 2, 2]  return will be based on order (i.e. [3, 2, 5] will give 2, 3, 3 by using 3 first)
console.log(howSum(300, [7, 14]));  // null