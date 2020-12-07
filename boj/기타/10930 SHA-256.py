import hashlib

a = input()
print(hashlib.sha256(a.encode()).hexdigest())
