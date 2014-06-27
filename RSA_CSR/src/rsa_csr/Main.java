/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa_csr;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    // Size of the number, in bytes. As we using a 500+ bits number, N_LENGTH = 500 / 8 = 62.5.
    // So, we are using 70 bytes, which is 560 bits.
    
    /*  To get a random number: create a object PRNG (N_BITS / 8) and call the method getRandomNumber()
     *  To get a random prime: create a object RandomPrime() and call the method getRandomPrime()
     */
    
    public static void main(String[] args) {
        final int N_LENGTH = 70;

        PRNG random = new PRNG(N_LENGTH);
        RandomPrime prandom = new RandomPrime();
        
        RSA rsa = new RSA(prandom, random, N_LENGTH);
        
        Scanner in = new Scanner(System.in);
        System.out.print("\nPlease, enter something to encrypt: ");
        String plainText = in.nextLine();
        
        System.out.println("\nPlain Text: " + plainText);
        BigInteger cipherText = rsa.encrypt(plainText);
        
        System.out.println("\nCipher Text: " + cipherText);
        BigInteger decrypted = rsa.decrypt(cipherText);
        String decryptPlainText = new String(decrypted.toByteArray());
        
        System.out.println("\nDecrypted: " + decryptPlainText);
        
    }
}
