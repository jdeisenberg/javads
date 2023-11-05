public class MiniArrayList<T> {
    
    static final int DEFAULT_SIZE = 16;
    private int maxSize;
    private int lastIndex;
    private Object[] array;
    
    public MiniArrayList() {
        this(DEFAULT_SIZE);
    }
    
    public MiniArrayList(int startSize) {
        this.maxSize = startSize;
        this.lastIndex = 0;
        this.array = new Object[startSize];
    }
      
    public void append(T value) {
        if (this.lastIndex > this.maxSize - 1) {
            this.resize();
        }
        this.array[this.lastIndex] = value;
        this.lastIndex++;
    }
    
    private void resize() {
        int newSize = (this.maxSize < DEFAULT_SIZE) ?
            DEFAULT_SIZE : this.maxSize * 2;
        System.err.println("Resize to " + newSize);
        Object[] newArray = new Object[newSize];
        for (int i = 0; i < maxSize; i++) {
            newArray[i] = this.array[i];
        }
        this.maxSize = newSize;
        this.array = newArray;
    }
    
    public String toString() {
        String result = "[";
        for (int i = 0; i < this.lastIndex; i++) {
            result = result + this.array[i].toString();
            if (i != this.lastIndex - 1) {
                result = result + ", ";
            }
        }
        result += "]";
        return result;
    }
    
    public int size() {
        return this.lastIndex;
    }
    
    @SuppressWarnings("unchecked")
    public T getItem(int index) {
        if (index >= 0 && index < this.lastIndex) {
            return (T) array[index];
        } else {
            throw new IndexOutOfBoundsException(index);
        }
    }
    
    public void setItem(int index, T value) {
        if (index >= 0 && index < this.lastIndex) {
            array[index] = value;
        } else {
            throw new IndexOutOfBoundsException(index);
        }
    }
    
    public void insert(int index, T value) {
        if (index >= 0 && index <= this.lastIndex) {
            if (this.lastIndex > this.maxSize - 1) {
                this.resize();
            }
            for (int i = this.lastIndex; i > index - 1; i--) {
                this.array[i + 1] = this.array[i];
            }
            this.lastIndex++;
            this.array[index] = value;
        } else {
            throw new IndexOutOfBoundsException(index);
        }
    }
}
