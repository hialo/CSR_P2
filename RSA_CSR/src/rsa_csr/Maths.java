package rsa_csr;

import java.math.BigInteger;

public class Maths {
    public static BigInteger euclideanAlgorithm(BigInteger p, BigInteger q){ 
        BigInteger ZERO = BigInteger.valueOf(0);
        
        if (q.equals(ZERO))
            return p;
        else
            return euclideanAlgorithm(q, p.mod(q)); 
    }
}
