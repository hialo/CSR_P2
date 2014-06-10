package rsa_csr;

import java.math.BigInteger;

public class RSA {
	public BigInteger val, p, q, n, phin, e, d;

	public RSA(RandomPrime prandom, PRNG random, int length) {
		while (true){
            p = prandom.getRandomPrime(random, length, 5);
            q = prandom.getRandomPrime(random, length, 5);
            
        if (q.compareTo(p) == 1)
            val = Maths.euclideanAlgorithm(q, p);
        else
            val = Maths.euclideanAlgorithm(q, p);
        
        if (val.equals(BigInteger.ONE))
            break;
        }

        n = p.multiply(q);
        phin = p.subtract(new BigInteger("1")).multiply(q.subtract(new BigInteger("1")));
        
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
