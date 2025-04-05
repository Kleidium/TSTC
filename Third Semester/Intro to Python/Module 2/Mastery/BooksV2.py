#Program: BooksV2.py
#Course: ITSE-1373-7P1
#Author: Kc Poland
#Description: This program prompts a user for information on books. The user is asked a series of questions about each book and the program displays back some of the information.
#The program loops until the user indicates they are done.



# Global Variables
sentinel = "YES"


# Welcome Message
print("\nGreetings. This is the Bitterleaf Bookstore logistical system.")


# Begin Loop
while (sentinel.upper() == "YES"):
	# Loop Variables
	isbn = ""
	isbnLastFour = ""
	title = ""
	titleFirstFive = ""
	genre = ""
	price = 0.00
	paperback = ""
	onHand = 0
	i = 0
	n = 0


    # Gather Inputs
	while len(isbn) != 10:
		isbn = input("\n\nPlease enter the 10-character ISBN ID for the book: ")
		if len(isbn) != 10:
			print("Invalid input. Please enter 10 characters for the ISBN.")

	title = input("Now enter the title of the book: ")
	genre = input("What is the 3-letter genre ID of \"" + title + "\"?: ")
	price = float(input("Great. Please enter the price of \"" + title + "\": "))
	paperback = input("Is \"" + title + "\" a paperback? (Y/N): ")
	onHand = int(input("Great. How many copies of \"" + title + "\" are on hand?: "))


	# Truncate Data For Display
	for char in isbn:
		i = i + 1
		if i < 7:
			continue
		isbnLastFour = isbnLastFour + char

	for letter in title:
		n = n + 1
		if n > 5:
			break
		titleFirstFive = titleFirstFive + letter


	# Display Results
	print("\n___________________________________________________________")
	print("\t\t***Data Entered***\n")
	print("\t\t" + isbnLastFour + ", " + titleFirstFive + ", " + "${:,.2f}".format(onHand * price))
	print("___________________________________________________________")


	# Continue?
	print("\nWould you like to enter another book's data?")
	sentinel = input("Enter 'yes' to continue or any other text to quit: ")
else:
	print("\n\nExiting...")