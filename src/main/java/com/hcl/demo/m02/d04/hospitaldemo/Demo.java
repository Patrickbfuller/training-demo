package com.hcl.demo.m02.d04.hospitaldemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.hcl.demo.m02.d04.hospitaldemo.comparator.DoctorNameComparator;
import com.hcl.demo.m02.d04.hospitaldemo.comparator.DoctorSpecialtyComparator;
import com.hcl.demo.m02.d04.hospitaldemo.comparator.PatientAgeComparator;
import com.hcl.demo.m02.d04.hospitaldemo.comparator.PatientNameComparator;
import com.hcl.demo.m02.d04.hospitaldemo.entity.Doctor;
import com.hcl.demo.m02.d04.hospitaldemo.entity.Patient;

public class Demo {

	/**
	 * Sort collections of Doctors and Patients by each of their fields.
	 */

	public static void main(String[] args) {

		// Collection of Doctors
		List<Doctor> doctors = new ArrayList<>();
		doctors.add(new Doctor(51, "Joe", "Surgery"));
		doctors.add(new Doctor(55, "Albert", "Cardiology"));
		doctors.add(new Doctor(41, "Dennis", "Pediatrics"));

		// Collection of Patients
		List<Patient> patients = new ArrayList<>();
		patients.add(new Patient(35, "Winston", 60));
		patients.add(new Patient(20, "Caesar", 80));
		patients.add(new Patient(25, "Margaret", 70));

		// Sorting Doctors
		System.out.println("Starting list of doctors:");
		displayElements(doctors);

		Collections.sort(doctors);
		System.out.println("Sorted by id:");
		displayElements(doctors);

		Collections.sort(doctors, new DoctorNameComparator());
		System.out.println("Sorted by name:");
		displayElements(doctors);

		Collections.sort(doctors, new DoctorSpecialtyComparator());
		System.out.println("Sorted by specialty:");
		displayElements(doctors);

		// Sorting Patients
		System.out.println("Starting list of patients:");
		displayElements(patients);

		Collections.sort(patients);
		System.out.println("Sorted by id:");
		displayElements(patients);

		Collections.sort(patients, new PatientNameComparator());
		System.out.println("Sorted by name:");
		displayElements(patients);

		Collections.sort(patients, new PatientAgeComparator());
		System.out.println("Sorted by age:");
		displayElements(patients);

		// Functional Programming
		System.out.println("Also implemented with anonymous comparators");

		Collections.sort(patients, Patient::compareTo);
		System.out.println("Sorted by id:");
		displayElements(patients);

		Collections.sort(patients, Comparator.comparing(Patient::getName));
		System.out.println("Sorted by name:");
		displayElements(patients);

		Collections.sort(patients, (p1, p2) -> p1.getAge() - p2.getAge());
		System.out.println("Sorted by age:");
		displayElements(patients);

	}
	
	public static void displayElements(List<? extends Object> c) {
		
		for (Object object : c) {
			System.out.println("\t" + object);
		}
		
	}

}
