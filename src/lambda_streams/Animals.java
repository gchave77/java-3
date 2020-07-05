package lambda_streams;

import java.util.*;
import java.util.stream.Collectors;

class Animals {
    //This class will be using streams.
    static List<String> animals = Arrays.asList("peacoCK","rabbit","chiwawa","OranguTAN","vipeR","cobra","paNDa","bUffalo","DeeR","maLLard");

    public static void main(String[] args) {
        System.out.println("original animals : " + animals);

        //clean up the animals array by using the capsFirst() method. follow instructions in the method definition.
        List<String> cleaned = capsFirst(animals, false);
        System.out.println("Cleaned: " + cleaned);

        //do not modify these addAnimal() method invocations
        addAnimal("rEIndeeR");
        addAnimal("Platypus");
        addAnimal("frOg");
        addAnimal("lEOpArD");
        System.out.println("Add animals: " + animals);
        //---------------------------------------

        capsFirst(animals,true);
        System.out.println("Caps first: " + animals);

        List<String> lowered = lowerFirst(animals,false);
        System.out.println("Lowered first: " + lowered);

        List<String> flip = flipAnimals(false);
        System.out.println("Flip animals: " + flip);

        List<String> sort = sortAnimals(false);
        System.out.println("Sorted animals: " + sort);



        System.out.println(" ");
        System.out.println("Begin Lambdas");

        LambdaListBool val1 = (list, mutate) -> {
            flipAnimals(mutate);
            return list;
        };
        System.out.print("Lambda flipAnimals: ");
        System.out.println(val1.calc(animals, true));


        LambdaListBool val2 = (list, mutate) -> {
            lowerFirst(animals, mutate);
            return animals;
        };
        System.out.print("Lambda lowerFirst: ");
        System.out.println(val2.calc(animals, true));


        LambdaListBool val3 = (list, mutate) -> {
            capsFirst(animals, mutate);
            return animals;
        };
        System.out.print("Lambda capsFirst: ");
        System.out.println(val3.calc(animals, true));


        LambdaListBool val5 = (list, mutate) -> {
            addAnimal("Jabberwocky");
            return animals;
        };
        System.out.print("Lambda addAnimal: ");
        System.out.println(val5.calc(animals, true));


        LambdaListBool val4 = (list, mutate) -> {
            sortAnimals(mutate);
            return animals;
        };
        System.out.print("Lambda sortAnimals: ");
        System.out.println(val4.calc(animals, true));


    }

    static List<String> capsFirst(List<String> animaList, boolean mutate) {
        //clean up the animals list so that the first letter is capitalized, and all the other letters are lowercased. Use a stream to accomplish this task.  Also, the 2nd parameter of this function is a boolean.  use this boolean 'flag' to determine whether or not to 'mutate' the original animals array stored as a static class field.  if the flag is set to 'true', mutate the animals and return the animals out of the function.  if it is false, create a copy of the animals, perform your stream operations on the copy, and return the copy of animals out of the function, WITHOUT modifying the original animals array.
        if(mutate){
            animals = animaList.stream()
                    .map(x -> x.toLowerCase())
                    .map(x -> x.substring(0, 1).toUpperCase() + x.substring(1).toLowerCase())
                    .collect(Collectors.toList());
        } else {
            List<String> animaList2 = animaList;
            return animaList2.stream()
                    .map(x -> x.substring(0, 1).toUpperCase() + x.substring(1).toLowerCase())
                    .collect(Collectors.toList());
        }
        return animals;
    }

    static String addAnimal(String animal) {
        //add an animal to the animal list.
        ArrayList<String> animaList3 = new ArrayList<>(animals);
//        ArrayList<String> updatedAnimals = new ArrayList<String>(animals);
        animaList3.add(animal);
        animals = animaList3;
        return animal;
    };


    static List<String> lowerFirst(List<String> animaList, boolean mutate) {
        //lowercase the first letter, and uppercase the rest of the letters, using streams.  Also, depending on the value of the boolean flag 'mutate', mutate the original animals list, or perform your stream operations on a 'copy' of the animals list.  return the list out of hte function in both cases.
        if(mutate){
            animals = animaList.stream()
                    .map(x -> x.toUpperCase())
                    .map(x -> x.substring(0, 1).toLowerCase() + x.substring(1).toUpperCase())
                    .collect(Collectors.toList());
        } else {
            List<String> animaList3 = animaList;
            return animaList3.stream()
                    .map(x -> x.substring(0, 1).toLowerCase() + x.substring(1).toUpperCase())
                    .collect(Collectors.toList());
        }
        return animaList;
    }

    static List<String> flipAnimals(boolean mutate) {
        //reverse the order of the animals in the animal list.  If the booleaen parameter is true, reverse the static animals array list by mutating the array.  if the mutate boolean is false, flip a 'copy' of the animals list, then return that list of flipped animals, WITHOUT mutating the static animals array. return the flipped list in both cases.

//        List<String> instructions = Arrays.asList("Flip","the","animals","list","."," ","Mutate","the","animals","only","if","flag","true");
//        return instructions;
        if(mutate){
            Collections.reverse(animals);
        } else {
            List<String> animaList4 = animals;
            Collections.reverse(animaList4);
        }
        return animals;
    }

    static List<String> sortAnimals(boolean mutate) {
        //sort the animals in alphabetical order.  If the booleaen parameter is true, mutating the animals list.  if the mutate boolean is false, sort a 'copy' of the animals list, then return that list of sorted animals, WITHOUT mutating the static animals array. return the sorted list in both cases.
        if (mutate) {
            Collections.sort(animals);
        } else {
            List<String> animaList5 = animals;
            Collections.sort(animaList5);
        }
        return animals;
    }


}

@FunctionalInterface
interface LambdaListBool {
    List<String> calc(List<String> list, boolean mutate);
}
