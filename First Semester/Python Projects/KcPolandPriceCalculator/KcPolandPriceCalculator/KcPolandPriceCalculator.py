# Program: PriceCalculator
# Course: ITSE 1302 7P3
# Author: Kc Poland
# Description: This program allows a user to enter item prices and the quantity of items purchased.  A while loop will accumulate the item prices multiplied by the quantity of items. 
# When the user is done entering item prices, the user will enter 0 as a price. The program will then calculate the tax amount, and then display the subtotal, tax amount, and total due.

# Initialize subtotal
subTotal = float(0)

# Greeting
print("Welcome to Flormart!")
print("")

# Get initial price
price = float(input("Enter item price: "))

# If price is not 0, get initial quantity and calculate initial subtotal
if price != 0:
    quantity = int(input("How many of item: "))
    subTotal = subTotal + (price * float(quantity))

# Continue adding to subtotal until user inputs 0 for price; then display subtotal, tax, and grand total.
while price != 0:
    price = float(input("Enter item price: "))
    if price == 0:
        continue
    quantity = int(input("How many of item: "))
    subTotal = subTotal + (price * float(quantity))
else:
    print("")
    print("Subtotal: $" + str(format(subTotal, ',.2f')))
    print("Tax: $" + str(format((subTotal * 0.0825), ',.2f')))
    print("Total: $" + str(format((subTotal + (subTotal * 0.0825)), ',.2f')))
    print("")