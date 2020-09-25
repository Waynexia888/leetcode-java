function twoNumberSum(array, targetSum) {
    // use hashmap/ object;
    const exist = {};
    for (let i = 0; i < array.length; i++) {
        const nums = targetSum - array[i];
        if (exist[nums]) {
            return [array[i], nums];
        } else {
            exist[array[i]] = true;
        }
    }
    return [];
}

// Do not edit the line below.
exports.twoNumberSum = twoNumberSum;

// time: O(n); space: O(n)
