package com.hcl.demo.m02.d04.hospitaldemo.comparator;

import java.util.Comparator;

import com.hcl.demo.m02.d04.hospitaldemo.entity.Doctor;

public class DoctorNameComparator implements Comparator<Doctor> {
	
	public int compare(Doctor a, Doctor b) {
		return a.getName().compareTo(b.getName());
	}

}
