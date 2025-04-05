#Program: BooksV5.py
#Course: ITSE-1373-7P1
#Author: Kc Poland
#Description: This program provides a simple menu for keeping track of and searching through an inventory of books. Books can be added, deleted, searched, and written to file.
#This is the Book class module.



class Book:
    # Attributes #
    sID = ""
    sTitle = ""
    sGenre = ""
    fPrice = 0.00
    sPaperback = ""
    iOnHand = 0
    sAuthorFirst = ""
    sAuthorLast = ""
    sPublisher = ""
    

    # Constructor #
    def __init__(self, id, title, genre, price, paperback, onHand, authorFirst, authorLast, publisher):
        self.sID = id
        self.sTitle = title
        self.sGenre = genre
        self.fPrice = price
        self.sPaperback = paperback
        self.iOnHand = onHand
        self.sAuthorFirst = authorFirst
        self.sAuthorLast = authorLast
        self.sPublisher = publisher


    # Functions #
    def printBookInfo(self):
        print(self.sID + ", " + self.sTitle + ", " + self.sGenre + ", " + str(self.fPrice) + ", " + self.sPaperback + ", " + str(self.iOnHand) + ", " + self.sAuthorFirst + ", " + self.sAuthorLast + ", " + self.sPublisher)

    def writeBookInfo(self, file):
        file.write(self.sID + ", " + self.sTitle + ", " + self.sGenre + ", " + str(self.fPrice) + ", " + self.sPaperback + ", " + str(self.iOnHand) + ", " + self.sAuthorFirst + ", " + self.sAuthorLast + ", " + self.sPublisher + "\n")

    def addToOnHand(self, int):
        self.iOnHand += int
    
    def setPrice(self, float):
        self.fPrice = float



# # Test Function #  
# def testFunction():
#     # Create Book Instance
#     newBook = Book("2000", "Book Title", "MYS", 10.99, "Y", 7, "Firstname", "Lastname", "Publisher")
    
#     # Test Print Function
#     print("\nPrint Function:")
#     newBook.printBookInfo()

#     # Test Write Function
#     testFile = open("testOutput.txt", "w")
#     newBook.writeBookInfo(testFile)
#     testFile.close()
#     print("\nBook written to file.")

#     # Test Add Inventory Function
#     print("\nOriginal Inventory: " + str(newBook.iOnHand))
#     newBook.addToOnHand(100)
#     print("New Inventory: " + str(newBook.iOnHand))

#     # Test Change Price Function
#     print("\nOriginal Price: $" + str(newBook.fPrice))
#     newBook.setPrice(20.57)
#     print("New Price: $" + str(newBook.fPrice))


# # Call Test Function #
# testFunction()