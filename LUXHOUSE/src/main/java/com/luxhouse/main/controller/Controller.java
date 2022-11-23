package com.luxhouse.main.controller;

import java.util.HashMap;
import java.util.Map;

import com.luxhouse.main.model.DataLayoutMaster;

public abstract class Controller {
    
    protected DataLayoutMaster dataLayoutMaster = new DataLayoutMaster();
    
    protected Map<String, Object> objsDataLayout = new HashMap<String, Object>();
    
    protected String clientLayout = "client/client_layout";
    
    protected String clientLayoutForProfile = "client/account/layout_profile";
    
    protected String adminLayout = "admin/admin_layout";
    
    protected String __CONTENT__ = "content";
}
