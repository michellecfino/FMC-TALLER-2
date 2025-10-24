public class punto4 {
    
    public static long squareAndMultiply(long base, long exp, long mod) {
        long result = 1;
        long power = base % mod;
        String binary = Long.toBinaryString(exp);
        System.out.println("Exponente (" + exp + ") en binario: " + binary);
        for (int i = 0; i < binary.length(); i++) {
            char bit = binary.charAt(i);
            result = (result * result) % mod;
            if (bit == '1') {
                result = (result * power) % mod;
            }
            System.out.printf("Paso %d (bit=%c): result = %d%n", i + 1, bit, result);
        }
        return result;
    }

    public static long[] extendedGCD(long a, long b) {
        if (b == 0)
            return new long[] { a, 1, 0 };
        long[] vals = extendedGCD(b, a % b);
        long d = vals[0];
        long x = vals[2];
        long y = vals[1] - (a / b) * vals[2];
        return new long[] { d, x, y };
    }

    public static long modInverse(long e, long phi) {
        long[] vals = extendedGCD(e, phi);
        long d = vals[1];
        if (d < 0)
            d += phi;
        return d;
    }

    public static void main(String[] args) {
        long p = 79;
        long q = 101;
        long e = 11;
        long m = 100;

        long n = p * q;
        long phi = (p - 1) * (q - 1);

        System.out.println("n = " + n);
        System.out.println("phi(n) = " + phi);

        long d = modInverse(e, phi);
        System.out.println("d = " + d);

        long c = squareAndMultiply(m, e, n);
        System.out.println("\nCifrado c = " + c);

        long m2 = squareAndMultiply(c, d, n);
        System.out.println("Descifrado m' = " + m2);
    }
}
