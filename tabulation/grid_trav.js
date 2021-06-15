// O(mn) time
// O(mn) space

const gridTraveler = (m, n) => {

    const table = Array(m + 1)
    .fill()
    .map(() => Array(n + 1).fill(0)); // need map to fill with multiple sub Arrays, instead of same array multi times if Array(n + 1) was inside fill()

    table[1][1] = 1;

    for (let i = 0; i <= m; i++) {
        for (let j = 0; j <= n; j++) {

            const current = table[i][j];
            // logic checks for out of bounds of grid and adds to down and right
            if (j + 1 <= n) table[i][j + 1] += current;
            if (i + 1 <= m) table[i + 1][j] += current;
    } 
}
    
    return table[m][n]
};


console.log(gridTraveler(1, 1));  // 1
console.log(gridTraveler(2, 3));  // 3
console.log(gridTraveler(3, 2));  // 3
console.log(gridTraveler(3, 3));  // 6
console.log(gridTraveler(18, 18));  // 2333606220