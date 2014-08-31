class Stack:
    elements = []
    def push(self, element):
        self.elements.append(element)
    def pop(self):
        return self.elements.pop()
    def isEmpty(self):
        return len(self.elements)==0

    def top(self):
        return self.elements[len(self.elements)-1]
    def printf(self):
        print self.elements



def matches(a ,b):
    if a=='(' and b == ')':
        return True
    if a=='[' and b == ']':
        return True
    return False
        
def pairMatches(st):
    s=Stack()
    brackets = ['(',')','[',']']
    for character in st:
        if character in brackets:
            if character=='(' or character=='[':
                s.push(character)
            else:
                if s.isEmpty():
                    return False
                else:
                    if matches(s.top(),character):
                        s.pop()
                    else:
                        return False
    return s.isEmpty()



class Queue:
    def enqueue(self, element):
        self.elements.append(element)
    def dequeue(self):
        self.elements.popleft()
    def isEmpty(self):
        return len(self.elements)==0


s1 = "func(a[5])"
s2 = "func(a[5)]"

print pairMatches(s1)

print pairMatches(s2)









