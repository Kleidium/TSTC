#Program: BookStarter.py
#Course: ITSE-1373-7P1
#Author: Kc Poland
#Description: This program provides a simple menu for keeping track of and searching through an inventory of books. Books can be added, deleted, searched, and written to file.
#This is the main program file.

#Make sure book.txt is in the same folder as this file.  



# Imports #
import helper



# Delcarations #

# Book Fields
sID = []
sTitle = []
sGenre = []
fPrice = []
sPaperback = []
iOnHand = []
sAuthorFirst = []
sAuthorLast = []
sPublisher = []

# Holds New Book Data
newBook = [0, 1, 2, 3, 4, 5, 6, 7, 8]
# Holds User Input
answer = ""



# Read Book Fields #
file1 = open("book.txt", "r")

for sLine in file1:
    record = sLine.strip().split(",")
    sID.append(record[0].strip())
    sTitle.append(record[1].strip())
    sGenre.append(record[2].strip())
    fPrice.append(float(record[3].strip()))
    sPaperback.append(record[4].strip())  
    iOnHand.append(int(record[5].strip()))
    sAuthorFirst.append(record[6].strip())
    sAuthorLast.append(record[7].strip())
    sPublisher.append(record[8].strip())

file1.close()



# Program Loop #
while (answer != "6"):
    helper.printMenu()

    answer = input("\nSelect an option: ")


    # View Books #
    if answer == "1":
        print("\n\n\t\t\tBook List:")
        print("")
        for i in range(0, len(sID)):
            print(sID[i] + "," + sTitle[i] + "," + sGenre[i] + "," + str(fPrice[i]) + "," + sPaperback[i] + "," + str(iOnHand[i]) + "," + sAuthorFirst[i] + "," + sAuthorLast[i] + "," + sPublisher[i])
        input("\nPress Enter to continue...")
    

    # Add Books #
    if answer == "2":
        validID = False

        # Prompt for Information
        while (validID == False):
            newBook[0] = input("\nEnter the ID of the book: ")
            validID = helper.isValidID(newBook[0])
        newBook[1] = input("\nEnter the title of the book: ")
        newBook[2] = input("\nEnter the genre of the book: ")
        newBook[3] = float(input("\nEnter the price of the book: "))
        newBook[4] = input("\nIs this book paperback? Y/N: ")
        newBook[5] = int(input("\nEnter the amount of copies on hand: "))
        newBook[6] = input("\nEnter the author's first Name: ")
        newBook[7] = input("\nEnter the author's last Name: ")
        newBook[8] = input("\nFinally, enter the publisher of the book: ")

        # Append to Book Lists
        sID.append(newBook[0])
        sTitle.append(newBook[1])
        sGenre.append(newBook[2])
        fPrice.append(newBook[3])
        sPaperback.append(newBook[4])  
        iOnHand.append(newBook[5])
        sAuthorFirst.append(newBook[6])
        sAuthorLast.append(newBook[7])
        sPublisher.append(newBook[8])
        print("\nBook added to list.")

        # Continue
        input("\nPress Enter to continue...")


    # Find Books #
    if answer == "3":
        print("\nWould you like to search by Title or ID?")
        print("1. Title")
        print("2. ID")

        answer = input("\nAnswer: ")
        
        # Title Search
        if answer == "1":
            results = 0

            searchTitle = input("\nPlease enter all or part of the title: ")
            print("")

            for i in range(0, len(sTitle)):
                if searchTitle.upper() in sTitle[i].upper():
                    results = results + 1
                    print(sID[i] + "," + sTitle[i] + "," + sGenre[i] + "," + str(fPrice[i]) + "," + sPaperback[i] + "," + str(iOnHand[i]) + "," + sAuthorFirst[i] + "," + sAuthorLast[i] + "," + sPublisher[i])

            print("\n" + str(results) + " result(s) found.")


        # ID Search
        if answer == "2":
            results = 0

            searchID = input("\nPlease enter the ID of the book: ")
            print("")

            for i in range(0, len(sID)):
                if sID[i] == searchID:
                    results = results + 1
                    print(sID[i] + "," + sTitle[i] + "," + sGenre[i] + "," + str(fPrice[i]) + "," + sPaperback[i] + "," + str(iOnHand[i]) + "," + sAuthorFirst[i] + "," + sAuthorLast[i] + "," + sPublisher[i])

            print("\n" + str(results) + " result(s) found.")
        
        # Continue
        input("\nPress Enter to continue...")
    

    # Delete Books #
    if answer == "4":
        # Display List
        print("\n\n\t\t\tBook List:")
        print("")
        for i in range(0, len(sID)):
            print("[" + str(i) + "]. " + sID[i] + "," + sTitle[i] + "," + sGenre[i] + "," + str(fPrice[i]) + "," + sPaperback[i] + "," + str(iOnHand[i]) + "," + sAuthorFirst[i] + "," + sAuthorLast[i] + "," + sPublisher[i])
        
        print("\nWhich book would you like to delete? Please enter the list number.")
        answer = input("Answer: ")

        # Remove Chosen Book
        for i in range(0, len(sID)):
            if str(i) == answer:
                sID.pop(i)
                sTitle.pop(i)
                sGenre.pop(i)
                fPrice.pop(i)
                sPaperback.pop(i) 
                iOnHand.pop(i)
                sAuthorFirst.pop(i)
                sAuthorLast.pop(i)
                sPublisher.pop(i)
                print("\nBook removed from list.")
        
        # Continue
        input("\nPress Enter to continue...")


    # Write Books to File #
    if answer == "5":
        output = open("output.txt", "w")

        for i in range(0, len(sID)):
            output.write(sID[i] + ", " + sTitle[i] + ", " + sGenre[i] + ", " + str(fPrice[i]) + ", " + sPaperback[i] + ", " + str(iOnHand[i]) + ", " + sAuthorFirst[i] + ", " + sAuthorLast[i] + ", " + sPublisher[i] + "\n")
        
        output.close()
        print("\nBook list written to file.")
        
        # Continue
        input("\nPress Enter to continue...")
    

    # Quit #
    if answer == "6":
        print("\nExiting program...")