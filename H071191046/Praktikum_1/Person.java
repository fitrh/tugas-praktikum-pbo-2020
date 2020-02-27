class Person {
    String name;
    int age;
    boolean isMale;

    void setAge(int age) {
        this.age = age;
    }
    int getAge() {
        return age;
    }
    void setName(String name) {
        this.name = name;
    }
    String getName() {
        return name;
    }
    void setGender(boolean isMale){
        this.isMale = isMale;
    }
    String getGender() {
        String male = "Laki-laki";
        String female = "Perempuan";

        if(isMale) {
            return male;
        }
        else {
            return female;
        }
    }
}