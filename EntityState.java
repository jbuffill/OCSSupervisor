package org.lsst.ocs.supervisor;

import static java.lang.System.out;

/**
 *
 * EntityState is an abstract state base class
 *
 */

public abstract class EntityState extends DomainObject {

    Entity entity_;
    
    // cmd entity from [OfflineState,OfflineState[AvailableState]] to StandbyState
    // external entity usage
    public void enableControl(Entity entity) { out.println("error"); } 
    
    // cmd entity from StandbyState to [OfflineState,OfflineState[PublishOnlyState]]
    // external entity usage
    public void exitControl(Entity entity) { out.println("error"); }
    
    // Entity is in StandbyState & ready for start trigger
    // external entity usage
    //public void start(Entity entity) { 
    public void start() { out.println("error"); }
    
    // cmd entity from DisabledState to StandbyState
    public void standby(Entity entity) { out.println("error"); }
    
    // cmd entity from DisabledState to EnabledState
    // external entity usage??
    public void enable(Entity entity) { out.println("error"); }
    
    // cmd entity from EnabledState to DisabledState
    // external entity usage??
    public void disable(Entity entity) { out.println("error"); }
    
    // cmd OCS entity from [StandbyState,EnabledState,DisabledState] to FaultState
    public void fault(Entity entity) { out.println("error"); }
    
}
