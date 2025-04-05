#Program: BooksV6.py
#Course: ITSE-1373-7P1
#Author: Kc Poland
#Description: This program provides a simple menu for keeping track of and searching through an inventory of books. Books can be added, deleted, searched, and written to file.
#The program now utilizes regular expressions and exception handling. The extra exception handling requirements for this assessment are located in this file.
#This is the main program file.

#Make sure book.txt is in the same folder as this file.  



# Imports #
import helper
import BookClass
import re



# Delcarations #

# Book Object List
books = []
# Holds New Book Data
newBook = [0, 1, 2, 3, 4, 5, 6, 7, 8]
# Holds User Input
answer = ""



# Read Book Fields #
try:    # EXTRA ERROR HANDLING REQUIREMENT (Rubric: Change 6)
    file1 = open("book.txt", "r")

    for sLine in file1:
        record = sLine.strip().split(",")
        book = BookClass.Book(record[0].strip(), record[1].strip(), record[2].strip(), float(record[3].strip()), record[4].strip(), int(record[5].strip()), record[6].strip(), record[7].strip(), record[8].strip())
        books.append(book)

    file1.close()
except:
    print("\nERROR: An error occured when attempting to read from book.txt.")
    exit()



# Program Loop #
while (answer != "6"):
    helper.printMenu()

    answer = input("\nSelect an option: ")


    # View Books #
    if answer == "1":
        print("\n\n\t\t\tBook List:")
        print("")
        for i in range(0, len(books)):
            books[i].printBookInfo()
        input("\nPress Enter to continue...")
    

    # Add Books #
    if answer == "2":
        validID = False
        validGenre = False
        validPrice = False
        validChar = False
        validInt = False

        # Prompt for Information

        # ID
        while (validID == False):
            newBook[0] = input("\nEnter the ID of the book: ")
            validID = helper.isValidID(newBook[0])
        
        # Title
        newBook[1] = input("\nEnter the title of the book: ")
        
        # Genre
        while (validGenre == False):
            newBook[2] = input("\nEnter the genre of the book: ")
            validGenre = helper.isValidGenre(newBook[2])
        
        # Price
        while (validPrice == False):
            try:
                newBook[3] = float(input("\nEnter the price of the book: "))
                validPrice = True
            except:
                print("Invalid input. Input must be a number.")
                validPrice = False
        
        # Paperback Status
        while (validChar == False):
            newBook[4] = input("\nIs this book paperback? Y/N: ")
            validChar = helper.isValidChar(newBook[4].upper())
        
        # Copies On Hand
        while (validInt == False):
            try:
                newBook[5] = int(input("\nEnter the amount of copies on hand: "))
                validInt = True
            except:
                print("Invalid input. Input must be a whole number.")
                validInt = False
        
        # Author First
        newBook[6] = input("\nEnter the author's first Name: ")
        
        # Author Last
        newBook[7] = input("\nEnter the author's last Name: ")
        
        # Publisher
        newBook[8] = input("\nFinally, enter the publisher of the book: ")

        # Confirmation
        print("\nAdd this book?\n")
        print(newBook[0] + ", " + newBook[1] + ", " + newBook[2].upper() + ", " + str(newBook[3]) + ", " + newBook[4].upper() + ", " + str(newBook[5]) + ", " + newBook[6] + ", " + newBook[7] + ", " + newBook[8])
        print("\n1. Yes")
        print("2. No")

        answer = input("\nAnswer: ")

        if (answer == "1"):
            # Append to Book List
            book = BookClass.Book(newBook[0], newBook[1], newBook[2].upper(), newBook[3], newBook[4].upper(), newBook[5], newBook[6], newBook[7], newBook[8])
            books.append(book)
            print("\nBook added to list.")
        else:
            #Do Nothing
            print("\nNo action taken.")

        # Continue
        answer = "INVALID"
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

            for i in range(0, len(books)):
                if re.search(searchTitle.upper(), books[i].sTitle.upper()) != None:
                    results = results + 1
                    books[i].printBookInfo()

            print("\n" + str(results) + " result(s) found.")


        # ID Search
        if answer == "2":
            results = 0

            searchID = input("\nPlease enter the ID of the book: ")
            print("")

            for i in range(0, len(books)):
                if books[i].sID == searchID:
                    results = results + 1
                    books[i].printBookInfo()

            print("\n" + str(results) + " result(s) found.")
        
        # Continue
        answer = "INVALID"
        input("\nPress Enter to continue...")
    

    # Delete Books #
    if answer == "4":
        # Display List
        print("\n\n\t\t\tBook List:")
        print("")
        for i in range(0, len(books)):
            books[i].printBookInfo()

        # Choose Method
        print("\n\nWould you like to delete by Title or ID?")
        print("1. Title")
        print("2. ID")

        answer = input("\nAnswer: ")
        

        # Title Search
        if answer == "1":
            searchResults = []  # Holds Book Indexes
            results = 0

            print("\nWhich book would you like to delete? Please enter all or part of the title.")
            searchTitle = input("Answer: ")

            helper.clear()
            print("\t\t\t\tSearch Results:")
            print("")

            # Display Search Results
            try:
                x = len(books) - 1  # ASSERTION REQUIREMENT (Rubric: Change 3) #
                assert x > 0, "Book list is empty!"                            #

                for i in range(0, len(books)):
                    if re.search(searchTitle.upper(), books[i].sTitle.upper()) != None:
                        results = results + 1
                        searchResults.append(i)
                        books[i].printBookInfo()

                print("\n" + str(results) + " result(s) found.")
            except:
                print("\nERROR: An error has occured. Exiting program...")
                exit()


            # Choose Book(s)
            if results > 0:
                print("\n\nDelete which book(s)?\n")
                print("0. DELETE NOTHING")
                for i in range(0, len(searchResults)):
                    print(str(i + 1) + ". " + books[searchResults[i]].sTitle + ", ID: " + books[searchResults[i]].sID)
                print("000. DELETE ALL")

                answer = input("\nAnswer: ")

                if answer == "000":
                    # Confirmation
                    print("\nDelete all " + str(results) + " results?\n")
                    print("1. Yes")
                    print("2. No")

                    answer = input("\nAnswer: ")

                    if answer == "1":
                        # Delete All Results
                        for i in sorted(searchResults, reverse=True):   # Must be deleted in reverse order as the indexes shift.
                            print("\n" + books[i].sTitle + " removed from list.")
                            books.pop(i)
                    else:
                        # Do Nothing
                        print("\nNo action taken.")
                elif answer == "0":
                    # Do Nothing
                    print("\nNo action taken.")
                else:
                    # Delete Selected If Any
                    try:
                        deleted = False
                        for i in range(0, len(searchResults)):
                            if int(answer) - 1 == i:
                                # Confirmation
                                print("\nRemove this book?\n")
                                books[searchResults[i]].printBookInfo()
                                print("\n1. Yes")
                                print("2. No")

                                answer = input("\nAnswer: ")

                                if (answer == "1"):
                                    # Remove
                                    print("\n" + books[searchResults[i]].sTitle + " removed from list.")
                                    books.pop(searchResults[i])
                                    deleted = True
                                    break
                                else:
                                    break
                        if not deleted:
                            print("\nNo action taken.")
                    except:
                        # Do Nothing
                        print("\nInvalid input. No action taken.")         
        

        # ID Search
        if answer == "2":
            print("\nWhich book would you like to delete? Please enter the full ID number.")
            answer = input("Answer: ")

            # Remove Chosen Book
            if len(books) == 0:
                print("\nBook list is empty. 0 result(s) found.")
            
            for i in range(0, len(books)):
                if books[i].sID == answer:
                    # Confirmation
                    print("\nRemove this book?\n")
                    books[i].printBookInfo()
                    print("\n1. Yes")
                    print("2. No")

                    answer = input("\nAnswer: ")

                    if (answer == "1"):
                        # Remove
                        print("\n" + books[i].sTitle + " removed from list.")
                        books.pop(i)
                    else:
                        # Do Nothing
                        print("\nNo action taken.")
                    
                    break
                elif i == len(books) - 1:
                    print("\n0 result(s) found.")
        
        # Continue
        answer = "INVALID"
        input("\nPress Enter to continue...")


    # Write Books to File #
    if answer == "5":
        print("\n\n\t\t\tBook List:")
        print("")
        for i in range(0, len(books)):
            books[i].printBookInfo()

        # Confirmation
        print("\nWrite this list to file?\n")
        print("1. Yes")
        print("2. No")

        answer = input("\nAnswer: ")

        if (answer == "1"):
            try:
                # Write to File
                output = open("output.txt", "w")

                for i in range(0, len(books)):
                    books[i].writeBookInfo(output)
                
                output.close()
                print("\nBook list written to file.")
            except:
                print("ERROR: Error encountered when writing to output.txt!")
        else:
            # Do Nothing
            print("\nNo action taken.")
        
        # Continue
        answer = "INVALID"
        input("\nPress Enter to continue...")
    

    # Quit #
    if answer == "6":
        print("\nExiting program...")