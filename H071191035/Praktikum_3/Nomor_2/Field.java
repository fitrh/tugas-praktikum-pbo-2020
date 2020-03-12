/**
 * Nomor 2 (Tambahan)
 */
class Field {

    private int bambooHeight[] = new int[10];

    public Field(int array[]) {
        bambooHeight = array;
    }

    // setter
    public void setBambooHeight(int i, int tinggi) {
        bambooHeight[i] = tinggi;
    }

    // getter
    public int getBambooHeight(int i) {
        return bambooHeight[i];
    }

    public int getMinTall() {
        int min = bambooHeight[0];

        for(int i : bambooHeight) {
            min = i < min ? i : min;
        }

        return min;
    }

    public int[] getBambooHeight() {
        return bambooHeight;
    }
}