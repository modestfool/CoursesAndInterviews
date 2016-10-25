package Twitter;

import java.util.*;

/**
 * @author: basavakanaparthi
 * on 12,Oct,2016 at 12:09 AM.
 */
public class HackingTime {
    static String decrypt(String encrypted_message) {
        Integer[] keyAlice = getKey();
        if (keyAlice == null) {
            System.out.println("Couldn't get the key.");
            return encrypted_message;
        }
        System.out.println(Arrays.toString(keyAlice));
        int keyInd = 0; // current index of the key.
        StringBuilder sb = new StringBuilder();
        for (char c : encrypted_message.toCharArray()) {

            if (Character.isUpperCase(c)) {
                c = (char) ((c - 'A' - keyAlice[keyInd] + 26) % 26 + 'A');
                keyInd = (keyInd + 1) % keyAlice.length;
            } else if (Character.isLowerCase(c)) {
                c = (char) ((c - 'a' - keyAlice[keyInd] + 26) % 26 + 'a');
                keyInd = (keyInd + 1) % keyAlice.length;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    static Integer[] getKey() {
        String signature = "Your friend, Alice";
        String encryptedSign = "Atvt hrqgse, Cnikg";
        String encrypted = "Otjfvknou kskgnl, K mbxg iurtsvcnb ksgq hoz atv. " +
                "Vje xcxtyqrl vt ujg smewfv vrmcxvtg rwqr ju vhm ytsf elwepuqyez. -Atvt hrqgse, Cnikg";

        int offSet = 0;
        for (int i = 0; i < encrypted.length(); i++) {
            if (Character.isAlphabetic(encrypted.charAt(i)) && !encrypted
                    .substring(i).equals(encryptedSign))
                offSet++;
            if (encrypted.substring(i).equals(encryptedSign))
                break;
        }
        ArrayList<Integer> keyList = new ArrayList<>();
        for (int i = 0; i < signature.length(); i++) {
            if (Character.isAlphabetic(signature.charAt(i)))
            {
                int k = (encryptedSign.charAt(i) - signature.charAt(i) + 26) % 26;
                keyList.add(k);
            }
        }
        // At least two repitions of keys are needed to positively identify
        // the key. Start from largest possible key length upto 1.
        int seqLength = keyList.size() / 2;
        while (seqLength > 0) {
            Integer[] keyAlice = getConstituentKeys(keyList, seqLength);
            if (keyAlice != null) {
                List<Integer> a = Arrays.asList(keyAlice);
                Collections.rotate(a, offSet % 7);
                keyAlice = a.toArray(new Integer[keyAlice.length]);
                return keyAlice;
            }
            seqLength--;
        }
        return null;
    }

     static Integer[] getConstituentKeys(ArrayList<Integer> keys, int
            sequenceLength) {
        if (keys == null || keys.size() == 0 || sequenceLength <= 0 ||
                sequenceLength >=
                        keys.size()) {
            System.out.println("Invalid input");
        } else {
            int i = 0;
            int j = i + sequenceLength;
            int upperBound = (keys.size() / sequenceLength) *
                    sequenceLength;
            Set<List<Integer>> tempSet = new HashSet<>();
            while (j <= upperBound) {
                if (!tempSet.add(keys.subList(i, j))) {
                    Integer[] keyAlice = new Integer[j - i];
                    keyAlice = keys.subList(i, j).toArray(keyAlice);
                    return keyAlice;
                }
                i++;
                j = i + sequenceLength;
            }

        }
        return null;
    }

    public static void main(String[] args)
    {
        System.out.println(decrypt("Bjj rwkcs dwpyp fwz ovors wxjs vje tcez fqg"));
        System.out.println(decrypt("Atvt hrqgse, Cnikg"));
        String encrypted = "Otjfvknou kskgnl, K mbxg iurtsvcnb ksgq hoz atv. " +
                "Vje xcxtyqrl vt ujg smewfv vrmcxvtg rwqr ju vhm ytsf elwepuqyez. -Atvt hrqgse, Cnikg";
        System.out.println(decrypt(encrypted));
        getKey();
    }
}
