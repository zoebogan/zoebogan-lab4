public class Enigma {

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }

    public String decrypt(String message){        
        //TODO
        //create an new empty string to store the new message
        String originalMessage = "";
        //iterate through the given message
        for (int i = 0; i < message.length(); i++) {
            //tranverse between the different rotors to find the starting character
            char currentValue = message.charAt(i);
            int indexValue = rotors[2].indexOf(currentValue); 
            char middleValue = rotors[1].charAt(indexValue);
            int middleIndex = rotors[2].indexOf(middleValue);
            char outerValue = rotors[0].charAt(middleIndex);

            originalMessage = originalMessage + outerValue;
            //call on rotate to shift the rotor values
            this.rotate();
        }
        //return the decrypted message
        return originalMessage;
    }
    
    public String encrypt(String message){
        //TODO
        //create an new empty string to store the new message
        String encryptMessage = "";
        //iterate through a the given message
        for (int i = 0; i < message.length(); i++) {     
            //tranverse between the different rotors to find the encrypted character
            char currentValue = message.charAt(i);
            int indexValue = rotors[0].indexOf(currentValue);
            char outerValue = rotors[2].charAt(indexValue);
            int middleValue = rotors[1].indexOf(outerValue);           
            char outerLetter = rotors[2].charAt(middleValue);

            encryptMessage = encryptMessage + outerLetter;
            //call on rotate to shift the rotor values
            this.rotate();
        }
        //return the encrpted message
        return encryptMessage; 
    }
    
    private void rotate() {
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}
