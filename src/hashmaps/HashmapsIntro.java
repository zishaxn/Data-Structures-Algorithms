package hashmaps;

import java.util.HashMap;
import java.util.Set;

public class HashmapsIntro {
    public static void main(String[] args) {

        //Creating a Hashmap object of Key Type String and Value Type Integer
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Zishan", 23); //Inserting Element in hashmap using put method.
        map.put("Danish", 22);
        map.put("Danish",21);
        System.out.println(map.size());
        //containsKey method return boolean if given key is present in map or not//
        if (map.containsKey("Zishan")) {
            System.out.println("ZISHAN PRESENT");
        } else {
            System.out.println("ZISHAN ABSENT");
        }

        boolean present = map.containsKey("Zishan");
        System.out.println(present);

        int v = map.get("Zishan");  // get Method Returns the Value of The given key.
        System.out.println(v);

        /*we should always write get function only after checking if key is present or not.
        following code will throw a null pointer error as we are trying to access the value of key that is absent*/
//        int v1 = map.get("Zainab");
//        System.out.println(v1);

        //correct method
        int v1 = 0;
        if(map.containsKey("Zainab")){
            v1=map.get("Zainab");
        }
        System.out.println(v1);

        //Removing a Key from hashmap
       // map.remove("Zishan");
        if (map.containsKey("Zishan")) {
            System.out.println("ZISHAN PRESENT");
        } else {
            System.out.println("ZISHAN ABSENT");
        }


        //iterate over keys
        Set<String> keys = map.keySet();
        for(String s : map.keySet()){
            System.out.println(s);
        }
        System.out.println(map);
    }
}
