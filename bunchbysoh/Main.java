package bunchbysoh;

public class Main {
  //class to store counts for different soh classifications
  static class CountsBySoH {
    public int healthy = 0;
    public int exchange = 0;
    public int failed = 0;
  };
//function to count batteries by their SoH
  static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
    CountsBySoH counts = new CountsBySoH();
    for(int capacity : presentCapacities) {
      double stateofhealth=(capacity/120.0)*100.0;
      
      //classify batteries based on SoH
      if(stateofhealth>=80.0 && stateofhealth<=100.0)
        counts.healthy++;
      else if(stateofhealth >=63.0 && stateofhealth <80.0)
        count.exchange++;
      else if(stateofhealth <63.0)
        counts.failed++;
    }
    return counts;
  }

  static void testBucketingByHealth() {
    System.out.println("Counting batteries by SoH...\n");
    //test case 1
    int[] presentCapacities = {115, 118, 80, 95, 91, 72};
    CountsBySoH counts = countBatteriesByHealth(presentCapacities);
    assert(counts.healthy == 2);
    assert(counts.exchange == 3);
    assert(counts.failed == 1);
   

    //test case 2:check where all batteries are healthy
    int [] allhealthy={120,120,120,120};
    counts=countBatteriesByHealth(allhealthy);
    assert(counts.healthy==4);
    assert(counts.exchange==0);
    assert(counts.failed==0);

    //test case 3: check for a case where all are failed
    int [] allfailed={50,40,30};
    counts=countBatteriesByHealth(allfailed);
    assert(counts.healthy==0);
    assert(counts.exchange==0);
    assert(counts.failed==3);
     System.out.println("Done counting :)\n");
  }

  public static void main(String[] args) {
    testBucketingByHealth();
  }
}
