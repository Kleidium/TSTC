#Program: BookStarter.py
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
    

# Determines if Book ID is 4 characters long
def isValidID(bID):
    if len(bID) == 4:
        return True
    else:
        print("Invalid ID. The Book ID must be exactly 4 characters long.")
        return False