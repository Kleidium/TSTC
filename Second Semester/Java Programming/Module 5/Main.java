//Program: Math Tutor Program
//Course: ITSE-2317-7P1
//Author: Kc Poland
//Description: This console program is a math tutor program for grade school children to practice their addition, subtraction, and multiplication.
//The student will be able to practice until they indicate they are done. Once they are done, their results are displayed.
//This is the Main program file.

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ////Declarations////

        //Variables
        String name;
        int choice = 0;

        //Objects
        Scanner inputDevice = new Scanner(System.in);
        Student student = new Student();

        ////Welcome Message////
        System.out.println("");
        System.out.println("Welcome to Tutor Bot.");
        System.out.println("");

        ////Assign Name////
        System.out.print("Please enter your name: >> ");
        name = inputDevice.nextLine();
        student.setName(name);
        System.out.println("");
        System.out.println("Welcome, " + name + "!");

        ////Main Menu////
        while (choice != 4) {
            System.out.println("");
            System.out.println("Tutor Bot: Main Menu");
            System.out.println("");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Exit");
            System.out.println("");
            System.out.println("Results are shown upon exit.");
            System.out.println("");
            System.out.print("Select an option: >> ");
            choice = inputDevice.nextInt();

            //Invalid Selection
            if (choice == 0 || choice > 4) {
                System.out.println("");
                System.out.println("Invalid selection. Please select a choice from 1-4.");
            }

            //Addition
            if (choice == 1) {
                addition(student);
            }

            //Subtraction
            if (choice == 2) {
                subtraction(student);
            }

            //Multiplication
            if (choice == 3) {
                multiplication(student);
            }

            //Exit + Show Results
            if (choice == 4) {
                if (student.getAttempts() < 1) {
                    System.out.println("");
                    System.out.println("No attempts were made. Goodbye, " + name + "!");
                } else {
                    student.showResults();
                }
            }
        }
    }

    public static void addition(Student student) {
        ////Declarations////
        int firstNum;
        int secondNum;
        int answer;
        int choice = 0;
        Random random = new Random();
        Scanner inputDevice = new Scanner(System.in);

        ////Addition Welcome Message////
        System.out.println("");
        System.out.println("You have chosen Addition. The study session will now begin.");

        ////Addition Session Loop////
        while (choice != 2) {
            ////Reset Choice////
            choice = 0;

            ////Determine Operands////
            do {
                firstNum = random.nextInt(11);
            } while (firstNum == 0);
            do {
                secondNum = random.nextInt(11);
            } while (secondNum == 0);

            ////Display Problem////
            System.out.println("");
            System.out.println("");
            System.out.println(firstNum + " + " + secondNum + " =");
            System.out.println("");
            System.out.println("");
            System.out.print("Answer: >> ");
            answer = inputDevice.nextInt();

            ////Determine Result////
            if (answer == (firstNum + secondNum)) {
                student.incAttempts();
                student.incCorrect();
                System.out.println("");
                System.out.println("Correct! Good job, " + student.getName() + "!");
            } else {
                student.incAttempts();
                System.out.println("");
                System.out.println("Not quite, " + student.getName() + ". Your answer was incorrect.");
            }

            ////Another Problem?////
            while (choice != 1 && choice != 2) {
                System.out.println("");
                System.out.println("Would you like to attempt another problem?");
                System.out.println("");
                System.out.println("1. Yes");
                System.out.println("2. No");
                System.out.println("");
                System.out.print("Select an option: >> ");
                choice = inputDevice.nextInt();

                //Invalid Selection
                if (choice == 0 || choice > 2) {
                    System.out.println("");
                    System.out.println("Invalid selection. Please select choice 1 or 2.");
                }

                //Yes
                if (choice == 1) {
                    System.out.println("");
                    System.out.println("Next Problem:");
                }

                //No
                if (choice == 2) {
                    System.out.println("");
                    System.out.println("Returning to Main Menu.");
                }
            }
        }
    }

    public static void subtraction(Student student) {
        ////Declarations////
        int firstNum;
        int secondNum;
        int answer;
        int choice = 0;
        Random random = new Random();
        Scanner inputDevice = new Scanner(System.in);

        ////Subtraction Welcome Message////
        System.out.println("");
        System.out.println("You have chosen Subtraction. The study session will now begin.");

        ////Subtraction Session Loop////
        while (choice != 2) {
            ////Reset Choice////
            choice = 0;
            
            ////Determine Operands////
            do {
                firstNum = random.nextInt(11);
            } while (firstNum == 0);
            do {
                secondNum = random.nextInt(11);
            } while (secondNum == 0);

            //Ensure the answer cannot be negative.
            if (secondNum > firstNum) {
                int tempNum = firstNum;
                firstNum = secondNum;
                secondNum = tempNum;
            }

            ////Display Problem////
            System.out.println("");
            System.out.println("");
            System.out.println(firstNum + " - " + secondNum + " =");
            System.out.println("");
            System.out.println("");
            System.out.print("Answer: >> ");
            answer = inputDevice.nextInt();

            ////Determine Result////
            if (answer == (firstNum - secondNum)) {
                student.incAttempts();
                student.incCorrect();
                System.out.println("");
                System.out.println("Correct! Good job, " + student.getName() + "!");
            } else {
                student.incAttempts();
                System.out.println("");
                System.out.println("Not quite, " + student.getName() + ". Your answer was incorrect.");
            }

            ////Another Problem?////
            while (choice != 1 && choice != 2) {
                System.out.println("");
                System.out.println("Would you like to attempt another problem?");
                System.out.println("");
                System.out.println("1. Yes");
                System.out.println("2. No");
                System.out.println("");
                System.out.print("Select an option: >> ");
                choice = inputDevice.nextInt();

                //Invalid Selection
                if (choice == 0 || choice > 2) {
                    System.out.println("");
                    System.out.println("Invalid selection. Please select choice 1 or 2.");
                }

                //Yes
                if (choice == 1) {
                    System.out.println("");
                    System.out.println("Next Problem:");
                }

                //No
                if (choice == 2) {
                    System.out.println("");
                    System.out.println("Returning to Main Menu.");
                }
            }
        }
    }

    public static void multiplication(Student student) {
        ////Declarations////
        int firstNum;
        int secondNum;
        int answer;
        int choice = 0;
        Random random = new Random();
        Scanner inputDevice = new Scanner(System.in);

        ////Multiplication Welcome Message////
        System.out.println("");
        System.out.println("You have chosen Multiplication. The study session will now begin.");

        ////Multiplication Session Loop////
        while (choice != 2) {
            ////Reset Choice////
            choice = 0;
            
            ////Determine Operands////
            do {
                firstNum = random.nextInt(11);
            } while (firstNum == 0);
            do {
                secondNum = random.nextInt(11);
            } while (secondNum == 0);

            ////Display Problem////
            System.out.println("");
            System.out.println("");
            System.out.println(firstNum + " x " + secondNum + " =");
            System.out.println("");
            System.out.println("");
            System.out.print("Answer: >> ");
            answer = inputDevice.nextInt();

            ////Determine Result////
            if (answer == (firstNum * secondNum)) {
                student.incAttempts();
                student.incCorrect();
                System.out.println("");
                System.out.println("Correct! Good job, " + student.getName() + "!");
            } else {
                student.incAttempts();
                System.out.println("");
                System.out.println("Not quite, " + student.getName() + ". Your answer was incorrect.");
            }

            ////Another Problem?////
            while (choice != 1 && choice != 2) {
                System.out.println("");
                System.out.println("Would you like to attempt another problem?");
                System.out.println("");
                System.out.println("1. Yes");
                System.out.println("2. No");
                System.out.println("");
                System.out.print("Select an option: >> ");
                choice = inputDevice.nextInt();

                //Invalid Selection
                if (choice == 0 || choice > 2) {
                    System.out.println("");
                    System.out.println("Invalid selection. Please select choice 1 or 2.");
                }

                //Yes
                if (choice == 1) {
                    System.out.println("");
                    System.out.println("Next Problem:");
                }

                //No
                if (choice == 2) {
                    System.out.println("");
                    System.out.println("Returning to Main Menu.");
                }
            }
        }
    }
}