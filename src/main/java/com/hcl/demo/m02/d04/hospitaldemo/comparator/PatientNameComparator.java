package com.hcl.demo.m02.d04.hospitaldemo.comparator;

import java.util.Comparator;

import com.hcl.demo.m02.d04.hospitaldemo.entity.Patient;

public class PatientNameComparator implements Comparator<Patient> {
	
	public int compare(Patient a, Patient b) {
		return a.getName().compareTo(b.getName());
	}

}
