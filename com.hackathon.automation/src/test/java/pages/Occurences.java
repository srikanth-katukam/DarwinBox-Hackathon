package pages;

import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by Skatukam on 10/9/2017.
 */
public class Occurences {

    @Test
    public void test()
    {
        String test = "Srikanth Katukam is a good boy";
        HashMap<Character,Integer>  ObjMap= new HashMap<Character,Integer>();
        char arr2[] =test.toCharArray();
        for(char c:arr2)
        {
            if(ObjMap.containsKey(c))
            {
                ObjMap.put(c,ObjMap.get(c)+1);
            }
            else
                ObjMap.put(c,1);
        }
        System.out.println(ObjMap);
    }



}
