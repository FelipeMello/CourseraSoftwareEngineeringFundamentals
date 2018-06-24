
/**
 * Write a description of CaesarCipher here.
 * 
 * @author Felipe Mello
 * @version 1.0.0
 */
import edu.duke.*;
public class CaesarCipher {
    
    
    public String encrypt(String input, int key){
        //Make a StringBuilder with message(encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key)+ 
        alphabet.substring(0, key);
        
        String lowerCaseAlphabet = alphabet.toLowerCase();
        String shiftedLowerCaseAlphabet = shiftedAlphabet.toLowerCase();
        
        //Count from 0 to < kength of encrypted
        for(int i=0; i< encrypted.length(); i++){
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            //check if currChar is a letter
            if(Character.isLetter(currChar)){
                //check if currChar is upperCase
                if(Character.isUpperCase(currChar)){
                //use the UPPERCASE ALPHABET
                    int idx = alphabet.indexOf(currChar);
                    char newChar = shiftedAlphabet.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }else{
                //use the lower case alphabet
                     int idx = lowerCaseAlphabet.indexOf(currChar);
                     char newChar = shiftedLowerCaseAlphabet.charAt(idx);
                     encrypted.setCharAt(i, newChar);
                }
            }
            
        }
        return encrypted.toString();
    }
    
    
    /**
     *  This method returns a String that has been encrypted using the 
     *  following algorithm.
     *  @key1 is used to encrypte every other character with the Caesar Cipher algorithm, starting with the first character.
     *  @key2 is used to encrypt every other character, starting with the second character.
     */
    public String encryptTwoKeys(String input, int key1, int key2){
        StringBuilder encrypted = new StringBuilder(input);
        for(int i=0; i< encrypted.length(); i++){
            char currChar = encrypted.charAt(i);
            String curr = String.valueOf(currChar);
            if(i %2==0){
                //use key1 "every first character"
                curr = encrypt(curr, key1);
                char newChar = curr.charAt(0);
                encrypted.setCharAt(i, newChar);
            }else{
                curr = encrypt(curr, key2);
                char newChar = curr.charAt(0);
                encrypted.setCharAt(i, newChar);
            }
        }
        return encrypted.toString();
    
    }
    public void testCaesar(){
        int key=23;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println(encrypted);
        System.out.println("key is " + key + "\n" + encrypted);
        
        
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println(decrypted);
    }
    
        public void testCaesarDoubleKey(){
        int key1=8;
        int key2=21;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encryptTwoKeys(message, key1, key2);
        System.out.println(encrypted);
        System.out.println("key1 is " + key1 + "\n" + encrypted);
        
        
        String decrypted = encrypt(encrypted, 26-key1);
        System.out.println(decrypted);
    }

}
