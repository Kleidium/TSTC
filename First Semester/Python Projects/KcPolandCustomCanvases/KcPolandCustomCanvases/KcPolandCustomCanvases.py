# Program: CustomCanvases
# Course: ITSE 1302 7P3
# Author: Kc Poland
# Description: This program determines the total price for custom canvas orders, priced at $4.99 per square foot.
# The program will prompt for the number of canvases, as well as the length and width of each requested canvas. The total square footage must be at least 20 square feet.
# Then, the program will display the price per square foot, total square footage, and final price.


# Get input for number of canvases, initialize price per square foot and total square feet
canvasNum = int(input("Enter number of canvases: "))
print("")
pricePer = float(4.99)
totalSqFt = float(0)


# Find out length and width of each canvas
for x in range(1, (canvasNum + 1)):
    length = float(input("Enter canvas " + str(x) + " length (ft): "))
    width = float(input("Enter canvas " + str(x) + " width (ft): "))
    print("")
    totalSqFt = totalSqFt + (length * width)    # Add the square feet of each canvas to total square feet
else:
    if totalSqFt < 20:  # Test if total square feet is below minimum
        print("")
        print("Order not big enough.")
        print("")
    else:   # If total square feet meets minimum requirement: display price per sq foot, total canvas sq feet, and total price
        print("")
        print("Price per sq foot: $" + str(pricePer))
        print("Total canvas square feet: " + str(totalSqFt))
        print("Total price: $" + str(format((totalSqFt * pricePer), ',.2f')))
        print("")