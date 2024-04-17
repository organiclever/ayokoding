# list

my_list = [1, 2, 3, 4, 5]
my_list_2 = [1, 2, "a", "b"]

# my_list:  [1, 2, 3, 4, 5] , type:  <class 'list'>
print("my_list: ", my_list, ", type: ", type(my_list))
# my_list_2:  [1, 2, 'a', 'b'] , type:  <class 'list'>
print("my_list_2: ", my_list_2, ", type: ", type(my_list_2))

print("---")

# tuple

my_tuple = (1, 2, 3, 4, 5)
my_tuple_2 = (1, 2, "a", "b")

# my_tuple:  (1, 2, 3, 4, 5) , type:  <class 'tuple'>
print("my_tuple: ", my_tuple, ", type: ", type(my_tuple))
# my_tuple_2:  (1, 2, 'a', 'b') , type:  <class 'tuple'>
print("my_tuple_2: ", my_tuple_2, ", type: ", type(my_tuple_2))

print("---")

# set

my_set = {1, 2, 3, 4, 5}
my_set_2 = {1, 2, "a", "b"}

# my_set:  {1, 2, 3, 4, 5} , type:  <class 'set'>
print("my_set: ", my_set, ", type: ", type(my_set))
# my_set_2:  {1, 2, 'a', 'b'} , type:  <class 'set'>
print("my_set_2: ", my_set_2, ", type: ", type(my_set_2))

print("---")

# dictionary

my_dict = {"name": "John Doe", "age": 25}

# my_dict:  {'name': 'John Doe', 'age': 25} , type:  <class 'dict'>
print("my_dict: ", my_dict, ", type: ", type(my_dict))

print("---")

# bytes

my_bytes = b"hello"

# my_bytes:  b'hello' , type:  <class 'bytes'>
print("my_bytes: ", my_bytes, ", type: ", type(my_bytes))

print("---")

# bytearray

my_bytearray = bytearray(5)

# my_bytearray:  bytearray(b'\x00\x00\x00\x00\x00') , type:  <class 'bytearray'>
print("my_bytearray: ", my_bytearray, ", type: ", type(my_bytearray))

print("---")

# range

my_range = range(1, 10)

# my_range:  range(1, 10) , type:  <class 'range'>
print("my_range: ", my_range, ", type: ", type(my_range))
