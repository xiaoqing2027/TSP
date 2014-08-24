

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
    

print exp3(2,0)
print exp3(5,3)
print exp3(2,8)


def exp4(a,n):
    if (n==0):
        return 1
    if(n%2==0):
        temp1=a*a
        temp2=1
        for i in range (n/2):
            temp2= temp1*temp2
        return temp2
    else:
        temp3=a*a
        temp4=1
        for i in range((n-1)/2):
            temp4=temp3*temp4
        return a*temp4

print exp4(2,0)
print exp4(3,5)
print exp4(2,7)
print exp4(2,10)

def exp5(a,n):
    output = 1
    temp=a
    while(n!=0):
        if (n%2==1):
            output=output*temp
        temp=temp*temp
        n=n/2
    return output

print exp5(2,0)
print exp5(5,3)
print exp5(2,8)












