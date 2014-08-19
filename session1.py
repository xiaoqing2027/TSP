

def exp1(a,n):
    if(n==0):
        return 1
    return a * exp1(a,n-1)

print exp1(2,0)
print exp1(2,5)
print exp1(3,3)

def exp2(a,n):
    if(n==0):
        return 1
    temp = 1
    for i in range(0,n):
        temp = temp * a
    return temp

print exp2(2,0)
print exp2(3,5)
print exp2(4,3)

def exp3(a,n):
    if (n==0):
        return 1

    if(n%2==0):
        return exp3(a*a, n/2)
    else:
        return a*exp3(a*a, (n-1)/2)
    return

print exp3(2,0)
print exp3(5,3)
print exp3(2,8)






