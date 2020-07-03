package lambda_streams;

import java.util.Arrays;
import java.util.List;

class Numbers {
    static List<Integer> nums = Arrays.asList(10,100,1000,5,50,500,3,30,300,7,70,700,1,10,100,25,250,2500);

    public static void main(String[] args) {
        //Part I :complete the static class methods that have been set up in this Numbers class java file.  Use streams to compute the results wheever possible.
        System.out.println(nums);
        System.out.println(isOdd(nums));
        System.out.println(isEven(nums));

        //Part II - refactor all of the class methods to accept lambda expressions. You can put the lambda functions directly inside the method calls, or defined them first, then pass them into the methods. give them the same names as the static methods, but add the word 'lambda' in front of every lambda function:
        /* e.g.
        added(() -> {});
        OR
        lambdaAdd = () -> {};
        added(lambdaAdd);
        isOdd(() -> {});
        OR
        lambdaOdd = () -> {};
        isOdd(lambdaOdd);
        etc...
        */

    }

    static <i> boolean isOdd(List<Integer> i) {
        //determine if the value at the index i is odd.  return true if yes, return false if  no.
        for(int n=0; n<nums.size(); n++){
            if(nums.get(n) %2 !=0){
                System.out.print("Number " + nums.get(n) + " at index " + String.valueOf(n) + " is odd. ");
                return true;
            }
    }
        System.out.println("No odd numbers");
        return false;
    }

    static <i> boolean isEven(List<Integer> i) {
        //determine if the value at the index i is even.  return true if yes, return false if  no.
        for(int n=0; n<nums.size(); n++){
            if(nums.get(n) % 2 == 0){
                System.out.print("Number " + nums.get(n) + " at index " + String.valueOf(n) + " is even. ");
                return true;
            }
        }
        System.out.println("No even numbers");
        return false;
    }

//    static boolean isPrime(int i) {
//        //determine if the value at the index i is a prime number.  return true if yes, return false if no.
//        return false;
//    }
//
//    static int added() {
//        //add all the elements in the list.  return the sum.
//        return 0;
//    }
//
//    static int subtracted() {
//        //subtract all the elements in the list. return the remainder.
//        return 0;
//    }
//
//    static int multipled() {
//        //multiply all the elements in the list. and return the product.
//        return 0;
//    }
//
//    static int divided() {
//        //multiply all the elements in the list. and return the product.
//        return 0;
//    }
//
//    static int findMax() {
//        //return the maximum value in the list.
//        return 0;
//    }
//
//    static int findMin() {
//        //return the minimum value in the list.
//        return 0;
//    }
//
//    static int compare(int i, int j) {
//        //compare the values stored in the array at index position i and j.
//        //if the value at i is greater, return 1.  if the value at j is greater, return -1.  if the two values are equal, return 0.
//        return 0;
//    }
//
//    static int append(int n) {
//        //add a new value to the values list. return that value after adding it to the list.
//        return 0;
//    }

}

//    Open the Numbers.java file. This file contains a Numbers class that has the following method signatures:
//
//        isOdd(i)
//        isEven(i)
//        isPrime(i)
//        added()
//        subtracted()
//        multiplied()
//        divided()
//        findMax()
//        findMin()
//        compare(i,j)
//        append(n)
//        Complete all of the above instance methods, and test your methods by running all of them in the main() method of the lambda.Numbers class. Display the output to the console.
//
//        Convert all of the above instance methods into lambda expressions in the main() method of the Numbers class. Give the lambda expressions names that are slightly different than the instance methods. Verify your code by printing the output of the lambda expressions to the console.
