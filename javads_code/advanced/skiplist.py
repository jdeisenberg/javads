import random

class Stack:
    """Stack implementation as a list"""

    def __init__(self):
        """Create new stack"""
        self._items = []

    def is_empty(self):
        """Check if the stack is empty"""
        return not bool(self._items)

    def push(self, item):
        """Add an item to the stack"""
        self._items.append(item)

    def pop(self):
        """Remove an item from the stack"""
        return self._items.pop()

    def peek(self):
        """Get the value of the top item in the stack"""
        return self._items[-1]

    def size(self):
        """Get the number of items in the stack"""
        return len(self._items)
    
class HeaderNode:
    def __init__(self):
        self._next = None
        self._down = None

    @property
    def next(self):
        return self._next

    @next.setter
    def next(self, value):
        self._next = value

    @property
    def down(self):
        return self._down

    @down.setter
    def down(self, value):
        self._down = value
        
class DataNode:
    def __init__(self, key, value):
        self._key = key
        self._data = value
        self._next = None
        self._down = None

    @property
    def key(self):
        return self._key

    @property
    def data(self):
        return self._data

    @data.setter
    def data(self, value):
        self._data = value

    @property
    def next(self):
        return self._next

    @next.setter
    def next(self, value):
        self._next = value

    @property
    def down(self):
        return self._down

    @down.setter
    def down(self, value):
        self._down = value
        
class SkipList:
    def __init__(self):
        self._head = None
        
        
    def display(self):
        vertical = self._head
        while (vertical != None):
            horizontal = vertical.next
            while (horizontal != None):
                print(f"k/v: {horizontal.key}/{horizontal.data}", end="")
                if horizontal.next != None:
                    print("-->", end="")
                horizontal = horizontal.next
            print()
            vertical = vertical.down
            
            
    def search(self, key):
        current = self._head
        while current:
            if current.next is None:
                current = current.down
            else:
                if current.next.key == key:
                    return current.next.data  # found
                if key < current.next.key:
                    current = current.down
                else:
                    current = current.next
        return None

    def insert(self, key, value):
        if self._head is None:
            self._head = HeaderNode()
            temp = DataNode(key, value)
            self._head.next = temp
            top = temp
            while random.randrange(2) == 1:
                newhead = HeaderNode()
                temp = DataNode(key, value)
                temp.down = top
                newhead.next = temp
                newhead.down = self._head
                self._head = newhead
                top = temp
        else:
            tower = Stack()
            current = self._head
            while current:
                if current.next is None:
                    tower.push(current)
                    current = current.down
                else:
                    if current.next.key > key:
                        tower.push(current)
                        current = current.down
                    else:
                        current = current.next

            lowest_level = tower.pop()
            temp = DataNode(key, value)
            temp.next = lowest_level.next
            lowest_level.next = temp
            top = temp
            while random.randrange(2) == 1:
                if tower.is_empty():
                    newhead = HeaderNode()
                    temp = DataNode(key, value)
                    temp.down = top
                    newhead.next = temp
                    newhead.down = self._head
                    self._head = newhead
                    top = temp
                else:
                    next_level = tower.pop()
                    temp = DataNode(key, value)
                    temp.down = top
                    temp.next = next_level.next
                    next_level.next = temp
                    top = temp

sl = SkipList()
sl.insert(93, "of")
sl.insert(37, "in")
sl.insert(22, "be")
sl.insert(100, "to")
sl.insert(15, "am")
sl.display()