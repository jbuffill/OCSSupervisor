package org.lsst.ocs.supervisor;

import java.lang.String;

public class DomainObject {

    public String Name_;

    @Override public String toString() {
        return Name_;
    }

    public DomainObject() {
    }

    public DomainObject(String name) {
        Name_ = name;
    }
    
}
