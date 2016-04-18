package uk.ac.aston.cs1260;

/**
	Please note that no exceptions should be thrown, rather a null must be returned on error.
**/

public class MyRSA {

    public static String encrypt(int p, int q, int privateKey, String message) {
        int n = p * q;
        int m = (p - 1) * (q - 1);
        
        // Use Extended Euclidean Algo to get a
        int a = Euclidean.extendedAlgorithm(p, q);
        
        return "";
    }
	
    public static String decrypt(int privateKey, String encryptedString, int p, int q) {
        // to do
    	return "";
    }
}
