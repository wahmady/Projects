#keeps the trees short using ranks and path compression = speeding up
class Disjoint_Sets:
    def __init__(self):
        self.parent = {}
        self.rank = {}
     #aka makeset
    def add_node(self,data):
        self.parent[data] = data
        self.rank[data] = 0

    def union(self,set1,set2):
        root1,root2 = self.find(set1),self.find(set2)
        if root1 == root2:
            return
        elif self.rank[root1] > self.rank[root2]:
            self.parent[root2] = root1
        else:
            self.parent[root1] = root2
            if self.rank[root2] == self.rank[root1]:
                self.rank[root2] += 1
    #path compression: once a node ceases to be a root, it never comes up again
    #in fact, its rank never changes. Overtime, you dont need to iterate find that much
    def find(self,node):
        if self.parent[node] != node:
            self.parent[node] = self.find(self.parent[node])
        else:
            return self.parent[node]
