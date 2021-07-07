public static boolean test(String s) {
    // corner case
    if (s == null || s.length() == 0) {
        return false;
    }

    // create our own currency symbols
    String symbols = "DEY";

    // check if the given string is negative amount(two types: ($450) or -$450) or not
    if (s.charAt(0) == '(') {
        if (s.charAt(s.length() - 1) != ')') {
            return false;
        }
        s = s.substring(1, s.length() - 1); // remove the leading and trailing parentheses '(', ')'
    } else if (s.charAt(0) == '-') {
        s = s.substring(1);  // remove the negative sign before the currency symbol
    }

    // if the currency symbol not found, return false
    if (symbols.indexOf(s.charAt(0)) == -1) {
        return false;
    }

    // Yen amounts may not contain decimal points 
    if (s.charAt(0) == 'Y' && s.indexOf('.') != -1) {
        return false;
    }

    // remove the currency symbol
    s = s.substring(1);

    // if there is no digits, return false
    int n = s.length();
    if (n == 0) {
        return false;
    }

    int decIndex = n;
    boolean checkComma = false;
    for (int i = n - 1; i >= 0; i--) {
        char c = s.charAt(i);
        if (c == '.') {
            // 4,500.0   4,500.00    4,500.0000
            // if the length of substring after '.' is not exact 2, return false
            if (decIndex - 1 - i != 2) {
                return false;
            }
            decIndex = i;
        } else if (c == ',') {
            if ((decIndex - i) % 4 != 0) {
                return false;
            }
            checkComma = true;
        } else if (!Charatcer.isDigit(c)) {
            return false;
        }

        if (checkComma) {
            if ((decIndex - i) % 4 == 0 && c != ',') {
                return false;
            }
        }
    }

    if (s.charAt(0) == '0' && decIndex != 1) {
        return false;
    }
    return true;
}

/////////////////////////////////////////////////////////////////////

public class Solution {
    /**
     * @param currency: a string represents a valid or invalid currency amount
     * @return: return whether the given string is a valid currency
     */
    public boolean validCurrencyAmount(String currency) {
        // do not modify the given input
        String s = currency;

        // if the first character is a negative sign '-'
        if (s.charAt(0) == '-') {
            s = s.substring(1);
            return check1(s);
        }

        // if the first character is '('
        if (s.charAt(0) == '(') {
            if (s.charAt(s.length() - 1) != ')') {
                return false;
            }
            s = s.substring(1, s.length() - 1);
            return check1(s);
        }

        // if the first character is not a negative sign '-' or parentheses 
        return check1(s);
    }

    // check1() -> to check the currency symbol
    public boolean check1(String s) {
        // the first character must be a currency symbol
        if (s.charAt(0) != 'D' && s.charAt(0) != 'E' && s.charAt(0) != 'Y') {
            return false;
        }

        // if the first character is 'Y', it cannot contains any decimal points '.'
        if (s.charAt(0) == 'Y') {
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == '.') {
                    return false;
                }
            }
        }
        
        // remove the currency symbol, and write a helper method check2(s) to check the rest
        return check2(s.substring(1));
    }

    // 查验小数点和小数部分
    public boolean check2(String s) {
        int n = s.length();
        // if the length of string is 0, return false
        if (n == 0) {
            return false;
        }

        // if the string contains any invalid character, return false
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c != '.' && c != ',' && !Character.isDigit(c)) {
                return false;
            }
        }

        // 除了0 或者0.xx之外， 有leading zero? return false
        if (s.charAt(0) == '0' && (!s.equals("0") && s.charAt(1) != '.')) {
            return false;
        }

        // 统计有多少个小数点
        int flag = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '.') {
                flag++;
            }
        }

        // 有两个小数点？ false
        if (flag >= 2) {
            return false;
        }
        // 有一个小数点但是长得不像xxxx.xx? false
        if (flag == 1) {
            if (n < 4) {
                return false;
            }

            if (s.charAt(n - 3) != '.') {
                return false;
            }

            if (!Character.isDigit(s.charAt(n - 1)) || !Character.isDigit(s.charAt(n - 2))) {
                return false;
            }
            s = s.substring(0, n - 3);
        }

        // 切掉小数部分再查验
        return check3(s);
    }

    // 查验分隔符和整数部分
    public boolean check3(String s) {
        //第一位不能是分隔符
        if (!Character.isDigit(s.charAt(0))) {
            return false;
        }

        int n = s.length();
        int flag = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ',') {
                flag++;
                break;
            }
        }

        // 没有分隔符，return true
        if (flag == 0) {
            return true;
        }

        // 分隔符位置不对，返回false
        for (int i = n - 1; i >= 0; i--) {
            if ((n - i) % 4 != 0 && s.charAt(i) == ',') {
                return false;
            }
            if ((n - i) % 4 == 0 && s.charAt(i) != ',') {
                return false;
            }
        }
        return true;
    }
}