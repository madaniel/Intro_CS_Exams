package Question2;

class Range {
    private int _smallest, _largest;

    Range(int sm, int la) {
        _smallest = sm;
        _largest = la;
    }

    int getSmallest() {
        return _smallest;
    }

    int getLargest() {
        return _largest;
    }
}
