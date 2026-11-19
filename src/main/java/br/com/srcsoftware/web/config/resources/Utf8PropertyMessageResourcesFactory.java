package br.com.srcsoftware.web.config.resources;

import org.apache.struts.util.MessageResources;
import org.apache.struts.util.PropertyMessageResourcesFactory;

public class Utf8PropertyMessageResourcesFactory extends PropertyMessageResourcesFactory {

	private static final long serialVersionUID = 1425805336777620275L;

	@Override
    public MessageResources createResources(String config) {
        return new Utf8PropertyMessageResources(this, config, this.returnNull);
    }
}