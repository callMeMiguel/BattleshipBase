package edu.utep.cs.cs4330.battleship;

/**
 * A game board consisting of <code>size</code> * <code>size</code> places
 * where battleships can be placed. A place of the board is denoted
 * by a pair of 0-based indices (x, y), where x is a column index
 * and y is a row index. A place of the board can be shot at, resulting
 * in either a hit or miss.
 */
public class Board {

    /**
     * Size of this board. This board has
     * <code>size*size </code> places.
     */
    private final int size;
    private Place [] places;
    private int shots;


    /** Create a new board of the given size. */
    public Board(int size) {
        this.size = size;
        places = new Place[size^2];
        shots = 0;
        initPlaces();
    }

    private void initPlaces(){
        int i;
        for (int x = 0; x<size; x++){
            for (int y = 0; y<size; y++){
                i = (x*size)+y;
                places[i] = new Place(x,y);
            }
        }
    }

    /** Return the size of this board. */
    public int size() {
        return size;
    }

    // Suggestions:
    // 1. Consider using the Observer design pattern so that a client,
    //    say a BoardView, can observe changes on a board, e.g.,
    //    hitting a place, sinking a ship, and game over.
    //
    // 2. Introduce methods including the following:
    //    public boolean placeShip(Ship ship, int x, int y, boolean dir)
    //    public void hit(Place place)
    //    public Place at(int x, int y)
    //    public Place[] places()
    //    public int numOfShots()
    //    public boolean isGameOver()
    //    ...

    public boolean placeShip(Ship ship){
        //Check that stern and bow are inbounds
        //return false for collision or outof bounds
        int index;
        Place[] shipPlaces = ship.getPlaces();
        for (Place sp:shipPlaces){
            index = (sp.getX()*size)+sp.getY();
            if (inBounds(index) && !(places[index].isShip()))
                places[index].setShip(true);
            else
                return false;
        }
        return true;
    }

    public boolean hit(Place place){
        int xy = place.getX()*size+place.getY();
        if (inBounds(xy) && !(places[xy].isHit())){
            places[xy].setHit(true);
            shots++;
            return true;
        }
        return false;
    }

    private boolean inBounds(int i){
        return (i >= 0 && i < places.length);
    }


}
