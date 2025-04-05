#Program: BooksV1.py
#Course: ITSE-1373-7P1
#Author: Kc Poland
#Description: This program calculates and displays the total price of a user defined book order, including tax.

# Variables
bookName = ""
bookPrice = 0.0
bookQuantity = 0
subtotal = 0.0
taxTotal = 0.0
total = 0.0
TAX_RATE = 0.0825

# Welcome Message
print("\nGreetings. This is the Bitterleaf Bookstore ordering system.\n")

# Gather Inputs for Name, Price, Quantity
bookName = input("Please enter the name of your book: ")
bookPrice = float(input("Thank you. Please enter the price of \"" + bookName + "\": "))
bookQuantity = int(input("Great. How many copies of \"" + bookName + "\" would you like to order: "))

# Calculate Totals
subtotal = bookPrice * bookQuantity
taxTotal = subtotal * TAX_RATE
total = subtotal + taxTotal

# Display Results
print("___________________________________________________________")
print("\t\t***Receipt***")
print("\nName of Book: " + bookName)
print("Price per Book: ${:,.2f}".format(bookPrice))
print("Number of Copies: " + str(bookQuantity))
print("\n\tSubtotal: ${:,.2f}".format(subtotal))
print("\tTax: ${:,.2f}".format(taxTotal))
print("\tTotal: ${:,.2f}".format(total))
print("\nThank you for shopping at Bitterleaf Bookstore!")
print("___________________________________________________________")