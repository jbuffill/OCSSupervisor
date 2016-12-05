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

/**
 *
 * Supervisor is the Context class implementation
 *
 */

public class Supervisor  {
    
    public static void main(String[] args) {

    /**************************/
    /***    OCS STM Init    ***/
    /**************************/

        // 1. Wait for StartNight cmd from operator
        ObservingMode observingMode;
        
        // OCS Entity object created & initialized to StandbyState
        //Entity ocsEntity = new Entity(EntityType.OCS, observingMode);
        Entity ocsEntity = new Entity(EntityType.OCS, ObservingMode.SCIENCE);
        
        // 2. Verify OCS SummaryState of 'StandbyState'
        //    Trigger OCS start
        ocsEntity.start();
        
        // 3. Verify settings; verify OCS SummaryState of 'DisabledState'
        //    Trigger OCS enableControl
        ocsEntity.enableControl();
        
        // 4. Verify settings; verify OCS SummaryState of 'EnabledState'
        //    Trigger OCS enable
        ocsEntity.enable();

        
    /**************************/
    /***    TCS STM Init    ***/
    /**************************/
    
        // TCS Entity object created
        Entity tcsEntity = new Entity(EntityType.TCS);
        
        // 1. check/wait for TCS SummaryState of 'OfflineState[AvailableState]'
        // 2. cmd tcs to StandbyState
        tcsEntity.enableControl();
    
    } 
    
}
