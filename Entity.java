/*
 * LSST Observatory Control System (OCS) Software
 * Copyright 2008-20116 AURA/LSST.
 * 
 * This product includes software developed by the
 * LSST Project (http://www.lsst.org/) with contributions made at LSST partner
 * institutions.  The list of partner institutions is found at:
 * http://www.lsst.org/lsst/about/contributors .
 * 
 * Use and redistribution of this software is covered by the GNU Public License 
 * Version 3 (GPLv3) or later, as detailed below.  A copy of the GPLv3 is also 
 * available at <http://www.gnu.org/licenses/>.
 */

package org.lsst.ocs.supervisor;

import static java.lang.System.out;
import java.lang.String;


/**
 *
 * Entity is a Context class implementation
 *
 */

public class Entity {
    
    protected ObservingMode observingMode_;
    private Mode mode_;
    public Mode Mode() { return this.mode_; }
    
    /** The state/type of Commandable Entity **/
    protected EntityType type_;
    private EntityState state_;
    public EntityState EntityState() { return this.state_; }
    
    public Entity(EntityType type) { 

        // Starting up & initial transition to StandbyState
        this.type_ = type;
        //state_ = new StandbyState();
        this.state_ = new StandbyState(this);
        this.mode_ = new Mode(this);
        //mode_.modeState_ = new StartNightMode(mode_);
        mode_.ModeState(new StartNightMode(this.mode_));
        
        // Can start here or in Main
        // this.state_.start();
        
        // Publish SummaryState of 'StandbyState' if OCS
    }

    public Entity(EntityType type, ObservingMode observingMode) { 

        // Starting up & initial state = StandbyState
        this.type_ = type;
        this.observingMode_ = observingMode;
        //state_ = new StandbyState();
        this.state_ = new StandbyState(this);
        this.mode_ = new Mode(this);
        
        // Publish SummaryState of 'StandbyState' if OCS
    }

    // The initial configuration setting for the device. 
    //_configurationState = new ProductionConfigurationState(this);

    public String getObservingMode() { return observingMode_.toString(); }
    public Mode getMode() { return this.mode_; }
    public void setMode(Mode mode) { this.mode_ = mode; }
    //public String getMode() { return observingMode_.toString(); }
    //public void setMode(EntityState state) { mode_ = state; }

    // Delegate to the mode state object & pass the this ptr
    //public void startNight() { mode_.startNight(this); }
    public void startNight() { this.mode_.startNight(); }
    public void endNight()   { out.println("error"); }
    //public void startNight() { out.println("error"); }
    //public void endNight()   { out.println("error"); }
    //public void startDay()   { out.println("error"); }
    //public void endDay()     { out.println("error"); }
    

    public String getType() { return type_.toString(); }
    public void setState(EntityState state) { this.state_ = state; }
    public EntityState getState() { return this.state_; }

    // Delegate to the entity state object & pass the this ptr
    public void enableControl() { this.state_.enableControl(this); }
    public void exitControl()   { this.state_.exitControl(this); }
    //public void start()         { state_.start(this); }
    public void start()         { this.state_.start(); }
    public void standby()       { this.state_.standby(this); }
    public void enable()        { this.state_.enable(this); }
    public void disable()       { this.state_.disable(this); }
        
}
