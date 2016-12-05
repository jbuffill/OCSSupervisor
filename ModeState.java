

package org.lsst.ocs.supervisor;

import static java.lang.System.out;

/**
 *
 * ModeState is an abstract state base class
 *
 */

//public abstract class ModeState extends DomainObject {
public class ModeState extends DomainObject {
    
    ModeState() {}
    ModeState(ModeState rhs) { this.mode_ = rhs.mode_; }
    
    private Mode mode_;
    public Mode Mode() { return this.mode_; }
    public void Mode(Mode mode) { this.mode_ = mode; }

    /**
    public void startNight(Entity entity) { // external entity usage
        
        out.println("error"); 
    }
    */
    
    public void startNight() { out.println("error"); }
    public void endNight()   { out.println("error"); }
    
    public void scienceNight()     {}
    public void engineeringNight() {}
    public void maintenanceNight() {}
    public void calibrationNight() {}

    /**
    public void scienceDay() {}
    public void engineeringDay() {}
    public void maintenanceDay() {}
    public void calibrationDay () {}
    */
    
}
