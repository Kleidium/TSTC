#Program: CubeSurface.py
#Course: ITSE-1373-7P1
#Author: Kc Poland
#Description: This program calculates and displays the total surface area of a cube in square feet and square meters, using the length of a single side.


# Variables
sideLength = 0.0
surfaceAreaFeet = 0.0
surfaceAreaMeter = 0.0

# Welcome Message
print("\nHello. Welcome to Surface Simulator. It's time to calculate the surface area of your cube.\n")

# Receive input
sideLength = float(input("Please enter the length of a single side in feet: "))

# Calculate Surface Area in Feet and Meters
surfaceAreaFeet = 6 * (sideLength * sideLength)
surfaceAreaMeter = surfaceAreaFeet / 10.765

# Display Results
print("___________________________________________________________")
print("\nCube surface area in square feet: {:,.2f}".format(surfaceAreaFeet))
print("Cube surface area in square meters: {:,.2f}".format(surfaceAreaMeter))
print("___________________________________________________________")