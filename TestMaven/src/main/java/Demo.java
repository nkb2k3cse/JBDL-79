import java.util.*;

public class Demo {



    public static void main(String[] args) {

        String first = "CDAFB";
        String second = "AFB";
        System.out.println(first.contains(second));
        System.out.println(first.substring(2,2));

        char tempArray[] = first.toCharArray();
        Arrays.sort(tempArray);
        System.out.println(new String(tempArray));

        //String x = new String (Arrays.sort(first.toCharArray()));

        Map<Character,Character> hm = new HashMap<>();

        ArrayList<Integer> arrayList = new ArrayList<>(List.of(11,12,13,11));
        arrayList.add(1);
        arrayList.add(4);
        arrayList.add(4);
        arrayList.add(9);

        System.out.println("array list: " + arrayList);
        HashSet<Integer> hs = new HashSet<>(arrayList);
        System.out.println("set: " + hs);

        System.out.println((int)Math.max(1,2));

        LinkedHashSet<Integer> H = new LinkedHashSet<>(arrayList);

        String s1 = "abc";
        //System.out.println(s1.charAt());

        //H.add(1);
       // H.add(4);

        int arr[] = {10, 20, 30, 40, 50};
        for(int i=0; i < arr.length; i++)
        {
            System.out.print(" " + arr[i]);
        }

        String s11 = "abc";
        String s2 = "abc";
        char[] t1 = s1.toCharArray();
        char[] t2 = s1.toCharArray();

        Arrays.sort(t1);
        Arrays.sort(t2);

        //System.out.println(Collections.eq);

        LinkedList<Integer>  l1 = new LinkedList<>(Arrays.asList(1,2,3,4));
        LinkedList<Integer>  l2= new LinkedList<>(Arrays.asList(1,2,3,4));

        System.out.println(l1);
        int len = l1.size();
        for (int i=0 ; i<len ; i++){
            //System.out.println(l1.get(i));
            int x = l1.remove(i);
            l1.addLast(i);

        }
        System.out.println(l1);
        List<Character> list = new ArrayList<>();

        list.add('a');
        list.add('1');
        list.add('z');
        list.add('y');

        System.out.println(Collections.min(list));

        Student student1 = Student.getBuilder().setName("Neeraj").setAge(35).
                setPsp(75).setEmail("nkb2k3cse@gmail.com")
                .setUniversity("BIT")
                .build();

        System.out.println(student1);

        SampleStaticClassTest st1 = new SampleStaticClassTest("Hari",23);
        System.out.println(st1);


    }
}
