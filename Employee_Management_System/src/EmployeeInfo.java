
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author bubbl
 */
public class EmployeeInfo {

    private String EmployeeFirstName;
    private String EmployeeLastName;
    private int EmployeeID;
    private int Gender;
    private int Location;
    private double DeductionRate;

    public EmployeeInfo(String FName, String LName, int ID, int gender, int location, double rate) {
        EmployeeFirstName = FName;
        EmployeeLastName = LName;
        EmployeeID = ID;
        Gender = gender;
        Location = location;
        DeductionRate = rate;

    }
    public String GetEmployeeFirstName() {
        return EmployeeFirstName;
    }
    public String GetEmployeeLastName() {
        return EmployeeLastName;
    }
    public int GetEmployeeID() {
        return EmployeeID;
    }
    public int GetGender() {
        return Gender;
    }
    public int GetLocation() {
        return Location;
    }
    public double GetDeductionRate() {
        return DeductionRate;
    }
    public double CalculateNetIncome() {
    	return 0;
    }

}
