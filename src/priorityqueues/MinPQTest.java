package priorityqueues;

public class MinPQTest {
    public static void main(String[] args) throws PriorityQueueException {
        PriorityQueueMin<String> family = new PriorityQueueMin<>();
        family.insert("zishan", 3);
        family.insert("zainab", 6);
        family.insert("ramsha", 5);
        family.insert("abba", 1);
        family.insert("ammi", 2);
        family.insert("danish", 4);
        while (!family.isEmpty()){
           // System.out.println(family.getSize());
            //System.out.println(family.isEmpty());
            System.out.println(family.removeMin());
        }
        System.out.println("----------------------------------------------------------------");
        PriorityQueueMax<String> family1 = new PriorityQueueMax<>();
        family1.insert("zishan", 3);
        family1.insert("zainab", 6);
        family1.insert("ramsha", 5);
        family1.insert("abba", 1);
        family1.insert("ammi", 2);
        family1.insert("danish", 4);
        while (!family1.isEmpty()){
            // System.out.println(family.getSize());
            //System.out.println(family.isEmpty());
            System.out.println(family1.remove());
        }
    }
}
