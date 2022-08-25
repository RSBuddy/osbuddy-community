package com.rsbuddy.osrs.game;

public interface MenuSortListener {
    void sort(int count, int[] actionParams0, int[] actionParams1, int[] typeIds, int[] targetIds, int[] itemIds, String[] actions, String[] options, boolean[] forceActions);


    /**
     * Generic swap method
     *
     * @param array the array to perform the swap on
     * @param i     the index to swap with j
     * @param j     the index to swap with i
     */
    default <Obj> void swap(Obj[] array, int i, int j) {
        Obj temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Swap method for ints
     *
     * @param array the array to perform the swap on
     * @param i     the index to swap with j
     * @param j     the index to swap with i
     */
    default void swap(int[] array, int i, int j) {
        array[i] = (array[i] + array[j]) - (array[j] = array[i]);
    }

    /**
     * Swap method for booleans
     *
     * @param array the array to perform the swap on
     * @param i     the index to swap with j
     * @param j     the index to swap with i
     */
    default void swap(boolean[] array, int i, int j) {
        boolean temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    default void swap(final int i, final int j, final int[] actionParams0, final int[] actionParams1, final int[] typeIds,
                     final int[] targetIds, final String[] actions, final String[] options, final boolean[] forced) {
        swap(actionParams0, i, j);
        swap(actionParams1, i, j);
        swap(typeIds, i, j);
        swap(targetIds, i, j);
        swap(actions, i, j);
        swap(options, i, j);
        swap(forced, i, j);
    }

}
