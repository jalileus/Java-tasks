import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kmp {
    public static int[] getLpc(String substring, int subStringSize){
    int[] lps = new int[subStringSize];
    int len = 0;
    lps[0] = 0;
    int i = 1;

    while(i < subStringSize) {
        if(substring.charAt(i) == substring.charAt(len)) {
            len++;
            lps[i] = len;
            i++;
        }
        else {
            if(len != 0){
                len = lps[len - 1];
            }
            else {
                lps[i] = 0;
                i++;
            }
        }
    }
    return lps;
}

public static void  kmpSearch(String subString, String text) {

    int subStringSize = subString.length();
    int textSize = text.length();


    int[] lps = getLpc(subString, subStringSize);

    int i = 0;
    int j = 0;

    while ((textSize - i) >= (subStringSize - j)) {
        if(subString.charAt(j) == text.charAt((i))) {
            i++;
            j++;
        } 
        if(j == subStringSize) {
            System.out.print(i - j + " ");
            j = lps[j - 1];
        }
        else if (i < textSize && subString.charAt(j) != text.charAt(i)) {
            if (j != 0){
                j = lps[j - 1];
            }
            else {
                i = i + 1;
            }
        }
    }
}
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String subString = reader.readLine();
        String text = reader.readLine();
        kmpSearch(subString, text);
        reader.close();
    }
}



