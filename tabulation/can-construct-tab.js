// m = target
// n = wordBank.length
// O(m^2 * n) time
// O(m^2) space

const canConstruct = (target, wordBank) => {

    const table = Array(target.length + 1).fill(false);
    table[0] = true;

    for (let i = 0; i <= target.length; i += 1) {

        if (table[i] === true) {
            for (let word of wordBank) {
                // if word matches chars at position i
                if (target.slice(i, i + word.length) === word) {
                    
                    table[i + word.length] = true;
                }
            }
        }
    }

    return table[target.length];
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