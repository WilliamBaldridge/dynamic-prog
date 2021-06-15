// brute force
// m = target.length height of tree
// n = wordBank.length nodes
// O(n^m) time
// O(m) space

// const allConstruct = (target, wordBank) => {

//     if (target === '') return [[]];

//     const result = [];

//     for (let word of wordBank) {

//         if (target.indexOf(word) === 0) {

//             const suffix = target.slice(word.length)
//             const suffixWays = allConstruct(suffix, wordBank);
//             const targetWays = suffixWays.map(way => [ word, ...way ])
//             result.push(...targetWays); // spread again to avoid creating 3d array instead of 2d because push will nest the new array
//         }
//     }

//     return result;
// };



// memoized

const allConstruct = (target, wordBank, memo = {}) => {

    if (target in memo) return memo[target];
    if (target === '') return [[]];

    const result = [];

    for (let word of wordBank) {

        if (target.indexOf(word) === 0) {

            const suffix = target.slice(word.length)
            const suffixWays = allConstruct(suffix, wordBank, memo);
            const targetWays = suffixWays.map(way => [ word, ...way ])
            result.push(...targetWays); // spread again to avoid creating 3d array instead of 2d because push will nest the new array
        }
    }

    memo[target] = result;
    return result;
};


console.log(allConstruct("purple", ["purp", "p", "ur", "le", "purpl"])); 
// [ 
//    [ 'purp', 'le' ],
//    [ 'p', 'ur', 'p', 'le' ] 
// ]
console.log(allConstruct("abcdef", ["ab", "abc", "cd", "def", "abcd", "ef", "c"])); 
// [
//  [ 'ab', 'cd', 'ef' ],
//  [ 'ab', 'c', 'def' ],
//  [ 'abc', 'def' ],
//  [ 'abcd', 'ef' ]
// ]
console.log(allConstruct("enterapotentpot", ["a", "p", "ent", "enter", "ot", "o", "t"])); 
// [
//  [ 'enter', 'a', 'p', 'ot', 'ent', 'p', 'ot' ],
//  [
//    'enter', 'a',
//    'p',     'ot',
//    'ent',   'p',
//     'o',     't'
//   ],
//   [
//     'enter', 'a',
//     'p',     'o',
//     't',     'ent',
//     'p',     'ot'
//   ],
//   [
//     'enter', 'a',
//     'p',     'o',
//     't',     'ent',
//     'p',     'o',
//     't'
//   ]
console.log(allConstruct("skateboard", ["bo", "rd", "ate", "t", "ska", "sk", "boar"])); // []
console.log(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", [
    "e",
    "ee",
    "eee",
    "eeee",
    "eeeee",
    "eeeeee",
])); // []