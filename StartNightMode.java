
package org.lsst.ocs.supervisor;

import static java.lang.System.out;

/**
 *
 * StartNightMode is a Concrete State class implementation
 *
 */

public class StartNightMode extends ModeState {
    
    public StartNightMode() { Name_ = "StartNightMode"; }

    public StartNightMode(ModeState modeState) {
        
        //Initialize();
        //this.mode_ = modeState.mode_;
        this.Mode(modeState.Mode());
    }

    public StartNightMode(Mode mode) {
        
        //Initialize();
        //this.mode_ = mode;
        this.Mode(mode);
    }

    @Override public void startNight() {
        
        out.println(this.toString() + ".startNight");

        // 1. Sequencer comms...
        // 2. 
    }
    
    @Override public void endNight() {
        
        out.println(this.toString() + ".endNight");

        // 1. Sequencer comms...
        // 2. 
    }
    
}
