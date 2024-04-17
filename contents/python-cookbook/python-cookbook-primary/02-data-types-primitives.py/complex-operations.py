# arithmetic operations

# this module is used to perform complex number operations
import cmath

print("--- arithmetic operations ---")

a = 2 + 3j
b = 1 + 5j

# Addition
result = a + b
print(result)  # Output: (3+8j)

# Subtraction
result = a - b
print(result)  # Output: (1-2j)

# Multiplication
result = a * b
print(result)  # Output: (-13+13j)

# Division
result = a / b
print(result)  # Output: (0.6538461538461539-0.2692307692307692j)

# assignment operations

print("--- assignment operations ---")

a = 2 + 3j

# Addition assignment
a += 1 + 2j  # Equivalent to: a = a + (1 + 2j)
print(a)  # Output: (3+5j)

# Subtraction assignment
a -= 1 + 2j  # Equivalent to: a = a - (1 + 2j)
print(a)  # Output: (2+3j)

# Multiplication assignment
a *= 2  # Equivalent to: a = a * 2
print(a)  # Output: (4+6j)

# Division assignment
a /= -1 - 1j  # Equivalent to: a = a / (-1 - 1j)
print(a)  # Output: (-5-1j)

# comparison operations

print("--- comparison operations ---")
a = 2 + 3j
b = 1 + 5j

# Equal to
print(a == b)  # Output: False

# Not equal to
print(a != b)  # Output: True

# conjugate operations

print("--- conjugate operations ---")

z = 2 + 3j
conjugate_z = z.conjugate()
print(conjugate_z)  # Output: (2-3j)

# accessing real and imaginary part operations

print("--- accessing real and imaginary part operations ---")

z = 2 + 3j
real_part = z.real
imaginary_part = z.imag
print(real_part)  # Output: 2.0
print(imaginary_part)  # Output: 3.0

# absolute operations

print("--- absolute operations ---")

z = 2 + 3j
absolute_z = abs(z)
print(absolute_z)  # Output: 3.605551275463989

# phase operations

print("--- phase operations ---")

z = 2 + 3j
phase_z = cmath.phase(z)
print(phase_z)  # Output: 0.982793723247329

# complex number conversion operations

print("--- complex number conversion operations ---")

z = complex(2)
print(z)  # Output: (2+0j)
