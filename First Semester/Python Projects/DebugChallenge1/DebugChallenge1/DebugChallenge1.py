#Program: DebugChallenge1
#Course: ITSE 1302 7P3
#Author: Kc Poland
#Description: Calculate the total price of an item after state and city taxes are applied.

#The following program accepts the price of an
#item as input, and then calculates the total price after adding
#city and state sales tax.  The state tax rate is 6%
#and the city tax rate is 2%.  There are five bugs/errors in this program.

STATE_TAX_RATE = 0.06
CITY_TAX_RATE = 0.02
itemPrice = float(input("Enter item price: "))

totalTax = itemPrice * (STATE_TAX_RATE + CITY_TAX_RATE)

totalPrice = itemPrice + totalTax

print("Item price is $" + str(format(itemPrice, ',.2f')) + " and total tax is $" + str(format(totalTax, ',.2f')) + ".")
print("Total price is $" + str(format(totalPrice, ',.2f')))