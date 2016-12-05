package org.lsst.ocs.supervisor;

import static java.lang.System.out;

/**
 *
 * FaultState is a Concrete State class implementation
 *
 */

public class FaultState extends EntityState {

    public FaultState() { Name_ = "FaultState"; }

    @Override public void fault(Entity entity) {
        
        out.println(this.toString() + ".fault");

        // Can't set other entities to FaultState, only myself
        if ( entity.type_ == EntityType.OCS ) {
            
            // 1. Publish SummaryState->FaultState if not previously pub'd
            //    a. Publish Topic->ErrorCode
            // 2. May read sensor data but control features disallowed
        }
    }

    @Override public void exitControl(Entity entity) {
        
        out.println(this.toString() + ".exitControl");

        if ( entity.type_.toString().equals( EntityType.OCS.toString() )) {
            
            // 1. Apply some settings
            // 2. Cmd entity from StandbyState to OfflineState
            entity.setState(new OfflineState());
        }
        
        else {
            // Cmd TCS, CCS or DMCS via SAL
        }
    }
    
}
