# opening and closing files

import shutil
import gzip
import os


file = open("example.txt", "r")
# Perform file operations...
file.close()

# reading from files

file = open("example.txt", "r")
content = file.read()
print(content)  # Output: This is an example file.\nHello, World!
file.close()

print("---")

# writing to files

file = open("example.txt", "w")
file.write("This is an example file.\nHello, World!")
file.close()

# appending to files

file = open("example.txt", "a")
file.write("This is a new line\n")
file.close()

# file positions

file = open("example.txt", "r")
content = file.read(10)
print(content)  # Output: This is an
file.seek(0)
content = file.read(5)
print(content)  # Output: This
file.close()

print("---")

# file path and directory manipulation

file_path = os.path.join("folder", "example.txt")
directory = os.path.dirname(file_path)
filename = os.path.basename(file_path)

print(file_path)  # Output: folder/example.txt
print(directory)  # Output: folder
print(filename)  # Output: example.txt

print("---")

# error handling and exceptions

try:
    file = open("example.txt", "r")
    # Perform file operations...
    file.close()
except FileNotFoundError:
    print("File not found.")
except PermissionError:
    print("Permission denied.")

# file metadata

file_path = "example.txt"
size = os.path.getsize(file_path)
timestamp = os.path.getmtime(file_path)

print(size)  # Output: 57 # File size in bytes, will vary
print(timestamp)  # Output: 1713400857.752388 # Unix timestamp

print("---")

# file input and output using context managers

with open("example.txt", "r") as file:
    content = file.read()
    # Output: This is an example file.\nHello, World!This is a new line\n
    print(content)

    # File is automatically closed outside the context manager block.

print("---")

# working with binary files

with open("example.bin", "wb") as file:
    data = b"\x48\x65\x6c\x6c\x6f"
    file.write(data)

with open("example.bin", "rb") as file:
    content = file.read()
    print(content)  # Output: b'Hello'


# Compress file using gzip
with open("example.txt", "rb") as file_in, gzip.open("example.txt.gz", "wb") as file_out:
    shutil.copyfileobj(file_in, file_out)

# Extract file from gzip archive
with gzip.open("example.txt.gz", "rb") as file_in, open("example-out.txt", "wb") as file_out:
    shutil.copyfileobj(file_in, file_out)
