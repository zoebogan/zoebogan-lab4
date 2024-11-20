public class Rotor {

    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());
            
    }
    
    public boolean rotate(){
        //TODO
        //store the last character in the array and create a new character array to change the values
        char lastChar = rotorValues.charAt(rotorValues.length() - 1);
        char[] rotorElements = new char[rotorValues.length()];
        //iterate through the values to shift the elements down 
        for (int i =  rotorValues.length() - 1; i > 0; i--) {
            rotorElements[i] = rotorValues.charAt(i - 1);
        }
        //assign the first value in the array to the previous last character to complete rotating
        rotorElements[0] = lastChar;
        //reassign the character array to the original string
        rotorValues = new String(rotorElements);
        //boolean check of the first character
        if (startChar == rotorValues.charAt(0)) {
            return true;
        }
        return false;        
    }

    public int indexOf(char c){
        //TODO
        //return the index of the character
        return rotorValues.indexOf(c); 
    }
    
    public char charAt(int idx){
        //TODO
        //return the character at an index
        return rotorValues.charAt(idx);
    }
}