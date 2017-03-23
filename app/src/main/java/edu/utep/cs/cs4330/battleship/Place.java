package edu.utep.cs.cs4330.battleship;


class Place {
    private int x;
    private int y;
    private boolean hit;
    private boolean ship;

    public Place(int x, int y){
        this.x = x;
        this.y = y;
        this.hit = false;
        this.ship = false;
    }

    public boolean isHit() {
        return hit;
    }

    public boolean isShip() {
        return ship;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public void setShip(boolean ship) {
        this.ship = ship;
    }

    public boolean equals(Place p){
        return(x==p.getX() && y==p.getY());
    }
}
