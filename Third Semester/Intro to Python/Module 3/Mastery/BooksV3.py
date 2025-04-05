#Program: BooksV3.py
#Course: ITSE-1373-7P1
#Author: Kc Poland
#Description: This program reads data from book.txt and outputs the appropriate data to 3 separate output files: output.txt, reorder.txt, and mystery.txt.



# Variables #
books = open("book.txt")
output = open("output.txt", "w")
reorder = open("reorder.txt", "w")
mystery = open("mystery.txt", "w")


# Program Start Message #
print("\nProcessing book data...")


# Program Loop #
for line in books:
	# Convert Record to List #
	lineList = line.strip().split(",")


	# Separate Data #
	id = lineList[0]
	title = lineList[1]
	genre = lineList[2]
	price = lineList[3]
	paperback = lineList[4]
	quantity = lineList[5]
	authorFirst = lineList[6]
	authorLast = lineList[7]
	publisher = lineList[8]


	# Output to Files #

	# output.txt
	for index in range(0, len(lineList)):
		if index == (len(lineList) - 1):
			output.write(lineList[index] + "\n")
		else:
			output.write(lineList[index] + " |")

	# reorder.txt
	if float(price) * int(quantity) < 50:
		reorder.write(str(id + "," + title + "," + price + "," + quantity + "\n"))

	# mystery.txt
	if genre.strip() == "MYS":
		mystery.write(title.strip() + "\n")


# Program End Message #
print("\nBook data processed.")
print("output.txt, reorder.txt, and mystery.txt files updated.")


# Close Files #
books.close()
output.close()
reorder.close()
mystery.close()