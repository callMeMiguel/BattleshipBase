package edu.utep.cs.cs4330.battleship;



class Ship {
    private int size;
    private Place [] places;
    private boolean sunk;
    private boolean vertical;

    public Ship(int size, int x, int y, boolean vertical){
        this.size = size;
        this.vertical = vertical;
        this.sunk = false;
        initPlaces(x,y);
    }

    private void initPlaces(int x, int y){
        for (int i = 0; i < size; i++) {
            if(vertical)
                places[i] = new Place(x,(y+i));
            else
                places[i] = new Place((x=i), y);

        }
    }

    public boolean isSunk() {
        for (Place p: places){
            if (!p.isHit())
                return false;
        }
        return true;
    }

    public Place[] getPlaces() {
        return places;
    }
}
