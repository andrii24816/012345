
package org.example;

import java.util.Objects;
import java.util.Set;


import jakarta.validation.*;

public class People  implements Comparable<People> {
    private static final String NAME = "People";

    String Name;
    long PhoneNumber;
    int Exp;
    long CodeP;

    @Override
    public int compareTo(People anotherPeople)
    {
        return this.Exp -anotherPeople.Exp;
    }
    public  String GetName() {
        return Name;
    }
    public void SetName(String Name) {
        this.Name = Name;
    }


    public long GetCodeP() {
        return CodeP;
    }

    public long GetPhoneNumber() {
        return PhoneNumber;
    }
    public void SetPhoneNumber(long PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public int GetExp() {
        return Exp;
    }

    public void SetExp(int Exp) {
        this.Exp = Exp;
    }

    @Override
    public String toString(){
        return "Info{ " +
                "Name - " + Name+ " |" +
                "CodeP - " + CodeP + " |" +
                "Phone PhoneNumber +" + PhoneNumber + " |" +
                "Lease Term " + Exp + "mounth |" +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        People people = (People) o;
        return Objects.equals(Name, people.Name) && Objects.equals(CodeP, people.CodeP) && Objects.equals(PhoneNumber, people.PhoneNumber) && Objects.equals(Exp, people.Exp);
    }
    @Override
    public int hashCode() { return Objects.hash( CodeP, Name, PhoneNumber, Exp); }

    People(String Name1)
    {
        Name = Name1;
        PhoneNumber= 3806676;
        Exp=36;
        CodeP=9529;
    }

    People()
    {
    }

    public People(String Name1, int PhoneNumber1, int Exp1, int CodeP1)
    {   Name = Name1;
        PhoneNumber= PhoneNumber1;
        Exp=Exp1;
        CodeP=CodeP1;
    }

    public static class Builder{
        private People newPeople;

        public Builder(){ newPeople = new People(); }

        public Builder(String Name1)
        { newPeople = new People();
            newPeople.Name = Name1;
            newPeople.PhoneNumber= 3806676;
            newPeople.Exp=35;
            newPeople.CodeP=9529;
        }

        public Builder(String Name, int PhoneNumber, int Exp, int CodeP)
        { newPeople = new People();
            newPeople.Name = Name;
            newPeople.PhoneNumber= PhoneNumber;
            newPeople.Exp=Exp;
            newPeople.CodeP=CodeP;
        }
        public People.Builder withName(String Name){
            newPeople.Name = Name;
            return this;
        }

        public People.Builder withPhoneNumber(long PhoneNumber){
            newPeople.PhoneNumber = PhoneNumber;
            return this;
        }

        public People.Builder withCodeP(long CodeP){
            newPeople.CodeP = CodeP;
            return this;
        }

        public People.Builder withExp(int Exp){
            newPeople.Exp = Exp;
            return this;
        }


        public People build()
        {var res = validate(newPeople);
            return newPeople; }
    }
    public static People validate(People obj) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<People>> violations = validator.validate(obj);
        if (violations.isEmpty()) {
            return obj;
        } else {
            StringBuilder sb = new StringBuilder();
            for (var violation : violations) {
                sb.append(violation.getInvalidValue()).append(" : ").append(violation.getMessage());
            }
            return null;
        }
    }
}


