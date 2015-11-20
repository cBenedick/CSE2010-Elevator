package project;

import java.sql.Time;

public class PassengerRequest implements Comparable<PassengerRequest>{
	
	public Time getTimePressedButton() {
		return time_pressed_button;
	}
	public void setTimePressedButton(Time time_pressed_button) {
		this.time_pressed_button = time_pressed_button;
	}
	public int getFloorFrom() {
		return floor_from;
	}
	public void setFloorFrom(int floor_from) {
		this.floor_from = floor_from;
	}
	public int getFloorTo() {
		return floor_to;
	}
	public void setFloorTo(int floor_to) {
		this.floor_to = floor_to;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public boolean getUp() {
        return up;
    }
    public void setUp(boolean up) {
        this.up = up;
    }

	private Time time_pressed_button;  // time when the button was pressed
	private int floor_from; // the floor from which the elevator was called
	private int floor_to; // the floor where the passenger is headed to
	private int weight; // weight, in pounds
	private boolean up;

	public PassengerRequest(Time time_pressed_button, int floor_from, int floor_to, int weight, boolean up) {

		this.time_pressed_button = time_pressed_button;
		this.floor_from = floor_from;
		this.floor_to = floor_to;
		this.weight = weight;
		this.up = up;
	}

    @Override
    public int compareTo(PassengerRequest other) {
        return this.getTimePressedButton().compareTo(other.getTimePressedButton());
    }
    
}
