package com.masai;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Planner {

	 public static void main(String[] args) {
	        Instrument[] instruments = {
	                new Instrument(3, 2, 10),
	                new Instrument(4, 3, 15),
	                new Instrument(2, 1, 8),
	                new Instrument(5, 4, 20)
	        };

	        int maxWeight = 10;
	        int maxVolume = 7;

	        List<Instrument> selectedInstruments = selectInstrumentsrequired(instruments, maxWeight, maxVolume);

	        System.out.println("Selected Instruments:-");
	        for (Instrument instrument : selectedInstruments) {
	            System.out.println("Weight: " + instrument.weight + " kg, Volume: " + instrument.volume +
	                    " m^3, Scientific Value:" + instrument.scientificValue);
	        }

	        int total_Weight = selectedInstruments.stream().mapToInt(i -> i.weight).sum();
	        int total_Volume = selectedInstruments.stream().mapToInt(i -> i.volume).sum();
	        int total_ScientificValue = selectedInstruments.stream().mapToInt(i -> i.scientificValue).sum();

	        System.out.println("Total Weight: " + total_Weight + " kg");
	        System.out.println("Total Volume: " + total_Volume + " m^3");
	        System.out.println("Total Scientific Value: " + total_ScientificValue);
	    }

	    public static List<Instrument> selectInstrumentsrequired(Instrument[] instruments, int maxweight, int maxvolume) {
	        List<Instrument> selectedInstruments = new ArrayList<>();

//	         scientific value in descending order
	        List<Instrument> sortedInstruments = new ArrayList<>();
	        for (Instrument instrument : instruments) {
	            sortedInstruments.add(instrument);
	        }
	        sortedInstruments.sort(Comparator.comparingInt(i -> -i.scientificValue));

	        // select instruments until reaching weight or volume capacity
	        for (Instrument instrument : sortedInstruments) {
	            if (instrument.weight <= maxweight && instrument.volume <= maxvolume) {
	                selectedInstruments.add(instrument);
	                maxweight -= instrument.weight;
	                maxvolume -= instrument.volume;
	            }
	        }

	        return selectedInstruments;
	    }

}
