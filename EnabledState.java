package org.lsst.ocs.supervisor;

import static java.lang.System.out;

/**
 *
 * EnabledState is a Concrete State class implementation
 *
 * Transitions to: DisabledState or FaultState
 * 
 */

public class EnabledState extends EntityState {

    public EnabledState() { Name_ = "EnabledState"; }

    @Override public void enable(Entity entity) {
        
        out.println(this.toString() + ".enable");
        
        // 1. Publish SummaryState->EnabledState if not previously pub'd
        // 2. Check settings match (or differ) from start values
        //    a. Publish Topic->AppliedSettingsMatchStart (or they differ??)

        // Full control features are allowed
    }

    @Override public void disable(Entity entity) {

        out.println(this.toString() + ".disable");

        // 1. Cmd entity from StandbyState to DisabledState 
        entity.setState(new DisabledState());
    }

    @Override public void fault(Entity entity) {
        
        out.println(this.toString() + ".fault");
        
        // Can't set other entities to FaultState, only myself
        if ( entity.type_ == EntityType.OCS ) {
            
            // 1. Set error code
            // 2. Cmd entity from StandbyState to FaultState
            entity.setState(new FaultState());
        }
    }
    
}
