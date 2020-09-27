/**
  *SetTest has a basic main method that does
  *basic sanity testing
  *@author Matt Gruchacz
  *@version 4 3/26/14
  **/

public class SetTest {
    /**
      *Basic tests executed in mian
      *@param args - the ignored command line arguments
      */
    public static void main(String... args) {

        //sanity add test
        GenericSet<Integer> add = new GenericSet<>();
        for (int i = 0; i < 1000; i++) {
            add.add(i);
            add.addAll(add);
        }

        if (add.size() == 1000) {
            System.out.println("Sanity add passed");
        } else {
            System.out.println("Sanity add failed");
        }


        //powerset test
        GenericSet<Integer> ps = new GenericSet<>();
        for (int i = 0; i < 10; i++) {
            ps.add(i);
        }
        ExtendedSet<ExtendedSet<Integer>> powerSet = ps.powerSet();
        if (powerSet.size() == 1024) {
            System.out.println("powerSet size correct");
        } else {
            System.out.println("powerSet size incorrect");
        }






        //Map Reduce Filter test
        GenericSet<Integer> set = new GenericSet<>();
        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
        String accum = "";
        for (int j = 0; j < 100; j += 2) {
            accum += j + " ";
        }
        accum = accum.trim();


        String all = set.filter(i -> (((i.intValue()) & 1) == 0))
            .<String>map(a -> a.toString())
            .reduce((a, b) -> a + " " + b);

        if (accum.equals(all)) {
            System.out.println("Passed map reduce filter test");
        } else {
            System.out.println("Test failed");
        }
    }
}