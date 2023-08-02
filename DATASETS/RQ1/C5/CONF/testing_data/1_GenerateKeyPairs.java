

import java.security.*;
import java.security.spec.NamedParameterSpec;


public class GenerateKeyPairs {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {

        KeyPairGenerator kpg = KeyPairGenerator.getInstance("XDH");
        NamedParameterSpec paramSpec = new NamedParameterSpec("X25519");
        kpg.initialize(paramSpec); 
        
        KeyPair kp = kpg.generateKeyPair();

        System.out.println("--- Public Key ---");
        PublicKey publicKey = kp.getPublic();

        System.out.println(publicKey.getAlgorithm());   
        System.out.println(publicKey.getFormat());      

        
        byte[] pubKey = publicKey.getEncoded();

        System.out.println("---");

        System.out.println("--- Private Key ---");
        PrivateKey privateKey = kp.getPrivate();

        System.out.println(privateKey.getAlgorithm());  
        System.out.println(privateKey.getFormat());     

        
        byte[] priKey = privateKey.getEncoded();
    }
}
