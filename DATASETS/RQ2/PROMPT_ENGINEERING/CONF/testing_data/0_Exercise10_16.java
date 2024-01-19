# Importing the necessary libraries (even though we don't really need any)
import math

# Initializing variables
count = 0
number = 1
result_numbers = []

# Looping until we find the first ten numbers
while count < 10:
    # Converting the number to a string with 50 decimal digits
    number_str = str(number)
    while len(number_str) < 50:
        number_str = '0' + number_str

    # Converting the string back to an integer
    number = int(number_str)

    # Checking if the number is divisible by 2 or 3
    if number % 2 == 0 or number % 3 == 0:
        result_numbers.append(number)
        count += 1

    # Incrementing the number
    number += 1

# Printing the result numbers
print("The first ten numbers with 50 decimal digits divisible by 2 or 3 are:")
for num in result_numbers:
    print(num)