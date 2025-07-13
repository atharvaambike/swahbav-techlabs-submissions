package com.aurionpro.delivery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DeliveryPartnerManager {
	private List<String> partners;

	public DeliveryPartnerManager(List<String> initialPartners) {
		this.partners = new ArrayList<>(initialPartners);
	}

	public List<String> getAllPartners() {
		return Collections.unmodifiableList(partners);
	}

	public void addPartner(String name) {
		partners.add(name);
	}

	public boolean removePartner(String name) {
		return partners.removeIf(p -> p.equalsIgnoreCase(name));
	}

	public String assignRandomPartner() {
		if (partners.isEmpty())
			return "No Partner Available";
		Random random = new Random();
		return partners.get(random.nextInt(partners.size()));
	}
}
