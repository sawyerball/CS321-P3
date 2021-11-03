public class TwinPrimeGenerator {

    /* Method that checks whether or not the
     * input parameter 'num' is prime.
     */
    public boolean isPrime(int num) {
        int halfNum = num/2;
        if(num == 0 || num == 1) {
            return false;
        }

        for(int i = 2; i <= halfNum; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    /* Finds the lowest twin primes within the given
     * range from 'bottomRange' to 'topRange'.
     */
    public int twinPrimeGenerator(int bottomRange, int topRange) {
        for (int i = bottomRange + 2; i < topRange; i++) {
            if (isPrime(i) && isPrime(i - 2)) {
                return i;
            }
        }

        System.out.println("There are no twin prime values in this set.");
        return -1;
    }
}
