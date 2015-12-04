import random
import argparse


parser = argparse.ArgumentParser()
parser.add_argument("-n", help="number of vertices", type=int, required=True)
parser.add_argument('--directed', dest='directed', action='store_true')
parser.add_argument('--undirected', dest='directed', action='store_false')
parser.set_defaults(directed=True)

args = parser.parse_args()

directed = args.directed

n = args.n

if directed:
    print 'true'
    print n
    print n * (n-1)
else:
    print 'false'
    print n
    print n * (n-1) /2

for i in range(0, n):
    for j in range(i+1, n):
        print i, j, random.uniform(1, 50)
        if directed:
            print j, i, random.uniform(1, 50)
