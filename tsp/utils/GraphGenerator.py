import random
import argparse


parser = argparse.ArgumentParser()
parser.add_argument("-n", help="number of vertices", type=int, required=True)
parser.add_argument('--coverage', help="1 for complete graph, other float indicating edge generation rate.", type=float, required=True)
parser.add_argument('--directed', dest='directed', action='store_true')
parser.add_argument('--undirected', dest='directed', action='store_false')
parser.set_defaults(directed=True)

args = parser.parse_args()

directed = args.directed

n = args.n
coverage = args.coverage
e = 0

if directed:
    print 'true'
    print n
else:
    print 'false'
    print n

edges = []
for i in range(0, n):
    for j in range(i+1, n):
        if random.random() < coverage:
            edges.add(" ".join(i, j, random.uniform(1, 100)))
            e+=1
        if directed and random.random() < coverage:
            edges.add(" ".join(j, i, random.uniform(1, 100)))
            e+=1

print e

for edge in edges:
    print edge
