import time
import serial
import sys


# configure the serial connections (the parameters differs on the device you are connecting to)
ser = serial.Serial(
    port='COM5',
    baudrate=9600,
    parity=serial.PARITY_NONE,
    stopbits=serial.STOPBITS_ONE,
    bytesize=serial.EIGHTBITS
)
ser.close()
ser.open()
ser.isOpen()
ser.write(sys.argv[1].encode())
out = ''
# let's wait one second before reading output (let's give device time to answer)
time.sleep(1)
while ser.inWaiting() > 0:
    out += ser.read(1)

if out != '':
    print(">>") + out
