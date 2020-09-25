function isValidSubsequence(array, sequence) {
    // time: O(n); space: O(1)
    let arrIndex = 0;
    let seqIndex = 0;

    while (arrIndex < array.length && seqIndex < sequence.length) {
        if (array[arrIndex] === sequence[seqIndex]) {
            seqIndex++;
        }
        arrIndex++;
    }
    return seqIndex === sequence.length;
}

// Do not edit the line below.
exports.isValidSubsequence = isValidSubsequence;



////////////////////////////////////////////////////////////////////\
function isValidSubsequence(array, sequence) {
    // time: O(n); space: O(1)
    let seqIndex = 0;
    for (const value of array) {
        if (seqIndex === sequence.length) {
            break;
        }
        if (sequence[seqIndex] === value) {
            seqIndex++;
        }
    }
    return seqIndex === sequence.length;
}

// Do not edit the line below.
exports.isValidSubsequence = isValidSubsequence;
