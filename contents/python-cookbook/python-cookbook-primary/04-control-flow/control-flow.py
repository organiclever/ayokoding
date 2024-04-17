# conditional statements

x = 5

# Output: Positive
if x > 0:
    print("Positive")
elif x < 0:
    print("Negative")
else:
    print("Zero")

print("---")

# for loop

fruits = ["apple", "banana", "cherry"]
for fruit in fruits:  # Output: apple banana cherry
    print(fruit)

print("---")

# for else

fruits = ["apple", "banana", "cherry"]
for fruit in fruits:  # Output: apple banana
    print(fruit)
    if fruit == "banana":
        break
else:
    print("Only executed if the loop completes without a break")

print("---")

# while loop

count = 3

# Output: 3 2 1
while count > 0:
    print(count)
    count -= 1

print("---")

# break and continue statements

numbers = [1, 2, 3, 4, 5]

for num in numbers:
    if num == 3:
        break
    print(num)  # Output: 1 2

for num in numbers:
    if num == 3:
        continue
    print(num)  # Output: 1 2 4 5

print("---")

# pass statement


def placeholder_func():
    pass  # Empty function to be defined later


placeholder_func()

print("---")

# exception flow

# Output: Error: Division by zero
try:
    x = 10 / 0
except ZeroDivisionError:
    print("Error: Division by zero")
finally:
    print("Finally block always executed")

print("---")

# ternary operator

a = 5
b = 3

print("a is greater" if a > b else "b is greater")  # Output: a is greater

print("---")

# switch case

response_code = 200

# Output: OK
match response_code:
    case 200:
        print("OK")
    case 404:
        print("404 Not Found")
    case 503:
        print("Internal Server Error")

print("---")

# matching with the or pattern

response_code = 503

# Output: Internal Server Error
match response_code:
    case 200 | 201:
        print("OK")
    case 400 | 404:
        print("Bad Request")
    case 500 | 503:
        print("Internal Server Error")

print("---")

# matching with the or pattern

numbers = [1, 2, 3, 4]

# Output: All numbers: 1, 2, [3, 4]
match numbers:
    case [a]:
        print(f"One number: {a}")
    case [a, b]:
        print(f"Two numbers: {a} and {b}")
    case [a, b, *rest]:
        print(f"All numbers: {a}, {b}, {rest}")

print("---")

# matching with default value

response_code = 600

# Output: Unknown Error
match response_code:
    case 200 | 201:
        print("OK")
    case 400 | 404:
        print("Bad Request")
    case 500 | 503:
        print("Internal Server Error")
    case _:
        print("Unknown Error")

print("---")

# matching built in classes

response_code = 200

# Output: Response code is an integer
match response_code:
    case int():
        print("Response code is an integer")
    case str():
        print("Response code is a string")
    case _:
        print("Response code is of unknown type")
