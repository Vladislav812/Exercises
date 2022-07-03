class CustomStack {
    int maxSize;
    int[] st;
    int pointer;
    int[] inc;

    public CustomStack(int maxSize) {
        this.st = new int[maxSize];
        this.pointer = -1;
        this.maxSize = maxSize;
        inc = new int[maxSize];
    }

    public void push(int x) {
        if (pointer == maxSize - 1)
            return;
        pointer++;
        st[pointer] = x;
    }

    public int pop() {

        if (pointer == -1)
            return -1;
        int out = st[pointer] + inc[pointer];
        st[pointer] = 0;

        if (pointer != 0)
            inc[pointer - 1] = inc[pointer - 1] + inc[pointer];
        inc[pointer] = 0;

        pointer--;
        return out;
    }

    public void increment(int k, int val) {
        if (k > maxSize)
            inc[maxSize - 1] += val;
        else if (pointer == -1)
            return;
        else if (pointer > k - 1)
            inc[k - 1] += val;
        else inc[pointer] += val;
    }

    public void dump() {
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < maxSize; i++)
            System.out.print(st[i] + ", ");
        System.out.println();
        for (int i = 0; i < maxSize; i++)
            System.out.print(inc[i] + ", ");
        System.out.println("\n+++++++++++++++++++++++");


    }


    public static void main(String[] args) {
        CustomStack obj = new CustomStack(30);
        obj.increment(3, 40);
        obj.dump();
        obj.push(30);
        obj.dump();
        obj.increment(4, 63);
        obj.dump();
        obj.increment(2, 79);
        obj.dump();
        obj.increment(5, 57);
        obj.dump();
        System.out.println(obj.pop());
        obj.increment(5, 32);
    }
}

