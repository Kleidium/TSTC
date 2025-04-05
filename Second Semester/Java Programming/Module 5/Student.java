//Program: Math Tutor Program
//Course: ITSE-2317-7P1
//Author: Kc Poland
//Description: This console program is a math tutor program for grade school children to practice their addition, subtraction, and multiplication.
//The student will be able to practice until they indicate they are done. Once they are done, their results are displayed.
//This is the Student class file.

public class Student {
    ////Private Data Fields////
    private String name;
    private int attempts;
    private int correct;

    ////Public Functions////

    //Names the student.
    public void setName(String name) {
        this.name = name;
    }

    //Retrieves student name.
    public String getName() {
        return name;
    }

    //Increment number of problem attempts.
    public void incAttempts() {
        attempts = attempts + 1;
    }

    //Retrieves number of problem attempts.
    public int getAttempts() {
        return attempts;
    }

    //Increment number of problems answered correctly.
    public void incCorrect() {
        correct = correct + 1;
    }

    //Show student's total results.
    public void showResults() {
        ////Determine Score////
        int score;
        score = (correct * 100) / attempts;

        ////Display Results////
        System.out.println("");
        System.out.println("***" + name + "'s Results***");
        System.out.println("");
        System.out.println("Total Problems Attempted: " + attempts);
        System.out.println("Total Problems Correct: " + correct);
        System.out.println("");
        System.out.println("Final Score: " + score + "%");
        System.out.println("");

        //Personalized message dependent on score.
        if (score < 70) {
            System.out.println("Don't worry, " + name + ". You'll do better next time. Keep practicing!");
        } else if (score >= 70 && score < 80) {
            System.out.println("You're doing okay, " + name + ". Improve your skills to try and increase your score.");
        } else if (score >= 80 && score < 90) {
            System.out.println("Good job, " + name + "! Keep it up!");
        } else if (score >= 90 && score <= 100) {
            System.out.println("Great work, " + name + "! You've earned an A!");
        }
    }
}