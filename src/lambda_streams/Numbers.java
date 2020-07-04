package lambda_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

class Numbers {
    static List<Integer> nums = Arrays.asList(10,100,1000,5,50,500,3,30,300,7,70,700,1,10,100,25,250,2500);

    public static void main(String[] args) {
        //Part I :complete the static class methods that have been set up in this Numbers class java file.  Use streams to compute the results wheever possible.
        System.out.println(nums);
        System.out.println(isOdd(nums));
        System.out.println(isEven(nums));
        System.out.println(isPrime(nums));
        System.out.println("Sum of list is " + added(nums));
        System.out.println("Substraction of list is " + subtracted(nums));
        System.out.println("Product of list is " + multiplied(nums));
        System.out.println("Division of list is " + divided(nums));
        System.out.println("Max number is " + findMax(nums));
        System.out.println("Min number is " + findMin(nums));
        System.out.println("Comparison " + compare(nums));
        System.out.println("New element is " + append(1117));
        System.out.println(" ");

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

        System.out.println("Begin Lambdas");

        lambdaCalc<List<Integer>, Boolean> val1 = (List<Integer> i) -> {
            for (int n = 0; n < nums.size(); n++) {
                if (nums.get(n) % 2 != 0) {
                    System.out.print("Number " + nums.get(n) + " at index " + String.valueOf(n) + " is odd. ");
                    return true;
                }
            }
            System.out.println("No odd numbers");
            return false;
        };
        System.out.println(val1.calc(nums));

        lambdaCalc<List<Integer>, Boolean> val2 = (List<Integer> i) -> {
            for(int n=0; n<nums.size(); n++){
                if(nums.get(n) % 2 == 0){
                    System.out.print("Number " + nums.get(n) + " at index " + String.valueOf(n) + " is even. ");
                    return true;
                }
            }
            System.out.println("No even numbers");
            return false;
        };
        System.out.println(val2.calc(nums));

        lambdaCalc<List<Integer>, Boolean> val3 = (List<Integer> i) -> {
            int n;
            Boolean prime = false;
            for(n=0; n<nums.size(); n++){
                // condition for nonprime number
                for (int val = 2; val <= nums.get(n)/2; ++val)
                    if(nums.get(n) % val == 0) {
                        break;
                    } else {
                        prime = true;
                    }
                if (prime) {
                    System.out.print("Number " + nums.get(n) + " at index " + String.valueOf(n) + " is prime. ");
                    return true;
                }
            }
            System.out.print("No prime numbers ");
            return false;
        };
        System.out.println(val3.calc(nums));

        lambdaCalc<List<Integer>, Double> val4 = (List<Integer> i) -> {
            double sum = 0;
            for (int n = 0; n< Numbers.nums.size(); n++)
                sum += Numbers.nums.get(n);
            return sum;
        };
        System.out.println(val4.calc(nums));

        lambdaCalc<List<Integer>, Double> val5 = (List<Integer> i) -> {
            double sum = nums.get(0);
            for (int n = 1; n<nums.size(); n++)
                sum -= nums.get(n);
            return sum;
        };
        System.out.println(val5.calc(nums));

        lambdaCalc<List<Integer>, Long> val6 = (List<Integer> i) -> {
            long product = nums.get(0);
            for (int n = 1; n<nums.size(); n++)
                product *= nums.get(n);
            return product;
        };
        System.out.println(val6.calc(nums));

        lambdaCalc<List<Integer>, Double> val7 = (List<Integer> i) -> {
            double product = nums.get(0);
            for (int n = 1; n<nums.size(); n++)
                product /= nums.get(n);
            return product;
        };
        System.out.println(val7.calc(nums));

        lambdaCalc<List<Integer>, Integer> val8 = (List<Integer> i) -> {
            List<Integer> sortedList = new ArrayList<>(nums);
            Collections.sort(sortedList);
            return sortedList.get(sortedList.size()-1);
        };
        System.out.println(val8.calc(nums));

        lambdaCalc<List<Integer>, Integer> val9 = (List<Integer> i) -> {
            List<Integer> sortedList = new ArrayList<>(nums);
            Collections.sort(sortedList);
            return sortedList.get(0);
        };
        System.out.println(val9.calc(nums));

        lambdaCalc<List<Integer>, Integer> val10 = (List<Integer> a) -> {
            int i = 6;
            int j = 3;
            System.out.println("Nums array list: " + nums);
            if (nums.get(i) > nums.get(j)){
                System.out.println(nums.get(i) + " is > " + nums.get(j));
                return 1;
            } else if (nums.get(i) == nums.get(j)) {
                System.out.println(nums.get(i) + " = " + nums.get(j));
                return 0;
            } else {
                System.out.println(nums.get(i) + " is < " + nums.get(j));
                return -1;
            }
        };
        System.out.println(val10.calc(nums));

        lambdaOneArg<Integer> val11 = (a) -> {
            a = 17;
            System.out.println("Nums length is " + nums.size());
            List<Integer> newAddedNums = new ArrayList<Integer>(nums);
            newAddedNums.add(a);
            System.out.println("Added nums length is " + newAddedNums.size());
            return a;
        };
        System.out.println("New element is " + val11.oneArg(0));


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

    static boolean isPrime(List<Integer> i) {
        //determine if the value at the index i is a prime number.  return true if yes, return false if no.
        int n;
        Boolean prime = false;
        for(n=0; n<nums.size(); n++){
            // condition for nonprime number
            for (int val = 2; val <= nums.get(n)/2; ++val)
                if(nums.get(n) % val == 0) {
                    break;
                } else {
                    prime = true;
                }
            if (prime) {
                System.out.print("Number " + nums.get(n) + " at index " + String.valueOf(n) + " is prime. ");
                return true;
            }
        }
        System.out.print("No prime numbers ");
        return false;
    }

    static <i> double added(List<Integer> i) {
        //add all the elements in the list.  return the sum.
        double sum = 0;
        for (int n = 0; n< Numbers.nums.size(); n++)
            sum += Numbers.nums.get(n);
        return sum;
    }

    static <i> double subtracted(List<Integer>i) {
        //subtract all the elements in the list. return the remainder.
        double sum = nums.get(0);
        for (int n = 1; n<nums.size(); n++)
            sum -= nums.get(n);
        return sum;
    }

    static <i> long multiplied(List<Integer>i) {
//        //multiply all the elements in the list. and return the product.
        long product = nums.get(0);
        for (int n = 1; n<nums.size(); n++)
            product *= nums.get(n);
        return product;
    }

    static <i> double divided(List<Integer>i) {
//        //multiply all the elements in the list. and return the product.
        double product = nums.get(0);
        for (int n = 1; n<nums.size(); n++)
            product /= nums.get(n);
        return product;
    }

    static <a> int findMax(List<Integer>a) {
        //return the maximum value in the list.
        List<Integer> sortedList = new ArrayList<>(nums);
        Collections.sort(sortedList);
        return sortedList.get(sortedList.size()-1);
    }

    static <a> int findMin(List<Integer>a) {
        //return the minimum value in the list.
        List<Integer> sortedList = new ArrayList<>(nums);
        Collections.sort(sortedList);
        return sortedList.get(0);
    }

    static int compare(List<Integer> nums) {
//        //compare the values stored in the array at index position i and j.
//        //if the value at i is greater, return 1.  if the value at j is greater, return -1.  if the two values are equal, return 0.
        int i = 2;
        int j = 3;
        System.out.println("Nums array list: " + nums);
        if (nums.get(i) > nums.get(j)){
            System.out.println(nums.get(i) + " is > " + nums.get(j));
            return 1;
        } else if (nums.get(i) == nums.get(j)) {
            System.out.println(nums.get(i) + " = " + nums.get(j));
            return 0;
        } else {
            System.out.println(nums.get(i) + " is < " + nums.get(j));
            return -1;
        }
    }

    static int append(int n) {
        //add a new value to the values list. return that value after adding it to the list.
        System.out.println("Nums length is " + nums.size());
        List<Integer> addedNums = new ArrayList<Integer>(nums);
        addedNums.add(n);
        System.out.println("Added nums length is " + addedNums.size());
        return n;
    }

}

@FunctionalInterface
interface lambdaCalc<T, R> {
    public R calc(T t);
}

@FunctionalInterface
interface lambdaOneArg<T> {
    public T oneArg(T t);
}