package logic;

/**
 * The interface that all input systems should implement
 */
public interface Input {

    /**
     * Updates position. Preferable but could be optional.
     */
    void getPos();

    /**
     * @return The X position of the move that the player made. This
     *         method is mandatory.
     */
    int getX();

    /**
     * @return The Y position of the move that the player made. This
     *         method is mandatory.
     */
    int getY();

}
