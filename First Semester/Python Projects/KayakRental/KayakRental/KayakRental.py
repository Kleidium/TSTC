# Program: KayakRental
# Course: ITSE 1302 7P3
# Author: Kc Poland
# Description: This program determines whether or not a pair of customers can rent a tandem kayak together.
# At least one customer needs to be 18 or over, and their total weight cannot exceed 450 lbs.


# Capture age and weight inputs of both customers
oneAge = int(input("Enter customer 1 age: "))
oneWeight = float(input("Enter customer 1 weight: "))

twoAge = int(input("Enter customer 2 age: "))
twoWeight = float(input("Enter customer 2 weight: "))


# Check ages and weight, output result
if (oneAge < 18 and twoAge < 18):
    print("Can not rent: At least one passenger needs to be 18 or over.")
else:
    if (oneWeight + twoWeight) > 450:
        print("Can not rent: Combined weight exceeds 450 lbs.")
    else:
        print("Customers may rent the tandem kayak.")