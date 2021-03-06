package com.zc.z01guava;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.Map;
import java.util.Set;

// Table代表一个特殊的映射，其中两个键可以在组合的方式被指定为单个值。它类似于创建映射的映射。
// 类似于二维数组
public class T09Table {

   public static void main(String args[]){
      //Table<R,C,V> == Map<R,Map<C,V>>
      /*
      *  Company: IBM, Microsoft, TCS
      *  IBM 		-> {101:Mahesh, 102:Ramesh, 103:Suresh}
      *  Microsoft 	-> {101:Sohan, 102:Mohan, 103:Rohan } 
      *  TCS 		-> {101:Ram, 102: Shyam, 103: Sunil } 
      * 
      * */
      //create a table
      Table<String, String, String> employeeTable = HashBasedTable.create();

      //initialize the table with employee details
      employeeTable.put("IBM", "101","Mahesh");
      employeeTable.put("IBM", "102","Ramesh");
      employeeTable.put("IBM", "103","Suresh");

      employeeTable.put("Microsoft", "111","Sohan");
      employeeTable.put("Microsoft", "112","Mohan");
      employeeTable.put("Microsoft", "113","Rohan");

      employeeTable.put("TCS", "121","Ram");
      employeeTable.put("TCS", "122","Shyam");
      employeeTable.put("TCS", "123","Sunil");

      //get Map corresponding to IBM 获取一行
      Map<String,String> ibmEmployeesRow =  employeeTable.row("IBM");

      System.out.println("List of IBM Employees");
      for(Map.Entry<String, String> entry : ibmEmployeesRow.entrySet()){
         // 一行的key, value
         System.out.println("Emp Id: " + entry.getKey() + ", Name: " + entry.getValue());
      }

      //get all the unique keys of the table
      Set<String> employers = employeeTable.rowKeySet();
      System.out.print("Employers: ");
      for(String employer: employers){
         System.out.print(employer + " ");
      }
      System.out.println();

      //get a Map corresponding to 102
      Map<String,String> EmployerMap =  employeeTable.column("102");
      for(Map.Entry<String, String> entry : EmployerMap.entrySet()){
         System.out.println("Employer: " + entry.getKey() + ", Name: " + entry.getValue());
      }		
   }	
}