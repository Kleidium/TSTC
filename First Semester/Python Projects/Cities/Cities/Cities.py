# Program: Cities
# Course: ITSE 1302 7P3
# Author: Kc Poland
# Description: This program allows a user to enter city names. The program will add each name to a list until "XXX" is entered. 
# When "XXX" is entered, the program sorts the list in descending order and displays the results.


# Initialize list and index counter
cityList = []
indexes = -1

# Initial Input
city = input("Enter city name: ")

# Add entered cities to list and add to index counter until "XXX" is entered
while city != "XXX":
    cityList.append(city)
    indexes = indexes + 1
    city = input("Enter city name: ")
else: # Once "XXX" is entered, reverse sort list and display by index
    cityList.sort(reverse = True)
    print("")
    print("Sorted Cities (descending):")
    print("")
    if indexes > -1:
        for x in range(0, (indexes + 1)):
            print(cityList[x])
    else:
        print("List is empty.")
    print("")