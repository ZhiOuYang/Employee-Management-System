/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bubbl
 */
public class FullTimeEmployee extends EmployeeInfo {
    private double YearlySalary;
    public int FullTime;
    public FullTimeEmployee(String FName, String LName, int ID, int gender, int location, double rate, double salary) {
        super(FName, LName, ID, gender, location, rate);
        YearlySalary = salary;
    }
    public String toString() {
        return /*"1"+","+*/ "1," + GetEmployeeFirstName() + "," + GetEmployeeLastName() + "," + GetEmployeeID() + "," + GetGender() + "," + GetLocation() + "," + GetDeductionRate() + "," + YearlySalary;
    }
    public double GetYearlySalary() {
        return YearlySalary;
    }
    public double CalculateNetIncome() {

        return YearlySalary * (1 - GetDeductionRate()/100);
    }
}
