#Program: BooksV6.py
#Course: ITSE-1373-7P1
#Author: Kc Poland
#Description: This program provides a simple menu for keeping track of and searching through an inventory of books. Books can be added, deleted, searched, and written to file.
#This is the helper module.



import os



# Clears Console
clear = lambda: os.system('cls')


# Prints Main Menu
def printMenu():
    clear()
    print("-------- Menu --------\n")
    print("1. View Books Entry")
    print("2. Add Book Entry")
    print("3. Find Book Entry")
    print("4. Delete Book Entry")
    print("5. Write Book List to File")    
    print("6. Quit")
    

# Determines Book ID Validity
def isValidID(bID):
    # Length Check
    if len(bID) != 4:
        print("Invalid ID. The Book ID must be exactly 4 characters long.")
        return False
    
    # Duplicate ID Check
    try:
        file = open("book.txt", "r")
        try:
            for line in file:
                record = line.strip().split(",")
                if record[0] == bID:
                    raise Exception("Invalid ID. This ID already exists!")
        except:
            print("Invalid ID. This ID already exists!")
            return False
        finally:
            file.close()
    except:
        print("ERROR: The book.txt file could not be opened!")
        exit()


# Determines if Book Genre is 3 characters long 
def isValidGenre(bGenre):
    if len(bGenre) == 3:
        return True
    else:
        print("Invalid Genre. The Book Genre must be exactly 3 characters long.")
        return False
   
    
# Determines if character is "Y" or "N"
def isValidChar(char):
    if (char == "Y" or char == "N"):
        return True
    else:
        print("Invalid input. Please enter \"Y\" or \"N\".")
        return False