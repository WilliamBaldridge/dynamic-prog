// m = 
// n = 
// O(m^2 * n)
// O(m^2)

const bestSum = (targetSum, numbers) => {

    const table = Array(targetSum + 1).fill(null);
    table[0] = [];

    for (let i = 0; i <= targetSum; i += 1) {

        if (table[i] !== null) {
            for (let num of numbers) {

                const combo =  [ ...table[i], num];
                // if current combo is shorter than what is currently stored
                if(!table[i + num] || table[i + num].length > combo.length) {
                    table[i + num] = combo;
                }
                
            }
        }
    }

    return table[targetSum];
};


console.log(bestSum(7, [5, 3, 4, 7])); // [7]
console.log(bestSum(8, [2, 3, 5])); // [3, 5]
console.log(bestSum(8, [1, 4, 5])); // [4, 4]
console.log(bestSum(100, [1, 2, 5, 25])); // [25, 25, 25, 25]