# creating a Bytearray:

my_bytearray = bytearray([65, 66, 67])
print(my_bytearray)  # Output: bytearray(b'ABC')

my_bytearray = bytearray(b'Hello')
print(my_bytearray)  # Output: bytearray(b'Hello')

print("---")

# accessing Individual Bytes:

my_bytearray = bytearray([65, 66, 67])
print(my_bytearray[0])  # Output: 65

print("---")

# slicing:

my_bytearray = bytearray([65, 66, 67, 68, 69])
print(my_bytearray[1:4])  # Output: bytearray(b'BCD')

print("---")

# length of Bytearray:

my_bytearray = bytearray([65, 66, 67])
length = len(my_bytearray)
print(length)  # Output: 3

print("---")

# mutable Updates:

my_bytearray = bytearray([65, 66, 67])
my_bytearray[0] = 68
print(my_bytearray)  # Output: bytearray(b'DBC')

print("---")

# concatenation:

bytearray1 = bytearray(b'Hello')
bytearray2 = bytearray(b' World')
result = bytearray1 + bytearray2
print(result)  # Output: bytearray(b'Hello World')

print("---")

# repetition:

my_bytearray = bytearray(b'\x00')
result = my_bytearray * 5
print(result)  # Output: bytearray(b'\x00\x00\x00\x00\x00')

print("---")

# iterating Over Bytes:

my_bytearray = bytearray(b'Hello')
for byte in my_bytearray:
    print(byte)  # Output: 72 101 108 108 111

print("---")

# converting Bytearray to a String:

my_bytearray = bytearray(b'Hello')
my_string = my_bytearray.decode()
print(my_string)  # Output: Hello

print("---")

# converting a String to Bytearray:

my_string = 'Hello'
my_bytearray = bytearray(my_string.encode())
print(my_bytearray)  # Output: bytearray(b'Hello')
