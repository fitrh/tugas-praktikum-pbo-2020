/**
 * Nomor1
 */
public class Person {

    private String name;
    private int age;
    private boolean isMale;
    
    // setter
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setGender(boolean isMale) {
        this.isMale = isMale;
    }

    // getter
    public int getAge() {
        return age;  
    }
    
    public String getName() {
        
        String finalName = "";

            finalName += Character.toUpperCase(name.charAt(0));  

            for (int i = 1; i < name.length(); i++) {
            
                char currentChar = name.charAt(i);
                currentChar = Character.toLowerCase(currentChar);
                char previousChar = name.charAt(i - 1);
                previousChar = Character.toLowerCase(previousChar);

                if (previousChar == ' ') {
                    finalName += Character.toUpperCase(currentChar);
                } else {
                finalName += currentChar;
                    }
                }
           return finalName;

        }

    public String getGender() {
        if (isMale) {
            return "Male";
        } else {
            return "Female";
        }
    }

    // description
    public void desc() {
        System.out.printf("Name \t: %s\nGender \t: %s\nAge \t: %d", getName(), getGender(), getAge());
    }

    public static void main(String[] args) {
        
        Person person1 = new Person();
        
        person1.setName("akmal zuhdy prasetya");
        person1.setGender(true);
        person1.setAge(18);
        person1.desc();

    }

}