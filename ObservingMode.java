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
 * ObservingMode is a type-safe constant type
 *
 */

public final class ObservingMode { // final class
    
    private String obsMode_;
    
    // private constructor
    private ObservingMode(String obsMode) { this.obsMode_ = obsMode; }
    
    @Override public String toString() { return this.obsMode_; }
    
    public static final ObservingMode SCI = new ObservingMode("SCI");
    public static final ObservingMode SCIENCE     = new ObservingMode("SCIENCE");

    public static final ObservingMode ENG = new ObservingMode("ENG");
    public static final ObservingMode ENGINEERING = new ObservingMode("ENGINEERING");

    public static final ObservingMode MNT = new ObservingMode("MNT");
    public static final ObservingMode MAINTENANCE = new ObservingMode("MAINTENANCE");

    public static final ObservingMode CAL = new ObservingMode("CAL");
    public static final ObservingMode CALIBRATION = new ObservingMode("CALIBRATION");

}

