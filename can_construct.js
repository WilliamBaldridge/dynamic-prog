// brute force
// m = target.length, n = wordbank.length
// O(n^m * m) time
// O(m^2) space
// const canConstruct = (target, wordBank) => {

//     if (target === '') {
//         return true;
//     }

//     for (let word of wordBank) {

//         // getting prefix
//         if (target.indexOf(word) === 0) {
//             const suffix = target.slice(word.length);
//             if (canConstruct(suffix, wordBank) === true) {
//                 return true;
//             }
//         }
//     }

//     return false;
// };


// memoized
// O(n * m^2) time
// O(m^2) space
const canConstruct = (target, wordBank, memo = {}) => {

    if (target in memo) return memo[target];
    if (target === '') return true;

    for (let word of wordBank) {

        // getting prefix
        if (target.indexOf(word) === 0) {
            const suffix = target.slice(word.length);
            if (canConstruct(suffix, wordBank, memo) === true) {
                memo[target] = true;
                return true;
            }
        }
    }

    memo[target] = false;
    return false;
};


console.log(canConstruct("abcdef", ["ab", "abc", "cd", "def", "abcd"])); // true
console.log(canConstruct("skateboard", ["bo", "rd", "ate", "t", "ska", "sk", "boar"])); // false
console.log(canConstruct("enterapotentpot", ["a", "p", "ent", "enter", "ot", "o", "t"])); // true
console.log(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", [
    "e",
    "ee",
    "eee",
    "eeee",
    "eeeee",
    "eeeeee",
])); // false