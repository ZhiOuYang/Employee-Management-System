/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author bubbl
 */
public class PartTimeEmployee extends EmployeeInfo {
    private double HourlyWage;
    private double HoursPerWeek;
    private int WeeksPerYear;
    public PartTimeEmployee(String FName, String LName, int ID, int gender, int location, double rate, double Wage, double Hours, int Weeks) {
        super(FName, LName, ID, gender, location, rate);
        HourlyWage = Wage;
        HoursPerWeek = Hours;
        WeeksPerYear = Weeks;
    }
    public String toString() {
        return "0,"+GetEmployeeFirstName() + "," + GetEmployeeLastName() + "," + GetEmployeeID() + "," + GetGender() + "," + GetLocation() + "," + GetDeductionRate() + "," + HourlyWage + "," + HoursPerWeek + "," + WeeksPerYear;
    }
    public double GetHourlyWage() {
        return HourlyWage;
    }
    public double GetHoursPerWeek() {
        return HoursPerWeek;
    }
    public int GetWeeksPerYear() {
        return WeeksPerYear;
    }
    public double CalculateNetIncome() {
        return HourlyWage * HoursPerWeek * WeeksPerYear * (1 - GetDeductionRate()/100);
    }
}
