package com.coffeepp;

public abstract class FloorBase {

    private FloorBase up;
    private FloorBase down;
    private FloorBase left;
    private FloorBase right;
    private Movable entity;


    public Movable getEntity() {
        return entity;
    }

    public void setEntity(Movable entity) {
        this.entity = entity;
    }

    public FloorBase GetNeighbor(Direction d)
    {
        switch(d)
        {
            case up: return up;
            case down: return down;
            case left: return left;
            case right: return right;
            default: return up;
        }
    }

    public boolean Accept(Movable m, Direction d)
    {

        if(entity!=null) {
            entity = m;
            return true;
        }
        return false;
    }
    public void Remove(Movable m)
    {
        entity = null;
    }
    @Override
    public String toString() {
    	return "FloorBase";
    }
}
