package org.lsst.ocs.supervisor;

import static java.lang.System.out;

/**
 *
 * DisabledState is a Concrete State class implementation
 *
 * Transitions to: StandbyState, EnabledState or FaultState
 * 
 */

public class DisabledState extends EntityState {

    // Entity has applied settings & may acquire data
    public DisabledState() { Name_ = "DisabledState"; }

    @Override public void disable(Entity entity) {
        
        out.println(this.toString() + ".disable");
        
        // 1. Publish SummaryState->DisabledState if not previously pub'd
        // 2. Entity reads/loads & applies control settings
        // 3. Cmd entity from DisabledState to EnabledState
        entity.setState(new EnabledState());
    }

    @Override public void standby(Entity entity) {

        out.println(this.toString() + ".standby");

        // 1. Cmd entity from DisabledState to StandbyState
        entity.setState(new StandbyState());
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
