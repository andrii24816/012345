package org.example;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import jakarta.validation.*;

public class Employee extends People implements Serializable {

    private  String company;
    private  String position;
    private int salary;

    public Employee(String name, String company1) {

        super(name);
        company = company1;
        position = "manager";
        salary = 12500;
    }

    public Employee(String name, String company1,  String position1, int salary1) {
        super(name);
        company = company1;
        position = position1;
        salary = salary1;
    }

    public Employee(String Name, int Number, int Exp, int CodeP, String company1,  String position1, int salary1) {

        super(Name, Number, Exp, CodeP);
        company = company1;
        position = position1;
        salary = salary1;
    }

    public String getCompany(){ return company; }

    public String toString(){

        return "Info{ " +
                "Name - " + this.GetName()+ " |" +
                "CodeP - " + this.GetCodeP() + " |" +
                "Phone Number +" + this.GetPhoneNumber() + " |" +
                "Lease Term " + this.GetExp() + "mounth |" +
                "Company name " + this.getCompany() + " |" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Employee people = (Employee) o;
        return Objects.equals(GetName(), people.GetName()) && Objects.equals(GetCodeP(), people.GetCodeP()) && Objects.equals(GetPhoneNumber(), people.GetPhoneNumber()) && Objects.equals(GetExp(),people.GetExp()) && Objects.equals(salary, people.salary) && Objects.equals(company, people.company) &&  Objects.equals(position, people.position);
    }
    @Override
    public int hashCode() { return Objects.hash( CodeP, Name, PhoneNumber, Exp); }

    public String toStringFile() {
        return this.GetName()+
                " " + this.GetCodeP() + " " +
                this.GetPhoneNumber() + " " +
                this.GetExp() + " " +
                this.getCompany() + "\n";


    }
    public Employee validate(Employee obj) throws ValidationException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Employee>> violations = validator.validate(obj);
        if (violations.isEmpty())
            return obj;
        StringBuilder sb=new StringBuilder("\n");
        for (var violation : violations) {
            sb.append("Invalid value : ").append(violation.getInvalidValue()).append(" " + violation.getMessage() + "\n");
        }
        throw new ValidationException(sb.toString());
    }
}
