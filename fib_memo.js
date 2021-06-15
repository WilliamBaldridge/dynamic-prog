// innefficient standard fib
// const fib = (n) => {
//     if (n <= 2) return 1;
//     return fib(n-1) + fib(n-2);
// };

// memoization
//   js object, keys will be argument to fn, value will be the return value
const fib = (n, memo = {}) => {

        if (n in memo) return memo[n];

        if (n <= 2) return 1;
        memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
        return memo[n];
    };



console.log(fib(6)); // 8
console.log(fib(7)); // 13
console.log(fib(8)); // 21
console.log(fib(50)); // 12586269025

// gridtraveler
// const gridTraveler = (m, n) => {

//     if (m === 1 && n === 1) return 1;
//     if (m === 0 || n === 0) return 0;
//     return gridTraveler(m - 1, n) + gridTraveler(m, n - 1);
// };

// memoization
const gridTraveler = (m, n, memo = {}) => {

    const key = m + ',' + n;
// are the args in the memo
    if (key in memo) return memo[key];
    if (m === 1 && n === 1) return 1;
    if (m === 0 || n === 0) return 0;

    memo[key] = gridTraveler(m - 1, n, memo) + gridTraveler(m, n - 1, memo);
    return memo[key];
};

console.log(gridTraveler(1, 1));  // 1
console.log(gridTraveler(2, 3));  // 3
console.log(gridTraveler(3, 2));  // 3
console.log(gridTraveler(3, 3));  // 6
console.log(gridTraveler(18, 18));  // 2333606220