package testandousb4java;


import javax.usb.UsbDevice;
import javax.usb.UsbException;
import testandousb4java.Usb4JavaHigh;
 
public class Testandousb4java {
 
	public static void main(final String[] args) throws UsbException {
 
		Usb4JavaHigh usb4java = new Usb4JavaHigh();
		UsbDevice usbDevice = usb4java.findDevice((short) (0x046D), (short) (0xC31C));
		
		usb4java.readMessage(usb4java.getDeviceInterface(usbDevice, 0), 0);
	}
 
}