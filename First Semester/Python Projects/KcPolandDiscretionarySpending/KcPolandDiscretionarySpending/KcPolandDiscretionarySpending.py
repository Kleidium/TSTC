#Program: KcPolandDiscretionarySpending
#Course: ITSE 1302 7P3
#Author: Kc Poland
#Description: Calculate the amount of discretionary spending money left after paying monthly bills.



#Variable Input
pay = float(input("Enter monthly pay: "))
rent = float(input("Enter monthly rent: "))
utility = float(input("Enter monthly utility bill total: "))
grocery = float(input("Enter monthly grocery cost: "))

#Calculate totalBills and leftover discretionary
totalBills = (rent + utility + grocery)
discretionary = pay - totalBills

#Output
print("")
print("Total Pay: $" + str(round(pay, 2)) + "")
print("Total Bills: $" + str(round(totalBills, 2)) + "")
print("Discretionary fund: $" + str(round(discretionary, 2)) + "")
print("")