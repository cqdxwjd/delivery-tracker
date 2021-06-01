package com.yunli.data.sync.core;

import java.util.ArrayList;

public class Fields extends ArrayList<String> {

    private static final long serialVersionUID = -174064216143075549L;

    public Fields() {
        super();
    }

    public Fields(String... fields) {
        super();
        for (String field : fields) {
            this.add(field);
        }
    }

}
