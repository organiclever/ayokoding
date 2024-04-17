# handling a zero division error

# Output: Error: Division by zero
try:
    result = 10 / 0
except ZeroDivisionError:
    print("Error: Division by zero")

print("---")

# handling multiple exceptions

# Output: Error: Invalid integer
try:
    result = int("abc")
except ValueError:
    print("Error: Invalid integer")
except ZeroDivisionError:
    print("Error: Division by zero")

print("---")

# handling any unhandled exceptions

# Output: An exception occurred: division by zero
try:
    result = 10 / 0
except Exception as e:
    print("An exception occurred:", str(e))

print("---")

# using a finally block

# Output: Error: File not found. Finally block always executed
try:
    f = open("non-existent-file.txt", "r")
    # code to read or manipulate the file
except FileNotFoundError:
    print("Error: File not found")
finally:
    print("Finally block always executed")

print("---")

# raising custom exceptions


class CustomException(Exception):
    pass


def validate_age(age):
    if age < 0 or age > 120:
        raise CustomException("Invalid age")


# Output: Error: Invalid age
try:
    user_age = -5
    validate_age(user_age)
except CustomException as e:
    print("Error:", str(e))
