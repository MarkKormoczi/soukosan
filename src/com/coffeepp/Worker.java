package com.coffeepp;

public class Worker extends Movable {

    /**
     * Holds the points of this worker.
     */
    private int points;

    /**
     * Retruns the accumulated points of this worker.
     */

    public Worker()
    {   this.setStrength(100); }
    public Worker(double _strength)
    {
        this.setStrength(_strength);
    }
    public int GetPoints()
    {
    	Logger l = new Logger();
    	l.enter(this, "GetPoints");
    	
    	l.exit(this, "GetPoints", Integer.toString(points));
        return points;
    }

    /**
     * Moves the worker in the specified direction.
     */
    public void Move(Direction d) {
        Logger l = new Logger();
        l.enter(this, "Move", d.toString());
        FloorBase fl = this.getPlace().GetNeighbor(d);
        if (fl.Accept(this, d, this.GetStrength())) {

            if (this.getPlace() != null)
                this.getPlace().Remove(this);
            this.setPlace(fl);
            //System.out.println("OK");
        }
    	l.exit(this, "Move", "void");
    }

    /**
     * Workes gets pushed. If called worker gets destroyed.
     * @param m The pusher that tries to push.
     * @param d The dirction which the worker was pushed.
     */
    @Override
    public boolean Push(Movable m, Direction d, double _strength)
    {
    	Logger l = new Logger();
    	l.enter(this, "Push", d.toString());

    	if(_strength>=this.GetStrength()) {
    	    if(this.getPlace().GetNeighbor(d).Accept(this, d, this.GetStrength()))
                this.Move(d);
    	    else
    	        this.Destroy();
        }


    	l.exit(this, "Push", "true");
        return true;
    }

    /**
     * Incrementing the point counter.
     */
    public void AddPoints()
    {
    	Logger l = new Logger();
    	l.enter(this, "AddPoints");
    	
    	this.points += 1;

    	l.exit(this, "AddPoints", "void");
    }

    /**
     * Removes the liquid from the floor where the worker stands
     */
    public Liquid RemoveLiquid()
    {
        this.getPlace().setLiquid(new Liquid('N'));
        //dont you get fooled by the method name....
        return this.getPlace().getLiquid();
    }
    /**
     * Lays the given liquid to the floor where the worker stands
     * @param
     */
    public Liquid LaysLiquid(Liquid _liquid)
    {
        this.getPlace().setLiquid(_liquid);
        return  this.getPlace().getLiquid();
    }

    /**
     * Returns that the worker can"t switch the traps
     */
    public boolean SwitchCapable()
    {
    	Logger l = new Logger();
    	l.enter(this, "SwitchCapable");
    	
    	l.exit(this, "SwitchCapable", "false");
        return false;
    }
    public Movable GetLasPusher()
    {
        System.out.println(this);
        return this;
    }
    @Override
    public String toString() {
    	return "Worker";
    }
}
