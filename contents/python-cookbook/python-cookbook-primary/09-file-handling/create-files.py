# Create example.txt
with open("example.txt", "w") as file:
    file.write("This is an example file.\nHello, World!")

# Create example.bin
with open("example.bin", "wb") as file:
    data = bytearray([0x48, 0x65, 0x6c, 0x6c, 0x6f])
    file.write(data)

print("Files created successfully.")
