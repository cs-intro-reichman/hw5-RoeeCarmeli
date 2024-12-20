/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        String hell = "hlle";
        System.out.println(countChar(hello, 'h'));
        System.out.println(countChar(hello, 'l'));
        System.out.println(countChar(hello, 'z'));
        System.out.println(subsetOf(hell, hello));
        System.out.println(spacedString(hello));
        System.out.println(randomStringOfLetters(5));
        System.out.println(remove(hello, hell));
        System.out.println(insertRandomly('c', hell));
        //// Put your other tests here.
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        String newStr = lowerCase(str);
        int count = 0;
        for(int i = 0; i <= str.length(); i++){
            if (newStr.charAt(i) == ch) count++;
        }
        return count;
    }

    // Makes sure all the characters are lowercased
    public static String lowerCase(String str) {
        String newString = " ";
        char ch;
        for(int i = 0; i < str.length(); i++){
            ch = str.charAt(i);
            if (ch > 64 && ch < 96) {
                newString = newString + (char) (str.charAt(i) + 32);
            }
            else newString = newString + ch;
        }
        return newString;
    }
    
    //
    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns true
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
        str1 = lowerCase(str1);
        str2 = lowerCase(str2);
        char [] bases = {'a' , 'b' , 'c' , 'd' , 'e' , 'f' , 'g' , 'h' , 'i' , 'j'
         , 'k' , 'l' , 'm' , 'n' , 'o' , 'p' , 'q' , 'r' , 's' , 't' , 'u' , 'v'
         , 'w' , 'x' , 'y' , 'z'};
        int [] freq1 = new int [bases.length];
        int [] freq2 = new int [bases.length];

        for (int i = 0; i < str1.length(); i++){
            for (int j = 0; j < bases.length; j++){
                if (str1.charAt(i) == bases[j]) freq1[j]++;
            }
        }

        for (int i = 0; i < str2.length(); i++){
            for (int j = 0; j < bases.length; j++){
                if (str2.charAt(i) == bases[j]) freq2[j]++;
            }
        }

        for (int i = 0; i < bases.length; i++){
            if (freq1[i] > freq2[i]) return false;
        }
        return true;
    }

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {       
        int count = str.length();
        String newStr = "";
        for (int i = 0; i < count - 1; i++){
        newStr = newStr + str.charAt(i);
        newStr = newStr + " ";
       }
       if (count > 0) newStr = newStr + str.charAt(count - 1);
       return newStr;
    }
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        String str = "";
        char ch;
        for(int i = 0; i < n; i++){
            ch = (char) ((Math.random() * 26) + 97);
            str = str + ch;
        }
        return str;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit" 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
        String newStr = "";
        char [] bases = {'a' , 'b' , 'c' , 'd' , 'e' , 'f' , 'g' , 'h' , 'i' , 'j'
         , 'k' , 'l' , 'm' , 'n' , 'o' , 'p' , 'q' , 'r' , 's' , 't' , 'u' , 'v'
         , 'w' , 'x' , 'y' , 'z'};
         int [] freq = new int [bases.length];
         
         for ( int i = 0; i < str2.length(); i++){
            for (int j = 0; j < bases.length; j++){
                if (str2.charAt(i) == bases[j]) freq[j]++;
            }
         }

         for (int i = 0; i < str1.length(); i++){
            if (freq[(int) str1.charAt(i) - 97] == 0){
                newStr = newStr + str1.charAt(i);
            } 
            else freq[(int) str1.charAt(i) - 97]--;
         }

        return newStr;
    }

    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
         // Generate a random index between 0 and str.length()
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         // Insert the character at the random index
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
         return result;
    }    
}
