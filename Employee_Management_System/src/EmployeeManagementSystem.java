/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bubbl
 */
import java.util.ArrayList;
public class EmployeeManagementSystem {
    private int k; // the k value (number of buckets, length of hashTable)
    private ArrayList<EmployeeInfo>[] hashTable; // the hash table, which is an array of ArrayLists (buckets) of EmployeeInfo objects
    public EmployeeManagementSystem(int k) {
        this.k = k; // set the k value

        this.hashTable = new ArrayList[k]; // initialize the hashTable array to contain k number of buckets

        // initialize the ArrayLists (buckets) within the hashTable array
        for (int i = 0; i < k; i++) {
            this.hashTable[i] = new ArrayList<EmployeeInfo>();
        }
    }
    public void add(EmployeeInfo newItem) {
        // adds the new EmployeeInfo object to the bucket with index employee number % k
    	hashTable[newItem.GetEmployeeID() % k].add(newItem); 	
    }
    /**
     * Finds and returns the EmployeeInfo object with the specified employee
     * number.
     *
     * @param employeeNumber the employee number of the EmployeeInfo object to
     * be searched for.
     * @return the EmployeeInfo object with the given employee number, or null
     * if one was not found.
     */
    public EmployeeInfo find(int employeeNumber) {
        // for every employee within the correct bucket, check if its SN == the given SN
        for (EmployeeInfo employee : hashTable[employeeNumber % k]) {
            // return the employee if it has the correct SN
            if (employee.GetEmployeeID() == employeeNumber) {
                return employee;
            }
        }
        // return null if no employee with the correct SN is found
        return null;
    }
    /**
     * Removes the first EmployeeInfo object with the specified employee number
     * from the hash table.
     *
     * @param employeeNumber the employee number of the EmployeeInfo object to
     * be removed.
     * @return the EmployeeInfo object that was found and removed, or null if
     * one was not found.
     */
    public EmployeeInfo remove(int employeeNumber) {
        // create an ArrayList pointing to the bucket containing the target employee
        ArrayList<EmployeeInfo> targetBucket = hashTable[employeeNumber % k];
        // iterate through the bucket until finding a EmployeeInfo object with the specified SN
        for (int i = 0; i < targetBucket.size(); i++) {
            // if the EmployeeInfo object has the correct SN, return and remove it
            if (targetBucket.get(i).GetEmployeeID() == employeeNumber) {
                return targetBucket.remove(i);
            }
        }
        // return null if no employee with the correct SN is found
        return null;
    }
    
    public String listEmployees()
    {
    	String text = "";
    	for (int i = 0; i < k; i++)
    	{
    		ArrayList<EmployeeInfo> tempBucket = hashTable[i];
    		if (tempBucket.size() != 0) {
                // display every employee in the bucket with a trailing comma, except the last one
                for (int j = 0; j < tempBucket.size(); j++) {
                    text += (tempBucket.get(j).toString()) + '\n';
                }
    		}
    	}
    	return text;
    }
    
    /**
     * Display the contents of the hash table. The contents will be formatted as
     * follows: Bucket number: [first EmployeeInfo], [second EmployeeInfo], ...
     */
    public static String displayText = "";
    
    public void display() {
    	displayText = "";
        for (int i = 0; i < k; i++) {
            // print the bucket number
            System.out.print("Bucket " + Integer.toString(i) + ": ");
            displayText += ("Bucket " + Integer.toString(i) + ": ");

            // create an ArrayList pointing to the current bucket
            ArrayList<EmployeeInfo> tempBucket = hashTable[i];

            // only iterate through the current bucket if it is not empty (will get IndexOutOfBounds otherwise)
            if (tempBucket.size() != 0) {
                // display every employee in the bucket with a trailing comma, except the last one
                for (int j = 0; j < tempBucket.size() - 1; j++) {
                    System.out.print("[" + "(" + tempBucket.get(j).toString().split(",")[3] + ") "+ tempBucket.get(j).toString().split(",")[1] + " " + tempBucket.get(j).toString().split(",")[2] +  "], ");
                    displayText += ("[" + "(" + tempBucket.get(j).toString().split(",")[3] + ") "+ tempBucket.get(j).toString().split(",")[1] + " " + tempBucket.get(j).toString().split(",")[2] +  "], ");
                }
                // display the last employee in the bucket without a trailing comma
                System.out.print("[" + "(" + tempBucket.get(tempBucket.size() - 1).toString().split(",")[3] + ") "+ tempBucket.get(tempBucket.size() - 1).toString().split(",")[1] + " " + tempBucket.get(tempBucket.size() - 1).toString().split(",")[2] +  "]");
                displayText += ("[" + "(" + tempBucket.get(tempBucket.size() - 1).toString().split(",")[3] + ") "+ tempBucket.get(tempBucket.size() - 1).toString().split(",")[1] + " " + tempBucket.get(tempBucket.size() - 1).toString().split(",")[2] +  "]");
            }

            System.out.println(); // print a newline after every bucket
            displayText += '\n';
        }
    }

}
