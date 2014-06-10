/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa_csr;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigInteger;

public class Main {

    // Size of the number, in bytes. As we using a 500+ bits number, N_LENGTH = 500 / 8 = 62.5.
    // So, we are using 100 bytes, which is 800 bits.
    
    /*  To get a random number: create a object PRNG (N_BITS / 8) and call the method getRandomNumber()
     *  To get a random prime: create a object RandomPrime() and call the method getRandomPrime()
     */
    
    public static void main(String[] args) {
        final int N_LENGTH = 70;                 

        PRNG random = new PRNG(N_LENGTH);
        RandomPrime prandom = new RandomPrime();
        
        BigInteger val, p, q;
        
        while (true){
            p = prandom.getRandomPrime(random, N_LENGTH, 5);
            q = prandom.getRandomPrime(random, N_LENGTH, 5);
            
        if (q.compareTo(p) == 1)
            val = Maths.euclideanAlgorithm(q, p);
        else
            val = Maths.euclideanAlgorithm(q, p);
        
        if (val.equals(BigInteger.ONE))
            break;
        }

        System.out.println(p);
        System.out.println(q);

    }
}
