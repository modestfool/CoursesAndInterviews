package IBM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: basavakanaparthi
 * on 21,Oct,2016 at 10:44 PM.
 */
public class SubPassage {
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//
//        String s;
//
//        while ((s = in.readLine()) != null) {
//
//            System.out.println(s);
//
//            String[] paras = s.split("\\|");
//
//            String[] temp = new String[paras.length];
//
//            System.arraycopy(paras, 0, temp, 0, paras.length);
//
//            System.out.println(paras[0]);
//            boolean[] filterParagraphs = new boolean[paras.length];
//
//            for (int i = 0; i < temp.length; i++) {
//
//                temp[i] = temp[i].replaceAll(" +", " ");
//
//                temp[i] = temp[i].replaceAll("[^A-Za-z0-9 ]", "");
//
//                temp[i] = temp[i].trim();
//
//                temp[i] = temp[i].toLowerCase();
//
//                System.out.println("Passage: " + temp[i]);
//
//            }
//
//            String[] output = new String[paras.length];
//
////            System.out.println(output.toString());
//
//            for (int i = 0; i < temp.length; i++) {
//
//                output[i] = paras[i];
//
//            }
//
//            for (int i = 0; i < temp.length; i++) {
//
//                for (int j = i + 1; j < temp.length; j++) {
//
//                    if (i != j) {
//                        if(temp[i].equals(temp[j]))
//                        {
//                            if(paras[i].length() > paras[j].length())
//                                filterParagraphs[i] = true;
//                            else
//                                filterParagraphs[j] = true;
//                        }
//                        if (temp[i].contains(temp[j])) {
//
//                            output[j] = "";
//                            filterParagraphs[j] = true;
//
//                        } else if (temp[j].contains(temp[i])) {
//
//                            output[i] = "";
//                            filterParagraphs[i] = true;
//
//                        }
//
//                    }
//
//                }
//
//            }
//
//            String str = "";
//
//            for (int i = 0; i < paras.length; i++) {
//
//                if (!output[i].isEmpty() && output[i] != null) {
//
////                    System.out.println(output[i]);
//
//                    str += (paras[i] + "|");
//
//                }
//
//            }
//
////            if (str.length() > 0) {
////
////                str = str.substring(0, str.length() - 1);
////
////            }
//            System.out.println(Arrays.toString(temp));
//            System.out.println(Arrays.toString(filterParagraphs));
//            System.out.println(str);
//
//        }
//
//    }

    public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String s;
    while ((s = in.readLine()) != null)
    {
        String[] paragraphs = s.split("\\|");
        String[] tempPar = new String[paragraphs.length];
        boolean[] filterParagraph = new boolean[paragraphs.length];

        System.arraycopy(paragraphs, 0, tempPar, 0, paragraphs.length);

        for (int i = 0; i < tempPar.length; i++)
        {
            tempPar[i] = tempPar[i].replaceAll(" +", " ");

            tempPar[i] = tempPar[i].replaceAll("[^A-Za-z0-9 ]", "");

            tempPar[i] = tempPar[i].trim();

            tempPar[i] = tempPar[i].toLowerCase();
        }

        for (int i = 0; i < tempPar.length; i++)
        {
            for (int j = i + 1; j < tempPar.length; j++)
            {
                if (i != j)
                {
                    if(tempPar[i].equals(tempPar[j]))
                    {
                        if(paragraphs[i].length() > paragraphs[j].length())
                            filterParagraph[i] = true;
                        else
                            filterParagraph[j] = true;
                    }
                    else if (tempPar[i].contains(tempPar[j]))
                    {
                        filterParagraph[j] = true;
                    }
                    else if (tempPar[j].contains(tempPar[i]))
                    {
                        filterParagraph[i] = true;
                    }
                }
            }
        }

        StringBuilder outSB = new StringBuilder();
        for(int i = 0; i < paragraphs.length; i++)
        {
            if (!filterParagraph[i])
            {
                outSB.append(paragraphs[i]).append("|");
            }
        }
        if (outSB.length() > 0)
            System.out.println(outSB.substring(0,outSB.length()-1));
    }
    }
}