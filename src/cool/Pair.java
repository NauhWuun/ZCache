package cool;

public class Pair<T>
{
    private T left, right;

    public Pair(T left, T right) {
    	this.left = left;
    	this.right = right;
    }

    public T getLeft() {
        return left;
    }

    public T getRight() {
        return right;
    }
}