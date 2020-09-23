// I, II, III, IV, V, VI, VII, VIII, IX, and X represent 1 through 10.
// XX, XXX, XL, and L are 20, 30, 40, and 50
// For any other two-digit number < 50, concatenate the Roman numerals that 
// represent its multiples of ten with the Roman numerals for its values < 10.
// For example, 43 is 40 + 3 = "XL" + "III" = "XLIII"

Given a list of strings comprised of a name and a Roman numeral, sort the list 
first by name, then by decimal value of the Roman numeral.

// for example, if you are given the names 
// [Steven XL, Steven XVI, David IX, Mary XV, Mary XIII, Mary XX],
// the result of the sort is 
// [David IX, Mary XIII, Mary XV, Mary XX, Steven XVI, Steven XL]

// IX: 9, XIII: 13, XV: 15, XX: 20, XVI: 16, XL: 40

// complete the function sortRoman, The function must return the array sorted 
// first by given name, then by ordinal



// https://github.com/spkenn5/royal-sorter/blob/master/src/Main.java
public static String[] sortRoman(String[] names) {
    // String[] array = new String[names.length];
    // int index = 0;
    // for (String name : names) {
    //     array[index++] = name.split(" ")
    // }

    Collections.sort(list, new Comparator<String[]>() {
        
    })
}