# creation

my_bytes = bytes([65, 66, 67])
print(my_bytes)  # Output: b'ABC'

my_bytes = b'Hello'
print(my_bytes)  # Output: b'Hello'

print("---")

# accessing individual bytes

my_bytes = bytes([65, 66, 67])
print(my_bytes[0])  # Output: 65

print("---")

# slicing

my_bytes = bytes([65, 66, 67, 68, 69])
print(my_bytes[1:4])  # Output: b'BCD'

print("---")

# length of bytes

my_bytes = bytes([65, 66, 67])
length = len(my_bytes)
print(length)  # Output: 3

print("---")

# concatenation

bytes1 = b'Hello'
bytes2 = b' World'
result = bytes1 + bytes2
print(result)  # Output: b'Hello World'

print("---")

# repetition

my_bytes = b'\x00'
result = my_bytes * 5
print(result)  # Output: b'\x00\x00\x00\x00\x00'

print("---")

# iterating over bytes

my_bytes = b'Hello'
for byte in my_bytes:
    print(byte)  # Output: 72 101 108 108 111

print("---")

# checking membership

my_bytes = b'Hello'
print(b'l' in my_bytes)  # Output: True
print(b'z' in my_bytes)  # Output: False

print("---")

# converting bytes to a string

my_bytes = b'Hello'
my_string = my_bytes.decode()
print(my_string)  # Output: Hello
print(type(my_string))  # Output: <class 'str'>

print("---")

# converting a string to bytes

my_string = 'Hello'
my_bytes = my_string.encode()
print(my_bytes)  # Output: b'Hello'
print(type(my_bytes))  # Output: <class 'bytes'>
