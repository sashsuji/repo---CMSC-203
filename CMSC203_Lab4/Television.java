/** 
*The purpose of this class is to model a television
*Sash Sujith
*9/20/2020
*/

public class Television {
	//stores name of manufacturer
	private final String manufacturer;
	//stores size of TV screen
	private final int screenSize;
	//will hold the value true if the power is on, and false if the power is off
	private boolean powerOn;
	//will hold the value of the station that the television is showing.
	private int channel;
	//will hold a number value representing the loudness (0 being no sound)
	private int volume;
	//constructor that takes manufacturer brand name and screen size as
	//input and sets them. Also sets powerOn to off, volume to 20, and
	//channel to 2.
	public Television (String brand, int size) 
	{
		manufacturer=brand;
		screenSize=size;
		powerOn=false;
		volume=20;
		channel=2;
	}
	//returns volume value
	public int getVolume() {
		return volume;
	}
	//returns channel number
	public int getChannel() {
		return channel;
	}
	//returns brand name
	public String getManufacturer() {
		return manufacturer;
	}
	//returns screen size
	public int getScreenSize() {
		return screenSize;
	}
	//sets channel number	
	public void setChannel(int station){
		channel=station;
	}
	//changes TV power status from true to false and vice versa
	public void power() {
		powerOn = !powerOn;
	}
	//increases volume by one
	public void increaseVolume() {
		volume++;
	}
	//decreases volume by one
	public void decreaseVolume() {
		volume--;
	}
}
