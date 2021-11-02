public class TwinPrimeGenerator {

    public static void main(String[] args) {
        int num = 682;
        System.out.println(num);
        System.out.println(isPrime(num));
    }

    /* Method that checks whether or not the
     *
     */
    public static boolean isPrime(int num) {
        int halfNum = num/2;
        if(num == 0 || num == 1) {
            return false;
        }

        for(int i = 2; i < halfNum; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int twinPrimeGenerator(int bottomRange, int topRange) {
        int lowerPrime = 0;
        int upperPrime = 0;
        for (int i = bottomRange + 2; i < topRange; i++) {
            if (isPrime(i) && isPrime(i - 2)) {
                lowerPrime = i - 2;
                upperPrime = i;
            }
        }


        return 0;
    }

}
