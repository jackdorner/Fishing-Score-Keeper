public class Fish {
    private final char type;
    private final double length;

    public Fish(char type, double length){
        this.type = type;
        this.length = length;
    }

    public char getType() {
        return type;
    }

    public double getLength() {
        return length;
    }

    @Override
    public boolean equals(Object obj) {
        boolean temp = false;
        if(obj instanceof Fish){
            if (this.length == ((Fish) obj).length){
                temp = true;
            }
        }
        return temp;
    }
}
