package rsa_csr;

import java.math.BigInteger;

public class RSA {
    public BigInteger val, p, q, n, phin, e, d;

    public RSA(RandomPrime prandom, PRNG random, int length) {
        while (true){
            System.out.println("Seed size: ~ " + length * 8 + " bits. Calculating primes...");
            
            p = prandom.getRandomPrime(random, length, 5);
            q = prandom.getRandomPrime(random, length, 5);
            
            if (q.compareTo(p) == 1)
                val = Maths.euclideanAlgorithm(q, p);
            else
                val = Maths.euclideanAlgorithm(q, p);
            
            if (val.equals(BigInteger.ONE))
                break;
        }
        
        /*System.out.println("P: " + p);
        System.out.println("-----------------------------------");
        System.out.println("Q: " + q);
        System.out.println("-----------------------------------");*/
        
        n = p.multiply(q);
        phin = p.subtract(new BigInteger("1")).multiply(q.subtract(new BigInteger("1")));
        
        /*System.out.println("N: " + n);
        System.out.println("-----------------------------------");
        System.out.println("PHI(N): " + phin);
        System.out.println("-----------------------------------");*/
        
        while (true){
            e = prandom.getRandomPrime(random, length, 5);
            
        if (e.compareTo(phin) == 1)
            val = Maths.euclideanAlgorithm(e, phin);
        else
            val = Maths.euclideanAlgorithm(e, phin);
        
        if (val.equals(BigInteger.ONE))
            break;
        }
        
        d = e.modInverse(phin);
        
        /*System.out.println("E: "+ e);
        System.out.println("-----------------------------------");
        System.out.println("D: "+ d);
        System.out.println("-----------------------------------");*/
        
    }
    
    public BigInteger encrypt(BigInteger b) {
        return b.modPow(e, n);
    }

    public BigInteger encrypt(String message) {
        BigInteger message_bytes = new BigInteger(message.getBytes());
        return encrypt(message_bytes);
    }

    public BigInteger decrypt(BigInteger b){
        return b.modPow(d, n);
    }
}
