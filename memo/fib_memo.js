// Memoization is iterative, recursive tree

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