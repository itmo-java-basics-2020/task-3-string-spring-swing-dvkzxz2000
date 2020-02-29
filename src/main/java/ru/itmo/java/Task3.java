package ru.itmo.java;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if(inputArray == null || inputArray.length == 0) {
            return new int[]{};
        }
        else {
            int[] newInputArray = new int[inputArray.length];
            int last = inputArray[inputArray.length - 1];
            System.arraycopy(inputArray, 0, newInputArray, 1, inputArray.length - 1);
            newInputArray[0] = last;
            return newInputArray;
        }
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     *
     * Если входной массив пуст или равен null - вернуть 0
     *
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if(inputArray == null || inputArray.length == 0) {
            return 0;
        }
        else {
            int max1 = 0;
            int max1i = 0;
            int max2 = 0;
            for(int i = 0; i < inputArray.length; i++) {
                if (inputArray[i] > max1) {
                    max1 = inputArray[i];
                    max1i = i;
                }
            }
            for(int i = 0; i < inputArray.length; i++) {
                if(inputArray[i] > max2 && i != max1i) {
                    max2 = inputArray[i];
                }
            }
            return max1 * max2;
        }
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     *
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        } else {
            int a = 0;
            int b = 0;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == 'a' || input.charAt(i) == 'A') {
                    a++;
                }
                if (input.charAt(i) == 'b' || input.charAt(i) == 'B') {
                    b++;
                }
            }
            return ((a + b) * 100) / input.length();
        }
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if(input == null) {
            return false;
        }
        else {
            int x = 0;
            for(int i = 0; i < input.length(); i++) {
                if(input.charAt(i) == input.charAt(input.length() - i - 1)) {
                    x++;
                }
            }
            if(x == input.length()) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if(input == null || input.length() == 0) {
            return "";
        }
        String result= "" + input.charAt(0);
        int x = 1;
        for(int i = 1; i < input.length(); i++) {
            if(input.charAt(i -1) != input.charAt(i)) {
                result += x;
                x = 1;
                result += input.charAt(i);
            }
            else {
                x++;
            }
        }
        return result + x;
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if(two == null || one == null || one.length() == 0 || two.length() == 0 || one.length() != two.length()) {
            return false;
        }
        boolean[] result = new boolean[two.length()];
        for(int i = 0; i < one.length(); i++) {
            for(int j = 0; j < two.length(); j++) {
                if(one.charAt(i) == two.charAt(j) && !result[j]) {
                    result[j] = true;
                    break;
                }
            }
        }
        for(int i = 1; i < result.length; i++) {
            result[0] &= result[i];
        }
        return result[0];
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if(s == null || s.length() == 0) {
            return false;
        }
        int[] a = new int['z' + 'Z' + 1];
        for(int i = 0; i < s.length(); i++) {
            a[s.charAt(i)]++;
            if(a[s.charAt(i)] > 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     *
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if(m == null || m.length == 0 || m[0].length == 0) {
            return new int[][]{{},{}};
        }
        else {
            for (int i = 0; i < m.length; i++) {
                for (int j = i+1; j < m[0].length; j++) {
                    int temp = m[i][j];
                    m[i][j] = m[j][i];
                    m[j][i] = temp;
                }
            }
            return m;
        }
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     *
     * Запрещается пользоваться функций join
     *
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if(inputStrings == null) {
            return "";
        }
        else{
            if(separator == null) {
                String result1 = "";
                for(int i = 0; i < inputStrings.length; i++) {
                    result1 = result1 + inputStrings[i] + " ";
                }
                String newResult1 = "";
                for(int i = 0; i < result1.length() - 1; i++) {
                    newResult1 += result1.charAt(i);
                }
                return newResult1;
            }
            else{
                String result = "";
                for(int i = 0; i < inputStrings.length; i++) {
                    result = result + inputStrings[i] + separator;
                }
                String newResult = "";
                for(int i = 0; i < result.length() - 1; i++) {
                    newResult += result.charAt(i);
                }
                return newResult;
            }
        }
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if(inputStrings == null || prefix == null) {
            return 0;
        }
        else {
            int res = 0;
            for(int i = 0; i < inputStrings.length; i++) {
                String s = inputStrings[i];
                if(prefix.equals(s.substring(0, prefix.length()))) {
                    res++;
                }
            }
            return res;
        }
    }
}
