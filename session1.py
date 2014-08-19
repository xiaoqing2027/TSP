

def exp(a,n):
    if(n==0):
        return 1
    return a * exp(a,n-1)

print exp(2,0)
print exp(2,5)
print exp(3,3)

def exp(a,n):
    temp = 1
    if(n==0):
        return 1
    for i in range(0,n):
        temp = temp * a
    return temp

print exp(2,0)
print exp(3,5)
print exp(4,3)


