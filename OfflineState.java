package org.lsst.ocs.supervisor;

import static java.lang.System.out;

/**
 *
 * OfflineState is a Concrete State class implementation
 *
 */

public class OfflineState extends EntityState {

    public OfflineState() { Name_ = "OfflineState"; }

    @Override public void enableControl(Entity entity) {
        
        out.println(this.toString() + ".enableControl");

        // 1. Publish SummaryState->OfflineState if not previously pub'd
        // 2. Some configuration
        // 3. Cmd entity from OfflineState[AvailableState] to StandbyState
        entity.setState(new StandbyState());
    }
    
    @Override public void exitControl(Entity entity) {
        
        out.println(this.toString() + ".exitControl");

        if ( entity.type_.toString().equals( EntityType.OCS.toString() )) {
            
            // 1. Publish SummaryState->OfflineState if not previously pub'd
            // 2. Shutdown gracefully
        }
        
        else {
            // Cmd TCS, CCS or DMCS via SAL via Sequencer
            
        }
    }

}
