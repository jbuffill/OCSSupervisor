package org.lsst.ocs.supervisor;

import static java.lang.System.out;

/**
 *
 * StandbyState is a Concrete State class implementation
 * 
 * Transitions to: OfflineState, DisabledState or FaultState
 *
 */

public class StandbyState extends EntityState {

    // Entity is in StandbyState & ready for start trigger
    public StandbyState() { 
        
        Name_ = "StandbyState"; 
        // ready to receive start trigger
    }

    public StandbyState(EntityState state) { 
        
        Name_ = "StandbyState"; 
        // ready to receive start trigger
        
        this.entity_ = state.entity_;
    }

    public StandbyState(Entity entity) { 
        
        Name_ = "StandbyState"; 
        // ready to receive start trigger

        this.entity_ = entity;
    }

    /**
    @Override public void start(Entity entity) {
        
        out.println(this.toString() + ".start");
        if ( entity.type_ == EntityType.OCS ) {
            
            // 1. Publish SummaryState->StandbyState if not previously pub'd
            // 2. Publishes heartbeat; some configuration settings applied
            //    a. Publish Topic->SettingsApplied
            //    b. Publish Topic->SettingsVersion
            // 3. Cmd entity from StandbyState to DisabledState
            entity.setState(new DisabledState());
        }
        
        else {
            
            // Cmd TCS, CCS or DMCS via SAL via Sequencer
        }
    }
    */

    @Override public void start() {
        
        out.println(this.toString() + ".start");
        if ( this.entity_.type_ == EntityType.OCS ) {
            
            // 1. Publish SummaryState->StandbyState if not previously pub'd
            // 2. Publishes heartbeat; some configuration settings applied
            //    a. Publish Topic->SettingsApplied
            //    b. Publish Topic->SettingsVersion
            // 3. Cmd entity from StandbyState to DisabledState
            this.entity_.setState(new DisabledState());
        }
        
        else {
            
            // Cmd TCS, CCS or DMCS via SAL via Sequencer
        }
    }

    @Override public void fault(Entity entity) {
        
        out.println(this.toString() + ".fault");
        
        // Can't set other entities to FaultState, only myself
        if ( entity.type_ == EntityType.OCS ) {
            
            // 1. Publish SummaryState->StandbyState if not previously pub'd
            // 2. Set error code
            // 3. Cmd entity from StandbyState to FaultState
            entity.setState(new FaultState());
        }
    }

    @Override public void exitControl(Entity entity) {
        
        out.println(this.toString() + ".exitControl");

        if ( entity.type_.toString().equals( EntityType.OCS.toString() )) {
            
            // 1. Publish SummaryState->StandbyState if not previously pub'd
            // 2. Apply some settings
            // 3. Cmd entity from StandbyState to OfflineState
            entity.setState(new OfflineState());
        }
        
        else {
            // Cmd TCS, CCS or DMCS via SAL via Sequencer
            
        }
    }

}
