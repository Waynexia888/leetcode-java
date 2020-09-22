// The janitor of a high school is ectremely efficient. By the end of each day,
// all of the school's waste is in plastic bags weighting between 1.01 pounds and 
// 3.00 pounds. All plastic bags are then taken to the trash bins outside. One trip
// is described as selecting a number of bags which together do not weight more 
// than 3.00 pounds, dumping them in the outside trash can and returning to the
// school. Given the number of plastic bags n, and the weights of each bag, 
// determine the minimum number of trips the janitor has to make.

// example:
// n = 5, weigth = [1.01, 1.99, 2.5, 1.5, 1.01]

// the janitor can carry all plastic bags out in 3 trips:
// [1.01 + 1.99, 2.5, 1.5 + 1.01]

// complete the function efficientJanitor,
// return int: the minimum number of trips required

public int efficientJanitor(double[] weight, int n) {
    Arrays.sort(weight);
    int i = 0, j = weight.length - 1;
    int ans = 0;

    while (i <= j) {
        if (left == right) {
            ans++;
            break;
        }

        if (weight[i] + weight[j] <= 3.00) {
            i++;
            j--;
            ans++;
        } else {
            j--;
            ans++
        }
    }
    return ans;
}


// two pointers
// time: O(nlogn);
// space: O(1)