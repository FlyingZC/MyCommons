package com.zc.z01guava;

import com.google.common.base.Joiner;

import java.util.Arrays;

public class T11Joiner {
   public static void main(String args[]){
      T11Joiner tester = new T11Joiner();
      tester.testJoiner();	
   }

   private void testJoiner(){
      System.out.println(Joiner.on(",")
         .skipNulls()
         .join(Arrays.asList(1,2,3,4,5,null,6)));
   }
}