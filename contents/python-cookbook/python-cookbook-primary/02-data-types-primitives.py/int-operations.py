# arithmetic operations

print("--- arithmetic operations ---")

a = 10
b = 7

# Addition
sum = a + b
print(sum)  # Output: 17

# Subtraction
diff = a - b
print(diff)  # Output: 3

# Multiplication
product = a * b
print(product)  # Output: 70

# Division
quotient = a / b
print(quotient)  # Output: 1.4285714285714286

# Modulus
remainder = a % b
print(remainder)  # Output: 3

# Exponentiation
power = a ** b
print(power)  # Output: 10000000

# Floor Division
floor_division = a // b
print(floor_division)  # Output: 1

# assignment operations

print("--- assignment operations ---")

a = 5

# Addition assignment
a += 3  # Equivalent to: a = a + 3
print(a)  # Output: 8

# Subtraction assignment
a -= 2  # Equivalent to: a = a - 2
print(a)  # Output: 6

# Multiplication assignment
a *= 4  # Equivalent to: a = a * 4
print(a)  # Output: 24

# Division assignment
a /= 3  # Equivalent to: a = a / 3
print(a)  # Output: 8.0

# Modulus assignment
a %= 5  # Equivalent to: a = a % 5
print(a)  # Output: 3.0

# Exponentiation assignment
a **= 2  # Equivalent to: a = a ** 2
print(a)  # Output: 9.0

# Floor division assignment
a //= 2  # Equivalent to: a = a // 2
print(a)  # Output: 4.0

# comparison operations

print("--- comparison operations ---")

a = 5
b = 7

# Equal to
print(a == b)  # Output: False

# Not equal to
print(a != b)  # Output: True

# Greater than
print(a > b)  # Output: False

# Less than
print(a < b)  # Output: True

# Greater than or equal to
print(a >= b)  # Output: False

# Less than or equal to
print(a <= b)  # Output: True

# logical operations

print("--- logical operations ---")

a = True
b = False

# And
print(a and b)  # Output: False

# Or
print(a or b)  # Output: True

# Not
print(not a)  # Output: False

# bitwise operations

print("--- bitwise operations ---")

a = 5
b = 3

# Bitwise AND
result = a & b
print(result)  # Output: 1

# Bitwise OR
result = a | b
print(result)  # Output: 7

# Bitwise XOR
result = a ^ b
print(result)  # Output: 6

# Bitwise NOT
result = ~a
print(result)  # Output: -6

# Left Shift
result = a << 2
print(result)  # Output: 20

# Right Shift
result = a >> 1
print(result)  # Output: 2

# membership operations

print("--- membership operations ---")

a = 5
list1 = [1, 2, 3, 4, 5]

# In
print(a in list1)  # Output: True

# Not in
print(a not in list1)  # Output: False

# identity operations

print("--- identity operations ---")

a = 5
b = 5
c = [1, 2, 3]
d = [1, 2, 3]

# Is
print(a is b)  # Output: True
print(c is d)  # Output: False

# Is not
print(a is not b)  # Output: False
print(c is not d)  # Output: True
