#Program: CubeSurfaceV2.py
#Course: ITSE-1373-7P1
#Author: Kc Poland
#Description: This program calculates and displays the total surface area of a cube in square feet and square meters, using the length of a single side.
#The program now loops until the user indicates they are done.



# Variables
sideLength = 0.0
surfaceAreaFeet = 0.0
surfaceAreaMeter = 0.0
sentinel = "YES"


# Welcome Message
print("\nHello. Welcome to Surface Simulator. It's time to calculate the surface area of your cube(s).")


# Begin Loop
while (sentinel.upper() == "YES"):
	# Receive input
	sideLength = float(input("\n\nPlease enter the length of a single side in feet: "))

	# Calculate Surface Area in Feet and Meters
	surfaceAreaFeet = 6 * (sideLength * sideLength)
	surfaceAreaMeter = surfaceAreaFeet / 10.765

	# Display Results
	print("___________________________________________________________")
	print("\n\tCube surface area in square feet: {:,.2f}".format(surfaceAreaFeet))
	print("\tCube surface area in square meters: {:,.2f}".format(surfaceAreaMeter))
	print("___________________________________________________________")

	# Continue?
	print("\nWould you like to calculate the surface area of another cube?")
	sentinel = input("Enter 'yes' to continue or any other text to quit: ")
else:
	print("\n\nExiting Surface Simulator...")