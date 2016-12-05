/*
 * Copyright (C) 2016 jbuffill
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package org.lsst.ocs.supervisor;

/**
 *
 * @author jbuffill
 */

public class Mode {
    
    private ModeState modeState_; //package-private member
    //ModeState modeState_; //package-private member
    //protected ModeState modeState_;
    public ModeState ModeState() { return this.modeState_; }
    public void ModeState(ModeState modeState) { this.modeState_ = modeState; }
    
    private Entity entity_;
    public Entity Entity() { return this.entity_; }
    public void Entity(Entity entity) { this.entity_  = entity; }
    //public Entity getEntity() { return entity_; }
    //public void setEntity(Entity entity) { entity_  = entity; }
    
    /**
    public Mode(ModeType type) { 

        modeState_ = new StartNightMode();
    }
    */

    public Mode(Entity entity) { 

        modeState_ = new StartNightMode(this);
        entity_ = entity;
    }

    /**
    public void scienceNight()
    {
        modeState_.scienceNight();
    }
    */

    public void startNight()
    {
        modeState_.startNight();
    }
    
}
