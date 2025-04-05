# Program: IDLookUp
# Course: ITSE 1302 7P3
# Author: Kc Poland
# Description: This program allows a user to enter employee IDs. The program will check the entered ID against a list of authorized IDs. It will then display if the entered ID was found in the list or not.
# Entering "XXX" will terminate the program.


#idList stores all the IDs that have access to the archives
idList = ["18550", "98551", "78532", "18521", "48526", "38520", "88578", \
"98583", "48566", "28579", "18586", "88559", "18593", "38570", "28596", "58537", \
"58516", "18577", "78557", "18503", "98501", "28504", "98539"]

print("ID Search\n")

# Initial Input
userID = input("Enter an ID or XXX to quit: ")

# Search for entered IDs until "XXX" is entered
while userID != "XXX":
    if userID in idList:
        print(str(userID) + " is in the list.")
        print("")
    else:
        print(str(userID) + " is NOT in the list.")
        print("")
    userID = input("Enter an ID or XXX to quit: ")
else:
    print("Goodbye!")
    print("")