package com.example.test60;

public class QuestionAnswer {

    public static String question[] = {
      "What is a correct syntax to output \"Hello World\" in Java?",
            "How do you insert COMMENTS in Java code?",
            "Which data type is used to create a variable that should store text?",
            "How do you create a method in Java?",
            "Which keyword is used to create a CLASS in Java?",
            "What is the correct syntax for declaring a variable in Java?",
            "How do you create a multi-dimensional array in Java?",
            "What is the purpose of the 'finally' keyword in Java?",
            "Which access modifier allows a class or method to be accessible within the same package?",
            "Which Java keyword is used to indicate that a method in a subclass is intended to override a method in its superclass?",

            "Which of the following statements is true about Java's 'transient' keyword?",
            "Which of the following is NOT a valid access modifier in Java?",

            "what will be the output?\n" +
                    "int arr[] = new int [5];\n" +
                    "system.out.print(arr);",
            "What is the output?\n" +
                    "object[]name = new string[5];\n" +
                    "name[0] = new Integer(0);",
            "How to sort an array?",
            "It is used to copy contents of an array?",
            "Which of these is an incorrect array declaration?",
            "What is the output of the following:\n" +
                    "(1 + 2 * 3) / 4 - 5 + 6 * 7 - 8 % 3",
            "What is the output of the following:\n" +
                    "int a = 5, b = 7, c = true;\n" +
                    "boolean d = false;\n" +
                    "System.out.println((a > b && c) || (a < b && d));",
            "What is the output of the following Java code?\n" +
                    "String str = \"Hello World\";\n" +
                    "str.replace('o', 'a');\n" +
                    "System.out.println(str);",

    };

    public static String choices[][] = {
            {"System.out.println(\"Hello World\");","echo(\"Hello World\");","Console.WriteLine(\"Hello World\");","print (\"Hello World\");"},
            {"// This is a comment","/* This is a comment","# This is a comment","/*/ This is a comment"},
            {"Txt","string","str","myString"},
            {"methodName[]","methodName()","(methodName)","methodName."},
            {"class()","class","className","MyClass"},
            {"int variableName;","variableName = int;","int = variableName;","variableName int;"},
            {"int[] array = new int[];","int[][] array = new int[][];","int[][] array = new int[][];","int array[][] = new int[][];"},
            {"To specify the type of exception to catch","execute code regardless an exception occurs","To re-throw an exception","To terminate the program abruptly"},
            {"public","private","protected","default"},
            {"extend","new","override","super"},
            {"prevent variable from being serialized","prevent class from being subclassed.","prevent method from being overridden.","declare variable whose value will not be changed."},
            {"public","protected","private","package-private"},
            {"value stored in are[0]","00000","garbage value", "0"},
            {"ArrayIndexoutofBoundsException","ArrayStoreException","Code runs successfully","Compilation Error"},
            {"Collection.sort()","system.sort()","arrays.sort()","array.sort()"},
            {"System.arrayCopy()","Array.copy()","Collection.copy()","Array.copy()"},
            {"int[] arr = new int[10];","int arr[]:\n" +
                    "arr = new int[10];","int arr[] = new int[10];","int arr[] = int [10] new;"},
            {"34","27","30","33"},
            {"true","false","compilation error","runtime error"},
            {"Hello World", "Hella World", "Hella Worad", "None of the choices"}
    };
    public static String correctAnswers[] = {
      "System.out.println(\"Hello World\");",
            "// This is a comment",
            "string",
            "methodName()",
            "class",
            "int variableName;",
            "int[][] array = new int[][];",
            "execute code regardless an exception occurs",
            "default",
            "override",
            "prevent class from being subclassed.",
            "package-private",
            "garbage value",
            "ArrayStoreException",
            "array.sort()",
            "System.arrayCopy()",
            "int arr[] = int [10] new;",
            "27",
            "false",
            "Hello World"

    };
}
