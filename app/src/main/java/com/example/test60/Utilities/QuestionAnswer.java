package com.example.test60.Utilities;

import com.example.test60.R;

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
                    "System.out.println((a > b && || (a < b && d));",
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
            {"prevent variable from being serialized","prevent class from being subclasse","prevent method from being overridden.","declare variable whose value will not be change"},
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
            "prevent class from being subclasse",
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

    public static EasyAverageQuestions[] easyQuestions = {
            new EasyAverageQuestions("Java is short for \"JavaScript\"", "False", "True", "False", "Not sure"),
            new EasyAverageQuestions("James Gosling is the creator of Java", "True", "False", "Not sure", "Not applicable"),
            new EasyAverageQuestions("Oracle Corporation is the current owner of the official implementation of the Java SE platform", "True", "False", "Not sure", "Not applicable"),
            new EasyAverageQuestions("Java was created in 1995", "False", "True", "False", "Not sure"),
            new EasyAverageQuestions("JavaScript is not part of Java", "True", "False", "Not sure", "Not applicable"),
            new EasyAverageQuestions("The basic syntax of Java involves four components: object, class, methods, and instance variables", "True", "False", "Not sure", "Not applicable"),
            new EasyAverageQuestions("The stop statement is used to stop a loop", "True", "False", "Not sure", "Not applicable"),
            new EasyAverageQuestions("The operator * is used to multiply numbers", "True", "False", "Not sure", "Not applicable"),
            new EasyAverageQuestions("In Java, it is possible to inherit attributes and methods from one class to another", "True", "False", "Not sure", "Not applicable"),
            new EasyAverageQuestions("Do array indexes start with 1 in Java?", "False", "True", "Not sure", "Not applicable"),
            new EasyAverageQuestions("The value of a string variable can be surrounded by single quotes", "False", "True", "Not sure", "Not applicable"),
            new EasyAverageQuestions("Java is platform-independent", "True", "False", "Not sure", "Not applicable"),
            new EasyAverageQuestions("In Java, variable names are case-sensitive", "True", "False", "Not sure", "Not applicable"),
            new EasyAverageQuestions("Java does not support multiple inheritance", "False", "True", "Not sure", "Not applicable"),
            new EasyAverageQuestions("Java uses curly braces ({}) to define blocks of code", "True", "False", "Not sure", "Not applicable")
    };

    public static EasyAverageQuestions[] averageQuestions = {
            new EasyAverageQuestions("What is a correct syntax to output \"Hello World\" in Java?", "System.out.println(\"Hello World\");", "echo(\"Hello World\");", "print(\"Hello World\");", "Console.WriteLine(\"Hello World\");"),
            new EasyAverageQuestions("How do you insert COMMENTS in Java code?", "//This is a comment", "# This is a comment", "/* This is a comment", "/ This is a comment /"),
            new EasyAverageQuestions("Which data type is used to create a variable that should store text?", "String", "string", "myString", "Txt"),
            new EasyAverageQuestions("How do you create a variable with the numeric value 5?", "num x = 5", "int x = 5;", "x = 5;", "float x = 5;"),
            new EasyAverageQuestions("How do you create a variable with the floating number 2.8?", "float x = 2.8f;", "x = 2.8f;", "int x = 2.8f;", "byte x = 2.8f;"),
            new EasyAverageQuestions("Which method can be used to find the length of a string?", "length()", "getSize()", "getLength()", "Length()"),
            new EasyAverageQuestions("Which operator is used to add together two values?", "The * sign", "The + sign", "The & sign", "The / sign"),
            new EasyAverageQuestions("Which method can be used to return a string in upper case letters?", " toUpperCase()", " tuc()", " upperCase()", " touppercase()"),
            new EasyAverageQuestions("Which operator can be used to compare two values?", " ==", " ><", " <>", " ="),
            new EasyAverageQuestions("To declare an array in Java, define the variable type with:", " []", " ()", " {}", " {()}"),
            new EasyAverageQuestions("How do you create a method in Java?", " methodName()", " methodName", " (methodName)", " methodName[]"),
            new EasyAverageQuestions("How do you call a method in Java?", " methodName();", " (methodName);", " methodName[]", " methodName;"),
            new EasyAverageQuestions("Which keyword is used to create a class in Java?", " class", " className", " class()", " MyClass"),
            new EasyAverageQuestions("What is the correct way to create an object called myObj of MyClass?", " MyClass myObj = new MyClass();", " class myObj = new MyClass();", " class MyClass = new myObj();", " new myObj = MyClass();"),
            new EasyAverageQuestions("How do you start writing a while loop in Java?", " while (x > y)", " while x > y {", " x > y while {", " while x > y:")
    };


    public static HardQuestions[] hardQuestions = {
        new HardQuestions("What is the output of the following:", R.drawable.about, "50 is found at index: 3", "50 is found at index: 5", "50 is found at index: 2", "50 is found at index: 0"),
        new HardQuestions("What is the output of the program when executed?", R.drawable.about, "The sum is: 15 ", "The sum is: 1 ", "The sum is: 10 ", "The sum is: 6"),
        new HardQuestions("What is the output of the program when executed?", R.drawable.about, "\"Alice\", \"Bob\" ", "\"Bob\", \"Alice\"", "\"Bob\", \"Bob\" ", "\"Alice\", \"Alice\" "),
        new HardQuestions("What is the output of the program when executed?", R.drawable.about, "2", "1", "10", "20"),
        new HardQuestions("What is the output of the program:", R.drawable.about, "syntax error", "i", "S", "200"),

        new HardQuestions("what is the output of the following:", R.drawable.about, "true, true, false", "True, ok, true", "true, TRue, ok", "ok, treu, true"),
        new HardQuestions("What is output of the following:", R.drawable.about, "6 6 6, 12 12 12, 18, 18, 18", "8 8 8, 16 16 16, 24 24 24", "2 2 2, 4 4 4, 6 6 6", "4 4 4, 8 8 8, 12 12 12"),
        new HardQuestions("Where will be the most chance of the garbage collector being invoked?", R.drawable.about, "Garbage collector never invoked in methodA()", "after line 11", "after line 9 ", "after line 10"),
        new HardQuestions("After line 8 runs. how many objects are eligible for garbage collection?", R.drawable.about, "1", "0", "2", "3"),
        new HardQuestions("What is the output of the following:", R.drawable.about, "foo bar", "foo", "MyThread foo", "MyThread bar"),

        new HardQuestions("What will be the output of the program", R.drawable.about, "An exception is thrown at runtime", "args[2] = null", "args[2] = 3", "args[2] = 2"),
        new HardQuestions("what will be the output of the program:", R.drawable.about, "compilation fails", "An exception is thrown at runtime", "x=1", "x=0"),
        new HardQuestions("What will be the output of the following:", R.drawable.about, "false true", "true true", "true false", "false false"),
    };


}
