package org.osgi.enroute.manager.provider;

import java.util.ArrayList;

import org.osgi.enroute.manager.api.Manager;
import org.osgi.service.component.annotations.Component;

@Component(name = "org.osgi.enroute.manager")
public class ManagerImpl implements Manager {

	ArrayList<String> components = new ArrayList<String>();

	@Override
	public void register(String componentName) {

		components.add(componentName);
		System.out.println("Registered " + componentName + " module @Manager");
	}

}
