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

import java.lang.String;

/**
 *
 * EntityType is a type-safe constant type
 *
 */

public final class EntityType { // final class
    
    private String type_;
    
    // private constructor
    private EntityType(String type) { this.type_ = type; }
    
    @Override public String toString() { return this.type_; }
    
    public static final EntityType OCS  = new EntityType("OCS");
    public static final EntityType TCS  = new EntityType("TCS");
    public static final EntityType CCS  = new EntityType("CCS");
    public static final EntityType DMCS = new EntityType("DMCS");

}


//////////////////////////////////////////////////////////////
// OR
/**
 * 
public final class EntityType { 

    private EntityType() {}

    public static final EntityType OCS  = new EntityType();
    public static final EntityType TCS  = new EntityType();
    public static final EntityType CCS  = new EntityType();
    public static final EntityType DMCS = new EntityType();

}
 * 
 */


//////////////////////////////////////////////////////////////
// OR
/**
 *
public enum EntityType {

    OCS, TCS, CCS, DMCS
}
 *
 */
//////////////////////////////////////////////////////////////


