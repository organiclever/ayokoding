from types import NoneType

var = None

result = var is None
print(result)  # Output: True

result = var is not None
print(result)  # Output: False

result = type(var) is NoneType
print(result)  # Output: True
