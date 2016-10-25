/**
 * 
 */
package cfBotChallenge;

import java.util.HashMap;
import java.util.Map;

/**
 * Debugger.java 
 * @author Basava R.Kanaparthi(basava.08@gmail.com)
 * Created on Mar 28, 2016
 */
public class Debugger {

	String[] taskMaker(String[] source, int challengeId) {
	    
	    String match = "//DB " + challengeId;
	    String comment = "//DB";
	    
	    Map<Integer,String> map = new HashMap<>();
	    int j = 0;
	    String replace = "";
	    for (int i = 0; i < source.length; i++)
	    {
	        if (source[i].contains(comment))
	        {
	            if(source[i].contains(match))
	            {
	                String[] parts = source[i].split("\\//");
	                replace = parts[0] + parts[2];
	                System.out.println(replace + " "+j);
	                map.put(j-1, replace);
	            }
	        } 
	        else
	        {
	            map.put(j++, source[i]);
	        }
	    }
	    /*System.out.println(result.length);
	    for(String s : result)
	    {
	        System.out.println(s);
	    }*/

	    String[] res = new String[map.size()];
	    res = map.values().toArray(res);
	    
	    return res;
	}

}
