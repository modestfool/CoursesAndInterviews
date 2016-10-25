package Microsoft;
import java.io.*;
import java.nio.charset.Charset;


/*
    "Agent Jimmy Bonds? You are a master of obfuscation and the best person for this job. We have a secret message to convey to our friends on the other side of the galaxy, but can't risk anyone else knowing about it. We need your help implementing a Vigenere cipher."

A Vigenere cipher takes plaintext and encrypts it into ciphertext by cyclically applying a cipher key. The encryption adds letter values modulo 26, where A=0, B=1, C=2, .... GOODBYE (6, 14, 14, 3, 1, 24, 4) encrypted with HELLO (7, 4, 11, 11, 14) will give NSZOPFI as the ciphertext (13, 18, 25, 14, 15, 5, 8):

  GOODBYE
+ HELLOHE
  -------
  NSZOPFI
Input definition

An input file for this problem will contain an arbitrary number of lines.

Each line will contain a 64-char plaintext message, a vertical pipe ('|') separator, and a 10-char Vigenere cipher key.

The plaintext message could contain any character between [a-z], any character between [A-Z], and any character in this set: "!@#$%^&*()_-+=[{]};:<>./? ".

The Vigenere cipher key will only contain characters between [A-Z].

As we are a highly secretive agency, the plaintext message might not look very plain -- do not worry, we have just pre-obfuscated it.

Output definition

An output file for this problem should contain the same number of lines as the corresponding input.

Each line should be a 64-char encrypted ciphertext that is the result of applying the 10-char Vigenere cipher key to the 64-char plaintext. Only the characters [a-z] and [A-Z] should be encrypted and the original letter casing of the input should be preserved in the output. Characters not within this range should be transmitted without further obfuscation.

Example input

This -- is a secret message! Shhh. Never tell anyone what I did.|SECRETKEYS
Example output

Llkj -- ml k wcujiv dilceew! Kljy. Rxfip lwpn rrryrc ozev Z hbn.
 */


class TopSecret
{
    public static void main(String[] args)
    {
//        Scanner in = new Scanner(System.in);

        String line;
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("the-file-name.txt", "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try (
                InputStream fis = new FileInputStream("the_file_name");
                InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
                BufferedReader br = new BufferedReader(isr);
        ) {
            while ((line = br.readLine()) != null)
            {
                String[] parts = line.split("|");
                encryptLine(parts[0], parts[1],writer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (writer != null)
            writer.close();
    }

    private static void encryptLine(String plainText, String key, PrintWriter writer)
    {
            int keyIndex = 0;
            char[] keys = key.toCharArray();
            StringBuilder encrypted = new StringBuilder();
            for (char c: plainText.toCharArray())
            {
                if (((int)c - (int)'a' <=25) && ((int)c - (int)'a' >=0))
                {
                    c = (char)(( (int)c - (int)'a' + (int)keys[keyIndex%keys.length] - (int)'a')%26 + (int) 'a');
                    keyIndex++;
                }
                else if (((int)c - (int)'A' <=25) && ((int)c - (int)'A' >=0))
                {
                    c = (char)(( (int)c - (int)'A' + (int)keys[keyIndex%keys.length] - (int)'A')%26 + (int) 'A');
                    keyIndex++;
                }
                encrypted.append(c);
            }
    }
}