/**
 * Class used to find twin prime numbers. Finds the
 * smallest twin primes within a certain range.
 * @author Sawyer Ball
 */
public class TwinPrimeGenerator {
    /**
     * Checks if the passed in number is a prime number.
     * @param num Number to check if prime.
     * @return True if num is prime.
     *         False if num is not prime.
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

    /**
     * Finds the lowest twin prime numbers within the
     * passed in ranges 'bottomRange' and 'topRange'.
     * @param bottomRange Location to start looking for
     *                    twin prime numbers.
     * @param topRange Location of where to stop looking
     *                 for twin prime numbers.
     * @return Int representing the smaller twin prime number.
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
